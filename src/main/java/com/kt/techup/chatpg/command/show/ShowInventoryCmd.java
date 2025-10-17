package com.kt.techup.chatpg.command.show;

import com.kt.techup.chatpg.command.Command;
import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.domain.player.Player;
import com.kt.techup.chatpg.service.InventoryService;
import com.kt.techup.chatpg.state.StateEnum;
import com.kt.techup.chatpg.state.StateFactory;
import com.kt.techup.chatpg.state.main.InventoryState;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ShowInventoryCmd implements Command {

	private final InventoryService inventoryService;

	@Override
	public void execute(Player player, GameContext context) {
		System.out.println("ShowInventoryCmd");

		context.setCurrentState(StateFactory.getInstance().getState(StateEnum.INVENTORY));

		inventoryService.showInventory(player);

	}

}
