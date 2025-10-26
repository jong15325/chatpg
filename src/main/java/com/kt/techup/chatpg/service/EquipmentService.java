package com.kt.techup.chatpg.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kt.techup.chatpg.domain.equipment.EquipmentType;
import com.kt.techup.chatpg.domain.inventory.Inventory;
import com.kt.techup.chatpg.domain.item.EquipmentItem;
import com.kt.techup.chatpg.domain.item.Item;
import com.kt.techup.chatpg.domain.item.ItemType;
import com.kt.techup.chatpg.domain.player.Player;
import com.kt.techup.chatpg.domain.player.Stats;
import com.kt.techup.chatpg.helper.PrintHelper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EquipmentService {

	public void welcomMsg() {
		PrintHelper.centerAlignPt("내 장착 장비 오픈!");
	}

	public void leaveMsg() {
		PrintHelper.centerAlignPt("내 장착 장비 닫기!");
	}

	/**
	 * 장착된 장비 목록 출력
	 * @param player
	 */
	public void showEquipped(Player player) {
		for (EquipmentType type : EquipmentType.values()) {
			if (type == EquipmentType.NONE) {
				continue;
			}
			
			Optional<Item> itemOpt = player.getEquipment().getEquippedItem(type, player.getInventory());

			if (itemOpt.isPresent()) {
				Item item = itemOpt.get();
				Stats stats = item.getStats();
				
				if (stats != null) {
					PrintHelper.centerAlignPt("[ " + type.getDescription() + " ] " +
						item.getItemName() +
						" (HP +" + stats.getHp() +
						", SP +" + stats.getSp() +
						", ATK +" + stats.getAttack() +
						", DEF +" + stats.getDefense() +
						")"
					);
				} else {
					PrintHelper.centerAlignPt("[ " + type.getDescription() + " ] " + item.getItemName());
				}
			} else {
				PrintHelper.centerAlignPt("[ " + type.getDescription() + " ] 장착된 아이템이 없습니다");
			}
		}

		PrintHelper.centerAlignPt("장착된 장비 변경은 인벤토리에서 변경가능합니다");
	}


	private Optional<EquipmentItem> validateInventoryItem(Player player, int inventoryId) {
		Inventory inventory = player.getInventory();
		Optional<Item> itemOpt = inventory.getItemByIdx(inventoryId);

		//아이템 존재 여부 확인
		if(itemOpt.isEmpty()) {
			PrintHelper.centerAlignPt("인벤토리에 해당 아이템이 없습니다.");
			return Optional.empty();
		}

		Item item = itemOpt.get();

		// 장비 아이템인지 확인
		if (item.getItemType() != ItemType.EQUIPMENT) {
			PrintHelper.centerAlignPt("해당 아이템은 장비 아이템이 아닙니다.");
			return Optional.empty();
		}

		return Optional.of((EquipmentItem) item);
	}

	// 이미 장착된 장비인지 확인 후 해제
	public void checkUnEquipIfNeeded(Player player, EquipmentType slotType) {
		player.getEquipment().getEquippedId(slotType).ifPresent(_inventoryId -> {
			// 기존 장비 해제
			player.getEquipment().unEquipItem(slotType);
			PrintHelper.centerAlignPt(equippedItem.getItemName() + " 장비를 해제했습니다.");
		});
	}



	/**
	 * 아이템 장착
	 * @param player
	 * @param inventoryId
	 */
	public void equipItem(Player player, int inventoryId) {
		// 인벤토리에서 아이템 정보 조회
		Inventory inventory = player.getInventory();
		Optional<Item> itemOpt = inventory.getItemByIdx(inventoryId);

		// 아이템 존재 여부 확인
		if(itemOpt.isPresent()) {

			Item item = itemOpt.get();

			// 아이템이 장비인지 확인
			if(item.getItemType() != ItemType.EQUIPMENT) {
				PrintHelper.centerAlignPt("해당 아이템은 장비 아이템이 아닙니다.");
				return;
			}

			// 어떤 부위인지 확인
			EquipmentItem equipItem = (EquipmentItem) item;
			EquipmentType slotType = equipItem.getEquipmentType();

			// 해당 부위에 이미 장착된 아이템 확인
			if(player.getEquipment().isEquippedByType(slotType)) {
				Item equippedItem = player.getEquipment().getEquippedItem(slotType, inventory).get();

				player.getEquipment().getEquippedId(slotType).ifPresent(_inventoryId -> {
					// 기존 장비 해제
					player.getEquipment().unEquipItem(slotType);
					PrintHelper.centerAlignPt(equippedItem.getItemName() + " 장비를 해제했습니다.");
				});
			}

			// 장착
			player.getEquipment().equipItem(slotType, inventoryId);
			PrintHelper.centerAlignPt(item.getItemName() + " 장비를 장착했습니다.");

		} else {
			PrintHelper.centerAlignPt("인벤토리에 해당 아이템이 없습니다.");
		}
	}

	public void unEquipItem(Player player, int inventoryId) {

	}
}
