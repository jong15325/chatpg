package com.kt.techup.chatpg.state.common;

import com.kt.techup.chatpg.common.GameContext;

public interface GameState {
	void onEnter(GameContext context);
	void handleInput(String input, GameContext context) throws InterruptedException;
	void onExit(GameContext context);
}
