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
	private final EquipmentType equipmentType;

	public EquipmentItem(int itemId, ItemType itemType, EquipmentType equipmentType, String itemName,
		int attackBoost, int defenseBoost, int hpBoost, int spBoost, String description) {
		super(itemId, itemType, itemName, description, new Stats(hpBoost, spBoost, attackBoost, defenseBoost));
		this.equipmentType = equipmentType;
	}

	/**
	 * 특정 장비 슬롯에 장착 가능한지 확인합니다
	 */
	public boolean isEquippableAt(EquipmentType slot) {
		return this.equipmentType == slot;
	}
}
