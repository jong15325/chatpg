package com.kt.techup.chatpg.domain.dungeon.monster;

import lombok.Getter;

@Getter
public class Monster {

	private final MonsterData type;

	public Monster(MonsterData type) {
		this.type = type;
	}
}
