package com.kt.techup.chatpg.state;

import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.state.common.GameState;

/**
 *packageName    : com.kt.techup.chatpg.state
 * fileName       : BattleState
 * author         : howee
 * date           : 2025-10-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-10-29        howee       최초 생성
 */

@Component
public class BattleState implements GameState {
		@Override
		public void onEnter(GameContext context) {

		}

		@Override
		public void handleInput(String input, GameContext context) {

		}

		@Override
		public void onExit(GameContext context) {

		}
}
