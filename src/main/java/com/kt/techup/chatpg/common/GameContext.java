package com.kt.techup.chatpg.common;

import com.kt.techup.chatpg.command.Command;
import com.kt.techup.chatpg.player.Player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class GameContext {

	private final Player player;
	private Command currentCommand;

	public GameContext(Player player) {
		this.player = player;
	}
}
