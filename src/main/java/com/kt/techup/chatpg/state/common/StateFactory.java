package com.kt.techup.chatpg.state.common;

import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.state.BattleState;
import com.kt.techup.chatpg.state.DungeonState;
import com.kt.techup.chatpg.state.EquipmentState;
import com.kt.techup.chatpg.state.InventoryState;
import com.kt.techup.chatpg.state.MainState;
import com.kt.techup.chatpg.state.PlayerStatusState;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class StateFactory {

	private final MainState mainState;
	private final EquipmentState equipmentState;
	private final InventoryState inventoryState;
	private final PlayerStatusState playerStatusState;
	private final DungeonState dungeonState;
	private final BattleState battleState;

	public GameState getState(StateEnum type) {
		return switch (type) {
			case MAIN -> mainState;
			case INVENTORY -> inventoryState;
			case EQUIPMENT -> equipmentState;
			case PLAYER_STATUS -> playerStatusState;
			case DUNGEON -> dungeonState;
			case BATTLE -> battleState;
			default -> throw new IllegalArgumentException("등록되지 않은 상태 타입: " + type);
		};
	}
}
