package com.kt.techup.chatpg.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kt.techup.chatpg.domain.dungeon.monster.Monster;
import com.kt.techup.chatpg.domain.dungeon.monster.MonsterData;
import com.kt.techup.chatpg.domain.dungeon.monster.MonsterRank;

/**
 *packageName    : com.kt.techup.chatpg.domain.dungeon
 * fileName       : DungeonCalcSpawn
 * author         : howee
 * date           : 2025-10-28
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-10-28        howee       최초 생성
 */

public class MonsterSpawnHelper {

	private static final Random random = new Random();

		/**
		 * 보스 층 여부
		 * @param floor
		 * @return
		 */
	public static boolean isBossFloor(int floor) {
		return floor % 5 == 0;
	}

	/**
	 * 출현 가능 몬스터 반환
	 * @param floor
	 * @return
	 */
	public static List<MonsterData> getAvailableMonsters(int floor) {
		List<MonsterData> availableMonsters = new ArrayList<>();

		for (MonsterData monster : MonsterData.values()) {
			if (monster.canSpawnAt(floor)) {
				availableMonsters.add(monster);
			}
		}

		return availableMonsters;
	}

	/**
	 * 일반 또는 정예 몬스터 선택
	 * @param floor
	 * @return
	 */
	public static MonsterData selectMonster(int floor) {
		if (isBossFloor(floor)) {
			return selectBossMonster(floor);
		}

		return selectNormalOrEliteMonster(floor);
	}

	/**
	 * 보스 몬스터 선택
	 * @param floor
	 * @return
	 */
	private static MonsterData selectBossMonster(int floor) {
		List<MonsterData> availableMonsters = getAvailableMonsters(floor);

		if (availableMonsters.isEmpty()) {
			throw new IllegalStateException("보스 층 " + floor + "에 출현 가능한 몬스터가 없습니다!");
		}

		// 랜덤으로 보스 선택
		return availableMonsters.get(random.nextInt(availableMonsters.size()));
	}

	/**
	 * 일반 또는 정예 몬스터 선택
	 * @param floor
	 * @return
	 */
	private static MonsterData selectNormalOrEliteMonster(int floor) {
		List<MonsterData> availableMonsters = getAvailableMonsters(floor);

		if (availableMonsters.isEmpty()) {
			throw new IllegalStateException(floor + "층에 출현 가능한 몬스터가 없습니다!");
		}

		// 랜덤으로 몬스터 선택
		return availableMonsters.get(random.nextInt(availableMonsters.size()));
	}

}
