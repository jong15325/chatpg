package com.kt.techup.chatpg.domain.player;

import java.util.ArrayList;
import java.util.EnumMap;

import com.kt.techup.chatpg.domain.equipment.Equipment;
import com.kt.techup.chatpg.domain.equipment.EquipmentType;
import com.kt.techup.chatpg.domain.inventory.Inventory;

import lombok.Getter;

@Getter
public class Player {

	private final String playerName;
	private int playerLevel;
	private int playerExp;
	private final Stats stats;
	private final Equipment equipment;
	private final Inventory inventory;

	public Player(String playerName) {
		this.playerName = playerName;
		this.playerLevel = 1;
		this.playerExp = 0;
		this.stats = new Stats(50, 20, 5, 1);
		this.equipment = new Equipment();
		this.inventory = new Inventory();
	}

}
