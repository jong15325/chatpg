package com.kt.techup.chatpg.domain.player;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

import com.kt.techup.chatpg.domain.equipment.Equipment;
import com.kt.techup.chatpg.domain.equipment.EquipmentManager;
import com.kt.techup.chatpg.domain.equipment.EquipmentType;
import com.kt.techup.chatpg.domain.inventory.Inventory;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Player {

	private final String name;
	private int level;
	private int hp;
	private int attack;
	private int defense;
	private int exp;

	private final EnumMap<EquipmentType, Equipment> equippedItems;
	private final Inventory inventory;

	public Player(String name) {
		this.name = name;
		this.level = 1;
		this.hp = 100;
		this.attack = 10;
		this.defense = 5;
		this.exp = 0;
		this.equippedItems = new EnumMap<>(EquipmentType.class);
		this.inventory = new Inventory(new ArrayList<>());
	}

}
