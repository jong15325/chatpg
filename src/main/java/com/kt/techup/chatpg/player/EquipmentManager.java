package com.kt.techup.chatpg.player;

import java.util.ArrayList;
import java.util.List;

public class EquipmentManager {

	private Equipment weapon;
	private Equipment helmet;
	private Equipment armor;
	private Equipment boots;
	private Equipment accessory;

	// 장비 장착
	public boolean equip(Equipment item) {
		if (!inventory.contains(item)) {
			System.out.println("아이템이 인벤토리에 없습니다.");
			return false;
		}

		switch (item.getName().toLowerCase()) { // 예제에서는 이름 기준, 실제론 타입 필드 이용 권장
			case "weapon":
				weapon = item;
				break;
			case "helmet":
				helmet = item;
				break;
			case "armor":
				armor = item;
				break;
			case "boots":
				boots = item;
				break;
			case "accessory":
				accessory = item;
				break;
			default:
				System.out.println("알 수 없는 장비 부위입니다.");
				return false;
		}
		System.out.println(item.getName() + " 장비를 장착했습니다.");
		return true;
	}

	// 장비 해제
	public void unequip(String slot) {
		switch (slot.toLowerCase()) {
			case "weapon":
				weapon = null;
				break;
			case "helmet":
				helmet = null;
				break;
			case "armor":
				armor = null;
				break;
			case "boots":
				boots = null;
				break;
			case "accessory":
				accessory = null;
				break;
			default:
				System.out.println("알 수 없는 장비 부위입니다.");
				return;
		}
		System.out.println(slot + " 장비를 해제했습니다.");
	}

	// 현재 장착된 장비 출력
	public void showEquipped() {
		System.out.println("현재 장착 장비:");
		System.out.println("무기: " + (weapon != null ? weapon.getName() : "없음"));
		System.out.println("헬멧: " + (helmet != null ? helmet.getName() : "없음"));
		System.out.println("갑옷: " + (armor != null ? armor.getName() : "없음"));
		System.out.println("부츠: " + (boots != null ? boots.getName() : "없음"));
		System.out.println("악세사리: " + (accessory != null ? accessory.getName() : "없음"));
	}

	// 인벤토리 출력
	public void showInventory() {
		System.out.println("인벤토리:");
		if (inventory.isEmpty()) {
			System.out.println("빈 인벤토리입니다.");
		} else {
			for (Equipment item : inventory) {
				System.out.println("- " + item.getName());
			}
		}
	}

	// 필요한 getter/setter 추가 가능
	public Equipment getWeapon() { return weapon; }
	public Equipment getHelmet() { return helmet; }
	public Equipment getArmor() { return armor; }
	public Equipment getBoots() { return boots; }
	public Equipment getAccessory() { return accessory; }
	public List<Equipment> getInventory() { return inventory; }

}
