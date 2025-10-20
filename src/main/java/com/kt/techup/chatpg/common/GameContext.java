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
		this.currentState.onEnter(this);
	}

	public void changeState(StateEnum stateType) {
		GameState newState = stateFactory.getState(stateType);

		// 같은 State로 전환 시도 시 무시
		if (currentState == newState) {
			return;
		}

		// 현재 State 종료 처리
		if (currentState != null) {
			currentState.onExit(this);
			stateHistory.push(currentState);
		}

		// 새 State로 전환
		this.currentState = newState;

		// 새 State 진입 처리 (환영 메시지 등이 여기서 자동 실행!)
		this.currentState.onEnter(this);
	}
}
