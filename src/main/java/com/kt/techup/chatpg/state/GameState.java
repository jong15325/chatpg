package com.kt.techup.chatpg.state;

import com.kt.techup.chatpg.common.GameContext;

public interface GameState {
	void handleInput(String input, GameContext context);
}
