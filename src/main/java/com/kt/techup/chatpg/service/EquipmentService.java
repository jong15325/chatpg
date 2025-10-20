package com.kt.techup.chatpg.service;

import java.util.EnumMap;

import org.springframework.stereotype.Service;

import com.kt.techup.chatpg.domain.equipment.Equipment;
import com.kt.techup.chatpg.domain.equipment.EquipmentType;
import com.kt.techup.chatpg.domain.inventory.Inventory;
import com.kt.techup.chatpg.domain.item.Item;
import com.kt.techup.chatpg.domain.player.Player;
import com.kt.techup.chatpg.helper.PrintHelper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EquipmentService {

	// 장착 장비 리스트
	public void showEquipped(Player player) {
		Item weapon = player.getEquippedItems().get(EquipmentType.WEAPON).getItem();
		Item helmet = player.getEquippedItems().get(EquipmentType.HELMET).getItem();
		Item armor = player.getEquippedItems().get(EquipmentType.ARMOR).getItem();
		Item boots = player.getEquippedItems().get(EquipmentType.BOOTS).getItem();
		Item accessory = player.getEquippedItems().get(EquipmentType.ACCESSORY).getItem();

		if(weapon != null)
			PrintHelper.centerAlignPt("[ 무기 ] : " + weapon.getItemName() + "(ATK +" + weapon.getAttackBoost() + ", DEF +" + weapon.getDefenseBoost() + ", HP +" + weapon.getHpBoost() + ")");
		if(helmet != null)
			PrintHelper.centerAlignPt("[ 투구 ] : " + helmet.getItemName() + "(ATK +" + helmet.getAttackBoost() + ", DEF +" + helmet.getDefenseBoost() + ", HP +" + helmet.getHpBoost() + ")");
		if(armor != null)
			PrintHelper.centerAlignPt("[ 갑옷 ] : " + armor.getItemName() + "(ATK +" + armor.getAttackBoost() + ", DEF +" + armor.getDefenseBoost() + ", HP +" + armor.getHpBoost() + ")");
		if(boots != null)
			PrintHelper.centerAlignPt("[ 신발 ] : " + boots.getItemName() + "(ATK +" + boots.getAttackBoost() + ", DEF +" + boots.getDefenseBoost() + ", HP +" + boots.getHpBoost() + ")");
		if(accessory != null)
			PrintHelper.centerAlignPt("[ 악세사리 ] : " + accessory.getItemName() + "(ATK +" + accessory.getAttackBoost() + ", DEF +" + accessory.getDefenseBoost() + ", HP +" + accessory.getHpBoost() + ")");

		PrintHelper.centerAlignPt("장착된 장비 변경은 인벤토리에서 변경가능합니다");
		PrintHelper.centerAlignPt("이동하시겠습니까? (y/n)");
	}

	public boolean isEquipped(Player player, Item item) {

		EnumMap<EquipmentType, Equipment> equippedItems = player.getEquippedItems();

		for (Equipment equipment : equippedItems.values()) {
			if (equipment != null && equipment.getItem().equals(item)) {
				return true;
			}
		}

		return false;
	}

	public boolean equip(Player player, int inventoryNumber) {
		Inventory inventory = player.getInventory();

		if(inventoryNumber < 1 || inventoryNumber > inventory.getItems().size()) {
			return false;
		}

		Item itemToEquip = inventory.getItems().get(inventoryNumber - 1);
		EquipmentType equipmentType = itemToEquip.getEquipmentType();


		// 이미 장착된 장비가 있는지

		if(isEquipped(player, itemToEquip)) {

			//장비 장착 해제를 인벤토리에서 제거할지 말지 고민
			PrintHelper.centerAlignPt("이미 장착된 장비가 있습니다. 먼저 장비를 해제해주세요.");
			return false;
		}

		return true;
	}
}
