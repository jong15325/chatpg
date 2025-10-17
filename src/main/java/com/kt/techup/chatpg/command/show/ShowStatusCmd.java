package com.kt.techup.chatpg.command.show;

import com.kt.techup.chatpg.command.Command;
import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.domain.player.Player;
import com.kt.techup.chatpg.state.StateEnum;
import com.kt.techup.chatpg.state.StateFactory;
import com.kt.techup.chatpg.state.main.PlayerStatusState;

public class ShowStatusCmd implements Command {

	@Override
	public void execute(Player player, GameContext context) {
		System.out.println("ShowStatusCmd");

		context.setCurrentState(StateFactory.getInstance().getState(StateEnum.PLAYER_STATUS));
	}

}
