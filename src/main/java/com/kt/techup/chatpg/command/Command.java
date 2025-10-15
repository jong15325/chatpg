package com.kt.techup.chatpg.command;

import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.domain.player.Player;

public interface Command {
	void execute(Player player, GameContext context);
}
