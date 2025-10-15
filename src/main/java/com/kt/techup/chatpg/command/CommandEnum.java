package com.kt.techup.chatpg.command;

import com.kt.techup.chatpg.helper.PrintHelper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommandEnum {

	//common
	SHOW_STATUS("info", "main", "내정보", "플레이어의 현재 상태를 보여줍니다."),
	SHOW_EQUIPPED("eq","main", "장비", "현재 장착된 장비를 보여줍니다."),
	SHOW_INVENTORY("inven","main", "인벤토리", "플레이어의 인벤토리를 보여줍니다."),
	GO_DUNGEON("dungeon", "main", "던전","던전으로 이동합니다."),
	EXIT("exit", "main", "종료", "게임을 종료합니다."),


	ATTACK("attack", "inGame", "공격","몬스터를 공격합니다."),
	DEFENSE("defense", "inGame", "방어", "방어 자세를 취합니다."),
	RUN("run", "inGame", "도망", "전투에서 도망칩니다."),


	;
	private final String command;
	private final String type;
	private final String commandName;
	private final String description;
}
