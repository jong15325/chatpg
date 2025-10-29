package com.kt.techup.chatpg.domain.dungeon.monster;

import com.kt.techup.chatpg.domain.player.Stats;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class Monster {

	private final MonsterData monster;
	private final MonsterRank rank;
	private final Stats baseStats;
	private final Stats totalStats;
	private Stats currentStats;

	public Monster(MonsterData monster) {
		this(monster, MonsterRank.NORMAL);
	}

	public Monster(MonsterData type, MonsterRank rank) {
		this.monster = type;
		this.rank = rank;
		this.baseStats = new Stats(
			type.getHp(),
			0,
			type.getAttack(),
			type.getDefense()
		);
		this.totalStats = calculateTotalStats(baseStats, rank);
		this.currentStats = totalStats;
	}

	/**
	 * 몬스터 스탯 계산
	 * @param base
	 * @param rank
	 * @return
	 */
	private Stats calculateTotalStats(Stats base, MonsterRank rank) {
		int finalHp = (int) (base.getHp() * rank.getStatsMultiplier());
		int finalSp = 0;
		int finalAttack = (int) (base.getAttack() * rank.getStatsMultiplier());
		int finalDefense = (int) (base.getDefense() * rank.getStatsMultiplier());

		return new Stats(finalHp, finalSp, finalAttack, finalDefense);
	}

	/**
	 * 몬스터 경험치 배율 계산
	 * @return 몬스터 랭크에 따른 경험치 반환
	 */
	public int getExpReward() {
		return (int) (monster.getExpReward() * rank.getRewardMultiplier() * 1.0);
	}

	/**
	 * 몬스터가 받은 데미지 계산
	 * @param damage
	 * @return 몬스터 체력 반환
	 */
	public int takeDamage(int damage) {
		int actualDamage = Math.max(1, damage - totalStats.getDefense());
		int beforeHp = this.currentStats.getHp();
		this.currentStats = new Stats(
			Math.max(0, this.currentStats.getHp() - actualDamage),
			0,
			monster.getAttack(),
			monster.getDefense()
		);
		return beforeHp - this.getCurrentStats().getHp();  // 실제 받은 데미지 반환
	}

	/**
	 * 몬스터 사망 여부
	 * @return 죽었으면 true, 살아있으면 false
	 */
	public boolean isDead() {
		return this.currentStats.getHp() <= 0;
	}

}
