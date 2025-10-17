package com.kt.techup.chatpg.domain.equipment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EquipmentType {
	NONE(0, ""),
	WEAPON(1, "무기"),
	HELMET(2, "투구"),
	ARMOR(3, "갑옷"),
	BOOTS(4, "신발"),
	ACCESSORY(5, "장신구");

	private final int slot;
	private final String description;

}
