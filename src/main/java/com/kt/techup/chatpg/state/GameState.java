package com.kt.techup.chatpg.state;

import com.kt.techup.chatpg.common.GameContext;

public interface GameState {
	void onEnter(GameContext context);
	void handleInput(String input, GameContext context);
	void onExit(GameContext context);
}
