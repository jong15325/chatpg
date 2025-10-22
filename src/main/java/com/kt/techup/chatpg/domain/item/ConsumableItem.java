package com.kt.techup.chatpg.domain.item;

import com.kt.techup.chatpg.domain.equipment.EquipmentType;
import com.kt.techup.chatpg.domain.player.Stats;

import lombok.Getter;

@Getter
public class ConsumableItem extends Item {

	public ConsumableItem(int itemId, String itemName, Stats stats,
		String description) {
		super(itemId, ItemType.CONSUMABLE, itemName, stats, description);
	}
}
