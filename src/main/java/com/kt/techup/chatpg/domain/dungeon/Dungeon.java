package com.kt.techup.chatpg.domain.dungeon;

import com.kt.techup.chatpg.domain.dungeon.monster.MonsterManager;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Dungeon {

	private int floorLevel;
	private MonsterManager monsterManager;

}
