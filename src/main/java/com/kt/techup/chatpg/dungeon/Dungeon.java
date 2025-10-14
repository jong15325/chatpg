package com.kt.techup.chatpg.dungeon;

import com.kt.techup.chatpg.monster.Monster;
import com.kt.techup.chatpg.monster.MonsterManager;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Dungeon {
	private int floorLevel;
	private MonsterManager monsterManager;

	public Monster spawnMonster() {
		return monsterManager.createMonsterByLevel(floorLevel);
	}

	public void nextFloor() {
		floorLevel++;
	}

}
