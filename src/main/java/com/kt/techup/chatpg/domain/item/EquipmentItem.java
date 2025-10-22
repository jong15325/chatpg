package com.kt.techup.chatpg.domain.item;

import com.kt.techup.chatpg.domain.equipment.EquipmentType;
import com.kt.techup.chatpg.domain.player.Stats;

import lombok.Getter;

/**
 * 장비 아이템을 나타내는 클래스
 * 무기, 방어구, 악세서리 등 장착 가능한 모든 아이템을 포함합니다
 */
@Getter
public class EquipmentItem extends Item {
	private final ItemTier tier;
	private final int itemLevel;

	public EquipmentItem(int itemId, EquipmentType equipmentType, ItemTier tier, int itemLevel, String itemName,
		Stats stats, String description) {
		super(itemId, ItemType.EQUIPMENT, itemName, stats, description);
		this.tier = tier;
		this.itemLevel = itemLevel;
	}
}
