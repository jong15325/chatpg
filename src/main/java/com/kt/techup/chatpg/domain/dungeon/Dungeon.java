package com.kt.techup.chatpg.domain.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kt.techup.chatpg.domain.dungeon.monster.Monster;
import com.kt.techup.chatpg.domain.dungeon.monster.MonsterData;
import com.kt.techup.chatpg.domain.dungeon.monster.MonsterRank;
import com.kt.techup.chatpg.helper.MonsterSpawnHelper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Dungeon {

	private int currentFloor;
	private int clearedFloors;
	private boolean normalMonsterDefeated;
	private boolean eliteDiscovered;
	private final Random random;

	public Dungeon() {
		this.currentFloor = 1;
		this.clearedFloors = 0;
		this.normalMonsterDefeated = false;
		this.eliteDiscovered = false;
		this.random = new Random();
	}

	/**
	 * 던전 층 입장 시 초기화
	 */
	public void enterFloor() {
		this.normalMonsterDefeated = false;
		this.eliteDiscovered = false;
	}

	/**
	 * 다음 던전 이동
	 */
	public void nextFloor() {
		this.currentFloor++;
		this.clearedFloors++;
		enterFloor();
	}

	/**
	 * 이전 던전 이동
	 */
	public void previousFloor() {
		this.currentFloor--;
		this.clearedFloors--;
		enterFloor();
	}

	/**
	 * 보스 층 여부
	 * @return
	 */
	public boolean isBossFloor() {
		return MonsterSpawnHelper.isBossFloor(currentFloor);
	}

	/**
	 * 일반 몬스터 처치
	 */
	public void defeatNormalMonster() {
		this.normalMonsterDefeated = true;

		// 보스 층이 아닐 때만 엘리트 던전 발견
		if (!isBossFloor()) {
			this.eliteDiscovered = true;
		}
	}

	/**
	 * 엘리트 던전 도전 가능 여부
	 * @return 가능하면 true, 불가능하면 false
	 */
	public boolean canChallengeElite() {
		return normalMonsterDefeated && eliteDiscovered && !isBossFloor();
	}

	/**
	 * 몬스터 스폰
	 * @param rank
	 * @return 출현 몬스터 반환
	 */
	public Monster spawnMonster(MonsterRank rank) {

		// 몬스터 결정
		MonsterData monster = MonsterSpawnHelper.selectMonster(currentFloor);

		return new Monster(monster, rank);
	}

}
