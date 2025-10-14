package com.kt.techup.chatpg.command.ingame;

import com.kt.techup.chatpg.command.Command;
import com.kt.techup.chatpg.common.GameContext;

public class GoDungeonCmd implements Command {

	@Override
	public void execute(GameContext context, String input) {
		// 던전으로 이동하는 로직 구현
		System.out.println("던전으로 이동합니다!");
	}

}
