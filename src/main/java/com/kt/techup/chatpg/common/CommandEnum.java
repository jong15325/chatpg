package com.kt.techup.chatpg.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommandEnum {

	//common
	MAIN_SHOW_STATUS("status", "main", "내정보", "플레이어의 현재 상태를 보여줍니다."),
	MAIN_SHOW_EQUIPMENT("equipment","main", "장비", "현재 장착된 장비를 보여줍니다."),
	MAIN_SHOW_INVENTORY("inventory","main", "인벤토리", "플레이어의 인벤토리를 보여줍니다."),
	MAIN_DUNGEON("dungeon", "main", "던전","던전으로 이동합니다."),
	MAIN_EXIT("exit", "main", "종료", "게임을 종료합니다."),

	BATTLE_ATTACK("attack", "battle", "공격","몬스터를 공격합니다."),
	BATTLE_DEFENSE("defense", "battle", "방어", "방어 자세를 취합니다."),
	BATTLE_RUN("run", "battle", "도망", "전투에서 도망칩니다."),

	INVENTORY_EQUIP("equip 아이템 번호", "inventory","장비 장착", "인벤토리의 아이템을 장착합니다 (equip 아이템 번호)"),
	INVENTORY_UNEQUIP("unequip 아이템 번호", "inventory", "장비 해제", "인벤토리의 장착 아이템을 해제합니다 (unequip 아이템 번호)"),
	INVENTORY_BACK("back", "inventory", "돌아가기", "이전으로 돌아갑니다"),

	EQUIPMENT_MOVE_INVENTORY("move", "equipment", "인벤토리 이동", "인벤토리로 이동합니다"),
	EQUIPMENT_BACK("back", "equipment", "뒤로 이동", "이전 행동으로 이동합니다"),

	PLAYER_STATUS_BACK("back", "playerStatus", "뒤로 이동", "이전 행동으로 이동합니다."),

	DUNGEON_BACK("back", "dungeon", "뒤로 이동", "이전 행동으로 이동합니다."),

	;
	private final String command;
	private final String type;
	private final String commandName;
	private final String description;
}
