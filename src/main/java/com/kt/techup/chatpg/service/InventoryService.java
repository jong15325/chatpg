package com.kt.techup.chatpg.service;

import org.springframework.stereotype.Service;

import com.kt.techup.chatpg.domain.inventory.Inventory;
import com.kt.techup.chatpg.domain.item.Item;
import com.kt.techup.chatpg.domain.player.Player;
import com.kt.techup.chatpg.helper.PrintHelper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InventoryService {

	public void welcomeMsg() {
		PrintHelper.centerAlignPt("내 빈털터리 가방 오픈!");
	}

	public void leaveMsg() {
		PrintHelper.centerAlignPt("내 빈털터리 가방 닫기!");
	}

	/**
	 * 인벤토리 오픈 시 인벤토리의 아이템 정보 출력 없으면 "빈 인벤토리 출력"
	 * @param inventory
	 */
	public void showInventory(Inventory inventory) {
		if (inventory.getItems().isEmpty()) {
			PrintHelper.centerAlignPt("빈 인벤토리입니다.");
		} else {
			for (int i = 0; i < inventory.getItems().size(); i++) {
				Item item = inventory.getItems().get(i);

				PrintHelper.centerAlignPt((i + 1) + ". " + item.getItemName() +
					" (HP +" + item.getStats().getHp() +
					", SP +" + item.getStats().getSp() +
					", ATK +" + item.getStats().getAttack() +
					", DEF +" + item.getStats().getDefense() +
					")"
				);
			}
		}
	}
}
