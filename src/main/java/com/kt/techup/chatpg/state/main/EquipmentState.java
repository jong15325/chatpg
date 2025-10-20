package com.kt.techup.chatpg.state.main;

import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.state.GameState;
import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.state.StateEnum;
import com.kt.techup.chatpg.state.StateFactory;

@Component
public class EquipmentState implements GameState {

	@Override
	public void handleInput(String input, GameContext context) {
		// 장착 장비칸에서는 인벤토리로 이동 y/n 밖에 없다
		System.out.println("EquipmentState");

		switch (input.toLowerCase()) {
			case "y" -> {
				context.changeState(StateEnum.INVENTORY);
			}
			case "n", "back" ->
				context.changeState(StateEnum.MAIN);
			case "exit"  ->
				System.exit(0);
			default -> {
				System.out.println("현재 가능 명령어 -> 'y' / 'n' / 'back' / 'exit'");
			}
		}
	}
}
