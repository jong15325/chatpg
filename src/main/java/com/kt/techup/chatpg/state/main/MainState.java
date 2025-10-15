package com.kt.techup.chatpg.state.main;

import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.state.GameState;

public class MainState implements GameState {

	@Override
	public void handleInput(String input, GameContext context) {
		System.out.println("MainState");

		switch (input.toLowerCase()) {
			case "info":
				context.setCurrentState(new PlayerStatusState());
				context.getCommandRegistry().getCommand(input.toLowerCase()).execute(context.getPlayer(), context);
				break;
			case "eq":
				context.setCurrentState(new EquipmentState());
				context.getCommandRegistry().getCommand(input.toLowerCase()).execute(context.getPlayer(), context);
				break;
			case "inventory":
				context.setCurrentState(new InventoryState());
				context.getCommandRegistry().getCommand(input.toLowerCase()).execute(context.getPlayer(), context);
				break;
			case "exit":
				System.exit(0);
				break;
			default:
				System.out.println("명령어를 다시 입력해주세요.");
		}
	}

}
