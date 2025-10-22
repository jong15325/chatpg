package com.kt.techup.chatpg.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kt.techup.chatpg.domain.equipment.EquipmentType;
import com.kt.techup.chatpg.domain.item.Item;
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
	
	/**
	 * 특정 부위에 장비가 장착되어 있는지 확인
	 * @param player
	 * @param equipmentType
	 * @return 있으면 true 없으면 false
	 */
	public boolean isEquipped(Player player, EquipmentType equipmentType) {
		return player.getEquipment().getEquippedItem(equipmentType, player.getInventory()).isPresent();
	}
}
