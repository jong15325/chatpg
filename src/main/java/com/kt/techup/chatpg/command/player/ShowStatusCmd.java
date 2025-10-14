package com.kt.techup.chatpg.command.player;

import com.kt.techup.chatpg.command.Command;
import com.kt.techup.chatpg.common.GameContext;

public class ShowStatusCmd implements Command {

	@Override
	public void execute(GameContext context, String input) {
		context.getPlayer().showStatus();
	}

}
