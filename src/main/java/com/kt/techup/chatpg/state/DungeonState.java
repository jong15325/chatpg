package com.kt.techup.chatpg.state;

import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.helper.CommandHelper;
import com.kt.techup.chatpg.service.DungeonService;
import com.kt.techup.chatpg.state.common.GameState;
import com.kt.techup.chatpg.state.common.StateEnum;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DungeonState implements GameState {

	private final DungeonService dungeonService;

	@Override
	public void onEnter(GameContext context) {
		dungeonService.welcomeMsg();
		dungeonService.showAvailableMonsters(context.getDungeon().getCurrentFloor());
		CommandHelper.commandList("dungeon");
	}

	@Override
	public void handleInput(String input, GameContext context) {
		switch (input.toLowerCase()) {
			case "challenge" ->
				context.changeState(StateEnum.BATTLE);
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
