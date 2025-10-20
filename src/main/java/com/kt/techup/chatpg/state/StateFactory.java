package com.kt.techup.chatpg.state;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.state.main.EquipmentState;
import com.kt.techup.chatpg.state.main.InventoryState;
import com.kt.techup.chatpg.state.main.MainState;
import com.kt.techup.chatpg.state.main.PlayerStatusState;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class StateFactory {

	private final MainState mainState;
	private final EquipmentState equipmentState;
	private final InventoryState inventoryState;
	private final PlayerStatusState playerStatusState;

	public GameState getState(StateEnum type) {
		return switch (type) {
			case MAIN -> mainState;
			case INVENTORY -> inventoryState;
			case EQUIPMENT -> equipmentState;
			case PLAYER_STATUS -> playerStatusState;
			default -> throw new IllegalArgumentException("등록되지 않은 상태 타입: " + type);
		};
	}
}
