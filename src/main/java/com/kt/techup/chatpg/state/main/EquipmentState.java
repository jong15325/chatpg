package com.kt.techup.chatpg.state.main;

import com.kt.techup.chatpg.state.GameState;
import com.kt.techup.chatpg.common.GameContext;

public class EquipmentState implements GameState {

	@Override
	public void handleInput(String input, GameContext context) {
		// 장착 장비칸에서는 인벤토리로 이동 y/n 밖에 없다
		System.out.println("EquipmentState");

		if ("y".equalsIgnoreCase(input)) {
			context.setCurrentState(new InventoryState());
			System.out.println("인벤토리로 이동합니다");
		} else if ("n".equalsIgnoreCase(input)) {
			context.setCurrentState(new MainState());
			System.out.println("메인 메뉴로 돌아갑니다");
		} else if ("back".equalsIgnoreCase(input)) {
			context.setCurrentState(new MainState());
			System.out.println("메인 메뉴로 돌아갑니다");
		} else {
			System.out.println("올바른 명령어를 입력하세요 ('y', 'n', 'back')");
		}

	}

}
