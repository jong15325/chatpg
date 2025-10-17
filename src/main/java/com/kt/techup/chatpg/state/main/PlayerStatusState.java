package com.kt.techup.chatpg.state.main;

import com.kt.techup.chatpg.state.GameState;
import com.kt.techup.chatpg.state.StateEnum;
import com.kt.techup.chatpg.state.StateFactory;

public class PlayerStatusState implements GameState {
	@Override
	public void handleInput(String input, com.kt.techup.chatpg.common.GameContext context) {
		System.out.println("PlayerStatusState");

		StateFactory stateFactory = StateFactory.getInstance();

		if(!input.isEmpty()) {
			context.setCurrentState(stateFactory.getState(StateEnum.MAIN));
		}
	}
}
