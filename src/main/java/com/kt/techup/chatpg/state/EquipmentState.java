package com.kt.techup.chatpg.state;

import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.helper.CommandHelper;
import com.kt.techup.chatpg.service.EquipmentService;
import com.kt.techup.chatpg.state.common.GameState;
import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.state.common.StateEnum;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class EquipmentState implements GameState {

	private final EquipmentService equipmentService;

	@Override
	public void onEnter(GameContext context) {
		equipmentService.welcomeMsg();
		equipmentService.showEquipped(context.getPlayer());
		CommandHelper.commandList("equipment");
	}

	@Override
	public void handleInput(String input, GameContext context) {

		switch (input.toLowerCase()) {
			case "move" ->
				context.changeState(StateEnum.INVENTORY);
			case "back" ->
				context.changeState(StateEnum.MAIN);
			case "exit"  ->
				System.exit(0);
			default ->
				CommandHelper.commandList("equipment");
		}
	}

	@Override
	public void onExit(GameContext context) {
		equipmentService.leaveMsg();
	}
}
