package com.kt.techup.chatpg.state;

import java.util.HashMap;
import java.util.Map;

import com.kt.techup.chatpg.state.main.EquipmentState;
import com.kt.techup.chatpg.state.main.InventoryState;
import com.kt.techup.chatpg.state.main.MainState;
import com.kt.techup.chatpg.state.main.PlayerStatusState;

import lombok.RequiredArgsConstructor;

public class StateFactory {

	private static StateFactory instance;
	private final Map<StateEnum, GameState> stateCache;

	private StateFactory() {
		this.stateCache = new HashMap<>();
		initializeStates();
	}

	public static StateFactory getInstance() {
		if (instance == null) {
			instance = new StateFactory();
		}
		return instance;
	}

	private void initializeStates() {
		stateCache.put(StateEnum.MAIN, new MainState());
		stateCache.put(StateEnum.PLAYER_STATUS, new PlayerStatusState());
		stateCache.put(StateEnum.INVENTORY, new InventoryState());
		stateCache.put(StateEnum.EQUIPMENT, new EquipmentState());

		// 추가 상태들
		// stateCache.put(StateType.DUNGEON, new DungeonState());
		// stateCache.put(StateType.COMBAT, new CombatState());
		// stateCache.put(StateType.SHOP, new ShopState());
	}

	public GameState getState(StateEnum type) {
		GameState state = stateCache.get(type);
		if (state == null) {
			throw new IllegalArgumentException("등록되지 않은 상태 타입: " + type);
		}
		return state;
	}

	public void registerState(StateEnum type, GameState state) {
		stateCache.put(type, state);
	}

	public void clearCache() {
		stateCache.clear();
		initializeStates();
	}

}
