package com.kt.techup.chatpg.domain.player;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

import com.kt.techup.chatpg.domain.equipment.Equipment;
import com.kt.techup.chatpg.domain.equipment.EquipmentType;
import com.kt.techup.chatpg.domain.inventory.Inventory;

import lombok.Getter;

@Getter
public class Player {

	private final String playerName;
	private int playerLevel;
	private int playerExp;
	private Stats baseStats; // 기본 스탯
	private Stats addStats; // 장비/소비 추가 스탯
	private Stats currentStats; // 현재 스탯
	private final Equipment equipment;
	private final Inventory inventory;

	public Player(String playerName) {
		this.playerName = playerName;
		this.playerLevel = 1;
		this.playerExp = 0;
		this.baseStats = new Stats(50, 20, 5, 1);
		this.addStats  = new Stats(0, 0, 0, 0);
		this.currentStats = new Stats(50, 20, 5, 1);
		this.equipment = new Equipment(new EnumMap<>(EquipmentType.class));
		this.inventory = new Inventory(new HashMap<>());
	}

	public Stats getTotalStats() {
		Stats totalStats = baseStats.copy();

		for(EquipmentType type : EquipmentType.values()) {
			if(type == EquipmentType.NONE) {
				continue;
			}

			equipment.getEquippedItem(type, inventory)
				.ifPresent(equippedItem -> {
					if(equippedItem.getStats() != null) {
						totalStats.addStats(equippedItem.getStats());
					}
				});
		}

		return totalStats;
	}

}
