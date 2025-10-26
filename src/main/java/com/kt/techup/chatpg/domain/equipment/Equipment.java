package com.kt.techup.chatpg.domain.equipment;

import java.util.EnumMap;
import java.util.Optional;

import com.kt.techup.chatpg.domain.inventory.Inventory;
import com.kt.techup.chatpg.domain.item.Item;
import com.kt.techup.chatpg.domain.item.ItemType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Equipment {

	private final EnumMap<EquipmentType, Integer> equippedItems;

	/**
	 * 특정 부위에 장착된 아이템의 인벤토리 id를 반환
	 * @param type 장비 슬롯 타입 (무기, 투구, 갑옷 등)
	 * @return 인벤토리 ID, 장착되지 않은 경우 empty
	 */
	public Optional<Integer> getEquippedId(EquipmentType type) {
		return Optional.ofNullable(equippedItems.get(type));
	}

	/**
	 * 특정 부위의 장착된 아이템의 정보를 반환
	 * @param type 장비 슬롯 타입 (무기, 투구, 갑옷 등)
	 * @param inventory Item List
	 * @return Item 정보 (아이템 번호, 이름, 스탯, 설명)
	 */
	public Optional<Item> getEquippedItem(EquipmentType type, Inventory inventory) {
		return Optional.ofNullable(equippedItems.get(type))
			.flatMap(inventory::getItemByIdx);
	}

	public boolean isEquippedByType(EquipmentType type) {
		return equippedItems.containsKey(type);
	}

	public void equipItem(EquipmentType type, int inventoryId) {
		equippedItems.put(type, inventoryId);
	}

	public void unEquipItem(EquipmentType type) {
		equippedItems.remove(type);
	}

	public boolean isEquippedById(int inventoryId) {
		return equippedItems.values().stream()
			.anyMatch(id -> id == inventoryId);
	}
}
