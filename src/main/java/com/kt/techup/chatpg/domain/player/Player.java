package com.kt.techup.chatpg.domain.player;

import java.util.ArrayList;

import com.kt.techup.chatpg.domain.equipment.EquipmentManager;

import lombok.Data;

@Data
public class Player {

	private final String name;
	private int level;
	private int hp;
	private int attack;
	private int defense;
	private int exp;
	private final EquipmentManager equipmentManager;

	public Player(String name, int level, int hp, int attack, int defense) {
		this.name = name;
		this.level = level;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.exp = 0;
		this.equipmentManager = new EquipmentManager(new ArrayList<>());
	}
}
