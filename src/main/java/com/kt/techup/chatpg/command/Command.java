package com.kt.techup.chatpg.command;

import com.kt.techup.chatpg.common.GameContext;

public interface Command {
	void execute(GameContext context, String input);
}
