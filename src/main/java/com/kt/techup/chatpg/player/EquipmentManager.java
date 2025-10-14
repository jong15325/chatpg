package com.kt.techup.chatpg.player;

import java.util.EnumMap;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EquipmentManager {

	private final EnumMap<EquipmentEnum, Equipment> equippedMap = new EnumMap<>(EquipmentEnum.class);
	private final List<Equipment> inventory;

	// 장비 장착
	public boolean equip(Equipment equipment) {
		if (!inventory.contains(equipment)) {
			System.out.println("아이템이 인벤토리에 없습니다.");
			return false;
		}

		equippedMap.put(equipment.getType(), equipment);
		System.out.println(equipment.getName() + " 장비를 장착했습니다.");

		return true;
	}

	// 장비 해제
	public boolean unequip(EquipmentEnum slot) {
		if (equippedMap.containsKey(slot)) {
			Equipment removed = equippedMap.remove(slot);
			System.out.println(removed.getName() + " 장비를 해제했습니다.");
			return true;
		}

		return false;
	}



	// 현재 장착된 장비 출력
	public void showEquipped() {
		System.out.println("============================== 현재 장착 장비 ==============================");

		for (EquipmentEnum slot : EquipmentEnum.values()) {
			Equipment item = equippedMap.get(slot);

			if (item != null) {
				System.out.println("[" + item.getName() +
					" (ATK +" + item.getAttackBoost() +
					", DEF +" + item.getDefenseBoost() +
					", HP +" + item.getHpBoost() + ") ]");
			} else {
				System.out.println(slot + ": 장비 없음");
			}
		}

		System.out.println("==========================================================================");
	}

	// 인벤토리 출력
	public void showInventory() {
		System.out.println("============================== 인벤토리 ==============================");
		if (inventory.isEmpty()) {
			System.out.println("빈 인벤토리입니다.");
		} else {
			for (int i = 0; i < inventory.size(); i++) {
				Equipment item = inventory.get(i);
				boolean equipped = equippedMap.containsValue(item);

				System.out.println((i + 1) + ". " + item.getName() +
					" (ATK +" + item.getAttackBoost() +
					", DEF +" + item.getDefenseBoost() +
					", HP +" + item.getHpBoost() + ") " + (equipped ? "[장착중]" : ""));
			}
		}
		
		System.out.println("=====================================================================");
	}

}
