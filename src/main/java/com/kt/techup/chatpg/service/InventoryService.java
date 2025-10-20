package com.kt.techup.chatpg.service;

import org.springframework.stereotype.Service;

import com.kt.techup.chatpg.domain.item.Item;
import com.kt.techup.chatpg.domain.player.Player;
import com.kt.techup.chatpg.helper.PrintHelper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InventoryService {

	public void welcomInventory() {
		PrintHelper.centerAlignPt("내 빈털터리 가방 오픈!");
	}

	public void leaveInventory() {
		PrintHelper.centerAlignPt("내 빈털터리 가방 닫기!");
	}

	// 인벤토리 리스트
	public void showInventory(Player player) {
		if (player.getInventory().getItems().isEmpty()) {
			PrintHelper.centerAlignPt("빈 인벤토리입니다.");
		} else {
			for (int i = 0; i < player.getInventory().getItems().size(); i++) {
				Item item = player.getInventory().getItems().get(i);

				PrintHelper.centerAlignPt((i + 1) + ". " + item.getItemName() +
					" (ATK +" + item.getAttackBoost() +
					", DEF +" + item.getDefenseBoost() +
					", HP +" + item.getHpBoost() + ")");
			}
		}
	}

	public boolean hasItem(Player player, Item item) {
		return player.getInventory().getItems().contains(item);
	}


	// 아이템 추가
	public boolean addItem(Player player, Item item) {
		return player.getInventory().getItems().add(item);
	}

	// 아이템 제거
	public boolean removeItem(Player player, Item item) {
		if(!hasItem(player, item)) {
			PrintHelper.centerAlignPt("인벤토리에 아이템이 없습니다.");
			return false;
		}

		return player.getInventory().getItems().remove(item);
	}
}
