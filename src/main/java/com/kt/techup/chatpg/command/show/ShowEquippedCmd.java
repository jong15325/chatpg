package com.kt.techup.chatpg.command.show;

import com.kt.techup.chatpg.command.Command;
import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.domain.player.Player;
import com.kt.techup.chatpg.state.main.EquipmentState;

public class ShowEquippedCmd implements Command {

	@Override
	public void execute(Player player, GameContext context) {
		System.out.println("ShowEquippedCmd");
		player.getEquipmentManager().showEquipped();

	}

}
