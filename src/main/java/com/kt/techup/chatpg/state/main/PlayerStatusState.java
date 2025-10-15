package com.kt.techup.chatpg.state.main;

import com.kt.techup.chatpg.state.GameState;

public class PlayerStatusState implements GameState {
		@Override
		public void handleInput(String input, com.kt.techup.chatpg.common.GameContext context) {
				System.out.println("PlayerStatusState");

				if(!input.isEmpty()) {
					context.setCurrentState(new MainState());
				}
		}
}
