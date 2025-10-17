package com.kt.techup.chatpg.domain.equipment;

import java.util.EnumMap;

import com.kt.techup.chatpg.domain.item.Item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EquipmentManager {

	private final EnumMap<EquipmentType, Item> equippedMap = new EnumMap<>(EquipmentType.class);
	private final InventoryManger inventoryManager;

	public void equipItem() {
		if (item.getEquipmentType() == null) {
			throw new IllegalArgumentException("장비 아이템이 아닙니다.");
		}
		equippedMap.put(item.getEquipmentType(), item);
	}

	public void unequipItem(EquipmentType type) {
		equippedMap.remove(type);
	}

	public Item getEquippedItem(EquipmentType type) {
		return equippedMap.get(type);
	}



/*
	// 현재 장착된 장비 출력
	public void showEquipped() {

		for (int i = 0; i < EquipmentType.values().length; i++) {
			Equipment item = equippedMap.get(EquipmentType.values()[i]);

			if (item != null) {
				PrintHelper.centerAlignPt("[ " + item.getName() +
					" (ATK +" + item.getAttackBoost() +
					", DEF +" + item.getDefenseBoost() +
					", HP +" + item.getHpBoost() + ") ]");
			} else {
				PrintHelper.centerAlignPt(i + ": 장비 없음");
			}
		}

		PrintHelper.centerAlignPt("장착된 장비 변경은 인벤토리에서 변경가능합니다");
		PrintHelper.centerAlignPt("이동하시겠습니까? (y/n)");
	}

	// 인벤토리 출력
	public void showInventory() {
		if (inventory.isEmpty()) {
			PrintHelper.centerAlignPt("빈 인벤토리입니다.");
		} else {
			for (int i = 0; i < inventory.size(); i++) {
				Equipment item = inventory.get(i);
				boolean equipped = equippedMap.containsValue(item);

				PrintHelper.centerAlignPt((i + 1) + ". " + item.getName() +
					" (ATK +" + item.getAttackBoost() +
					", DEF +" + item.getDefenseBoost() +
					", HP +" + item.getHpBoost() + ") " + (equipped ? "[장착중]" : ""));
			}
		}
	}*/

}
