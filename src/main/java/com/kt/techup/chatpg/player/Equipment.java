package com.kt.techup.chatpg.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Equipment {

	private final String name;
	private final int attackBoost;
	private final int defenseBoost;
	private final int hpBoost;
	private final EquipmentEnum type;

}
