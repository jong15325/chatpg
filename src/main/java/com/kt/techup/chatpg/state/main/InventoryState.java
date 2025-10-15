package com.kt.techup.chatpg.state.main;

import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.state.GameState;

public class InventoryState implements GameState {
	@Override
	public void handleInput(String input, GameContext context) {
		System.out.println("InventoryState");

	}
}
