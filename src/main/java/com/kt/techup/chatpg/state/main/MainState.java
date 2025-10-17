package com.kt.techup.chatpg.state.main;

import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.state.GameState;
import com.kt.techup.chatpg.state.StateEnum;
import com.kt.techup.chatpg.state.StateFactory;

public class MainState implements GameState {

	@Override
	public void handleInput(String input, GameContext context) {
		System.out.println("MainState");

		StateFactory stateFactory = StateFactory.getInstance();

		switch (input.toLowerCase()) {
			case "info" ->
				context.setCurrentState(stateFactory.getState(StateEnum.PLAYER_STATUS));
			case "eq" ->
				context.setCurrentState(stateFactory.getState(StateEnum.EQUIPMENT));
			case "inventory"  ->
				context.setCurrentState(stateFactory.getState(StateEnum.INVENTORY));
			case "exit"  ->
				System.exit(0);
			default -> {
				System.out.println("현재 가능 명령어 -> 'info' / 'eq' / 'inventory' / 'exit'");
			}
		}
	}

}
