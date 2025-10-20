package com.kt.techup.chatpg.state.main;

import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.state.GameState;
import com.kt.techup.chatpg.state.StateEnum;
import com.kt.techup.chatpg.state.StateFactory;

@Component
public class PlayerStatusState implements GameState {
	@Override
	public void handleInput(String input, com.kt.techup.chatpg.common.GameContext context) {
		System.out.println("PlayerStatusState");

		if(!input.isEmpty()) {
			context.changeState(StateEnum.MAIN);
		}
	}
}
