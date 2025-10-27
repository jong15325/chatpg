package com.kt.techup.chatpg.state.main;

import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.helper.CommandHelper;
import com.kt.techup.chatpg.service.EquipmentService;
import com.kt.techup.chatpg.service.InventoryService;
import com.kt.techup.chatpg.service.MainService;
import com.kt.techup.chatpg.state.GameState;
import com.kt.techup.chatpg.state.StateEnum;
import com.kt.techup.chatpg.state.StateFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class InventoryState implements GameState {

	private final MainService mainService;
	private final InventoryService inventoryService;
	private final EquipmentService equipmentService;

	@Override
	public void onEnter(GameContext context) {
		inventoryService.welcomeMsg();
		inventoryService.showInventory(context.getPlayer());
		CommandHelper.commandList("inventory");
	}

	@Override
	public void handleInput(String input, GameContext context) {

		String[] parts = input.trim().split("\\s+");
		String command = parts[0].toLowerCase();

		switch (command) {
			//장비 장착
			case "equip" -> {
				if (parts.length < 2) {
					CommandHelper.commandList("inventory");
					return;
				}

				int cmdNumber = Integer.parseInt(parts[1]);

				equipmentService.equipItem(context.getPlayer(), cmdNumber);
				inventoryService.showInventory(context.getPlayer());
				CommandHelper.commandList("inventory");
			}
			//장비 해제
			case "unequip" -> {
				if (parts.length < 2) {
					CommandHelper.commandList("inventory");
					return;
				}

				int cmdNumber = Integer.parseInt(parts[1]);

				equipmentService.unEquipItem(context.getPlayer(), cmdNumber);
				inventoryService.showInventory(context.getPlayer());
				CommandHelper.commandList("inventory");
			}
			//뒤로 가기
			case "back" ->
				context.changeState(StateEnum.MAIN);
			case "exit" ->
				System.exit(0);
			default ->
				CommandHelper.commandList("inventory");
		}
	}

	@Override
	public void onExit(GameContext gameContext) {
		inventoryService.leaveMsg();
	}
}
