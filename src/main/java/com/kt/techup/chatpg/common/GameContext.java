package com.kt.techup.chatpg.common;

import java.util.ArrayDeque;
import java.util.Deque;

import com.kt.techup.chatpg.state.GameState;
import com.kt.techup.chatpg.domain.player.Player;
import com.kt.techup.chatpg.state.StateEnum;
import com.kt.techup.chatpg.state.StateFactory;
import com.kt.techup.chatpg.state.main.MainState;

import lombok.Data;

@Data
public class GameContext {

	private final Player player;
	private GameState currentState;
	private final Deque<GameState> stateHistory = new ArrayDeque<>();
	private final StateFactory stateFactory;

	public GameContext(Player player, StateFactory stateFactory) {
		this.player = player;
		this.stateFactory = stateFactory;
		this.currentState = stateFactory.getState(StateEnum.MAIN);
	}

	public void changeState(StateEnum stateType) {
		GameState newState = stateFactory.getState(stateType);
		if (currentState != null) {
			stateHistory.push(currentState);
		}
		this.currentState = newState;
	}

	public void pushState(GameState state) {
		if(currentState != state) {
			stateHistory.push(state);
		}

		this.currentState = state;
	}

	public void popState() {
		if(!stateHistory.isEmpty()) {
			this.currentState = stateHistory.pop();
		} else {
			this.currentState = stateFactory.getState(StateEnum.MAIN);
		}
	}

}
