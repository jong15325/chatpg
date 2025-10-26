package com.kt.techup.chatpg.domain.equipment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EquipmentType {
	NONE(0, "NONE"),
	HELMET(1, "투구"),
	WEAPON(2, "무기"),
	ARMOR(3, "갑옷"),
	BOOTS(4, "신발"),
	ACCESSORY(5, "장신구");

	private final int slot;
	private final String description;

}
