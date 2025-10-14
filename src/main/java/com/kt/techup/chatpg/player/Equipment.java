package com.kt.techup.chatpg.player;

import lombok.Getter;

@Getter
public class Equipment {
	String name;
	int attackBoost;
	int defenseBoost;
	int hpBoost;

	public Equipment(String name, int attackBoost, int defenseBoost, int hpBoost) {
		this.name = name;
		this.attackBoost = attackBoost;
		this.defenseBoost = defenseBoost;
		this.hpBoost = hpBoost;
	}

}
