package com.kt.techup.chatpg.state.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.helper.CommandHelper;
import com.kt.techup.chatpg.helper.PrintHelper;
import com.kt.techup.chatpg.service.InventoryService;
import com.kt.techup.chatpg.service.MainService;
import com.kt.techup.chatpg.state.GameState;
import com.kt.techup.chatpg.state.StateEnum;
import com.kt.techup.chatpg.state.StateFactory;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component
public class MainState implements GameState {

	private final MainService mainService;

	@Override
	public void onEnter(GameContext gameContext) {
		mainService.welcomeMsg();
	}

	@Override
	public void handleInput(String input, GameContext context) {

		switch (input.toLowerCase()) {
			case "status" ->
				context.changeState(StateEnum.PLAYER_STATUS);
			case "equipment" ->
				context.changeState(StateEnum.EQUIPMENT);
			case "inventory" ->
				context.changeState(StateEnum.INVENTORY);
			case "exit"  ->
				System.exit(0);
			default ->
				CommandHelper.commandList("main");
		}
	}

	@Override
	public void onExit(GameContext gameContext) {
		mainService.LeaveMsg();
	}

}
