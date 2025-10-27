package com.kt.techup.chatpg.domain.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class Stats {
	private int hp;
	private int sp;
	private int attack;
	private int defense;

	public Stats(int hp, int sp, int attack, int defense) {
		this.hp = hp;
		this.sp = sp;
		this.attack = attack;
		this.defense = defense;
	}

	/**
	 * 다른 스탯을 현재 스탯에 더함
	 * @param addStats
	 */
	public void addStats(Stats addStats) {
		this.hp += addStats.hp;
		this.sp += addStats.sp;
		this.attack += addStats.attack;
		this.defense += addStats.defense;
	}

	/**
	 * 다른 스탯을 현재 스탯에서 뺌
	 * @param subStats
	 */
	public void subtractStats(Stats subStats) {
		this.hp -= subStats.hp;
		this.sp -= subStats.sp;
		this.attack -= subStats.attack;
		this.defense -= subStats.defense;
	}

	/**
	 * 현재 스탯을 복사하여 반환
	 * @return
	 */
	public Stats copy() {
		return new Stats(this.hp, this.sp, this.attack, this.defense);
	}

	/**
	 * 0 미만의 스탯을 보정 반환
	 * @return
	 */
	public Stats normalize() {
		return new Stats(
			Math.max(0, this.hp),
			Math.max(0, this.sp),
			Math.max(0, this.attack),
			Math.max(0, this.defense)
		);
	}

}
