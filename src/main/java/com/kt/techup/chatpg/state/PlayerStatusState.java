package com.kt.techup.chatpg.state;

import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.helper.CommandHelper;
import com.kt.techup.chatpg.service.PlayerService;
import com.kt.techup.chatpg.state.common.GameState;
import com.kt.techup.chatpg.state.common.StateEnum;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PlayerStatusState implements GameState {

	private final PlayerService playerService;

	@Override
	public void onEnter(GameContext context) {
		playerService.welcomeMsg();
		playerService.showStatus(context.getPlayer());
		CommandHelper.commandList("playerStatus");
	}

	@Override
	public void handleInput(String input, com.kt.techup.chatpg.common.GameContext context) {
		switch (input.toLowerCase()) {
			case "back" ->
				context.changeState(StateEnum.MAIN);
			case "exit"  ->
				System.exit(0);
			default ->
				CommandHelper.commandList("playerStatus");
		}
	}

	@Override
	public void onExit(GameContext context) {
		playerService.leaveMsg();
	}
}
