package com.kt.techup.chatpg.common;

import lombok.Getter;

@Getter
public abstract class Character implements CharacterActions {

	protected String name;
	protected int level;
	protected int hp;
	protected int attack;
	protected int defense;

	public Character(String name, int level, int hp, int attack, int defense) {
		this.name = name;
		this.level = level;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
	}

	public boolean isAlive() {
		return hp > 0;
	}
}
