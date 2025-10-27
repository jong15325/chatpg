package com.kt.techup.chatpg.domain.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kt.techup.chatpg.domain.dungeon.monster.Monster;
import com.kt.techup.chatpg.domain.dungeon.monster.MonsterData;
import com.kt.techup.chatpg.domain.dungeon.monster.MonsterRank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Dungeon {

	private int currentFloor;
	private final Random random;

	// 던전 진행 상태
	private int clearedFloors;

	/**
	 * 다음 층으로 이동
	 */
	public boolean descend() {
		if (currentFloor >= 25) {
			return false;
		}
		currentFloor++;
		clearedFloors++;
		return true;
	}

	/**
	 * 현재 방 타입 결정
	 */
	public DungeonRoomType determineRoomType() {
		// 5층마다 보스
		if (currentFloor % 5 == 0) {
			return DungeonRoomType.BOSS;
		}

		int rand = random.nextInt(100);

		if (rand < 60) {
			return DungeonRoomType.NORMAL;
		} else if (rand < 75) {
			return DungeonRoomType.ELITE;
		} else if (rand < 85) {
			return DungeonRoomType.TREASURE;
		} else if (rand < 92) {
			return DungeonRoomType.REST;
		} else if (rand < 97) {
			return DungeonRoomType.SHOP;
		} else {
			return DungeonRoomType.EVENT;
		}
	}

	/**
	 * 몬스터 스폰
	 * @param roomType
	 * @return 출현 몬스터 반환
	 */
	public Monster spawnMonster(DungeonRoomType roomType) {
		// 몬스터 레벨 결정
		int monsterLevel = DungeonSpawnCalculator.selectMonsterLevel(currentFloor);

		// 몬스터 등급 결정
		MonsterRank rank = determineMonsterRank(roomType);

		// 몬스터 데이터 선택
		MonsterData monsterData = selectRandomMonsterByLevel(monsterLevel);

		return new Monster(monsterData, rank);
	}

	/**
	 * 방 타입에 따른 몬스터 등급 결정
	 */
	private MonsterRank determineMonsterRank(DungeonRoomType roomType) {
		return switch (roomType) {
			case BOSS -> MonsterRank.BOSS;
			case ELITE -> MonsterRank.ELITE;
			default -> MonsterRank.NORMAL;
		};
	}

	/**
	 * 특정 레벨의 몬스터 중 랜덤 선택
	 */
	private MonsterData selectRandomMonsterByLevel(int level) {
		List<MonsterData> monstersOfLevel = new ArrayList<>();

		for (MonsterData monster : MonsterData.values()) {
			if (monster.getLevel() == level) {
				monstersOfLevel.add(monster);
			}
		}

		if (monstersOfLevel.isEmpty()) {
			return MonsterData.values()[0];
		}

		return monstersOfLevel.get(random.nextInt(monstersOfLevel.size()));
	}

	/**
	 * 몬스터 처치 기록
	 */
	public void recordMonsterKill() {
		totalMonsterKilled++;
	}

}
