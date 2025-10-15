package com.kt.techup.chatpg.command.move;

import com.kt.techup.chatpg.command.Command;
import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.domain.player.Player;

public class MoveDungeonCmd implements Command {

	@Override
	public void execute(Player player, GameContext context) {
		System.out.println("MoveDungeonCmd");
	}

}
