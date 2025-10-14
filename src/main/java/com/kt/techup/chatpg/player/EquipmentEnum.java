package com.kt.techup.chatpg.player;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EquipmentEnum {
	WEAPON(1),
	HELMET(2),
	ARMOR(3),
	BOOTS(4),
	ACCESSORY(5);

	private final int slot;
}
