package com.kt.techup.chatpg.service;

import org.springframework.stereotype.Service;

import com.kt.techup.chatpg.domain.equipment.EquipmentManager;
import com.kt.techup.chatpg.domain.inventory.Inventory;
import com.kt.techup.chatpg.domain.player.Player;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EquipmentService {

	private final EquipmentManager equipmentManager;

	// 장착 장비 리스트
	public void showEquipped(Player player) {
		equipmentManager.showEquipped(player);
	}

	public void equip(Player player, Inventory inventory) {
		equipmentManager.equip(player, inventory);
	}
}
