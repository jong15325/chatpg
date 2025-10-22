package com.kt.techup.chatpg.domain.equipment;

import java.util.EnumMap;

import com.kt.techup.chatpg.domain.item.Item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class Equipment {
	/**
	 * equipmentType, inventory index
	 */
	private final EnumMap<EquipmentType, Integer> equippedItems;

	public Equipment() {
		this.equippedItems = new EnumMap<>(EquipmentType.class);
	}
}
