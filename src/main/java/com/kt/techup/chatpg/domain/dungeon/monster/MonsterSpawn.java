package com.kt.techup.chatpg.domain.dungeon.monster;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MonsterSpawn {
	private final int monsterLevel;
	private final int spawnRate;  // 확률 (%)

	/**
	 * 누적 확률 계산용
	 */
	public boolean isInRange(int randomValue, int cumulativeRate) {
		return randomValue < cumulativeRate + spawnRate;
	}
}
