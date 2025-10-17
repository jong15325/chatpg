package com.kt.techup.chatpg.domain.item;

import com.kt.techup.chatpg.domain.equipment.EquipmentType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Item {
	private final int itemId;
	private final ItemType itemType;
	private final EquipmentType equipmentType;
	private final ItemTier itemTier; // common, rare, epic, legendary
	private final int itemLevel;
	private final String itemName;
	private final int attackBoost;
	private final int defenseBoost;
	private final int hpBoost;
	private final int itemAmout;
	private final String description;
}
