package com.kt.techup.chatpg.state.main;

import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.helper.CommandHelper;
import com.kt.techup.chatpg.service.DungeonService;
import com.kt.techup.chatpg.state.GameState;
import com.kt.techup.chatpg.state.StateEnum;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DungeonState implements GameState {

	private final DungeonService dungeonService;

	@Override
	public void onEnter(GameContext context) {
		dungeonService.welcomeMsg();
		CommandHelper.commandList("dungeon");
	}

	@Override
	public void handleInput(String input, GameContext context) {
		switch (input.toLowerCase()) {
			case "back" ->
				context.changeState(StateEnum.MAIN);
			case "exit"  ->
				System.exit(0);
			default ->
				CommandHelper.commandList("dungeon");
		}
	}

	@Override
	public void onExit(GameContext context) {
		dungeonService.leaveMsg();
	}
}
