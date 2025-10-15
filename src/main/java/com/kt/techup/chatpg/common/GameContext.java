package com.kt.techup.chatpg.common;

import com.kt.techup.chatpg.state.GameState;
import com.kt.techup.chatpg.domain.player.Player;
import com.kt.techup.chatpg.state.main.MainState;

import lombok.Data;

@Data
public class GameContext {

	private final Player player;
	private final CommandRegistry commandRegistry;
	private GameState currentState;


	public GameContext(Player player, CommandRegistry commandRegistry) {
		this.player = player;
		this.commandRegistry = commandRegistry;
		this.currentState = new MainState();
	}

}
