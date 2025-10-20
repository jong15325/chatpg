package com.kt.techup.chatpg.state.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.helper.CommandHelper;
import com.kt.techup.chatpg.helper.PrintHelper;
import com.kt.techup.chatpg.service.InventoryService;
import com.kt.techup.chatpg.state.GameState;
import com.kt.techup.chatpg.state.StateEnum;
import com.kt.techup.chatpg.state.StateFactory;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component
public class MainState implements GameState {

	private final InventoryService inventoryService;

	@Override
	public void handleInput(String input, GameContext context) {

		System.out.println("MainState");

		PrintHelper.centerAlignPt("아래는 게임 메뉴에요");
		PrintHelper.centerAlignPt("진행할 행동을 아래 보기처럼 입력해주세요");

		CommandHelper.commandList("main");

		switch (input.toLowerCase()) {
			case "info" ->
				context.changeState(StateEnum.PLAYER_STATUS);  // 간단!
			case "eq" ->
				context.changeState(StateEnum.EQUIPMENT);  // 간단!
			case "inventory" -> {
				inventoryService.showInventory(context.getPlayer());
				context.changeState(StateEnum.INVENTORY);
				CommandHelper.commandList("inventory");
			}
			case "exit"  ->
				System.exit(0);
			default -> {
				System.out.println("현재 가능 명령어 -> 'info' / 'eq' / 'inventory' / 'exit'");
			}
		}
	}

}
