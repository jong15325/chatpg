package com.kt.techup.chatpg.service;

import org.springframework.stereotype.Service;

import com.kt.techup.chatpg.domain.inventory.InventoryManager;
import com.kt.techup.chatpg.domain.item.Item;
import com.kt.techup.chatpg.domain.player.Player;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InventoryService {

	private final InventoryManager inventoryManager;

	// 인벤토리 리스트
	public void showInventory(Player player) {
		inventoryManager.showInventory(player);
	}

	// 아이템 추가
	public void addItem(Player player, Item item) {
		inventoryManager.addItem(player, item);
	}

	// 아이템 제거
	public void removeItem(Player player, Item item) {
		inventoryManager.removeItem(player, item);
	}
}
