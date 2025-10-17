package com.kt.techup.chatpg.domain.player;

import java.util.ArrayList;
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

	private final Map<EquipmentType, Equipment> equippedItems;
	private final Inventory inventory;

}
