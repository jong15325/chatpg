package com.kt.techup.chatpg.state;

import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.domain.battle.Battle;
import com.kt.techup.chatpg.domain.dungeon.monster.Monster;
import com.kt.techup.chatpg.domain.dungeon.monster.MonsterRank;
import com.kt.techup.chatpg.helper.CommandHelper;
import com.kt.techup.chatpg.service.BattleService;
import com.kt.techup.chatpg.state.common.GameState;
import com.kt.techup.chatpg.state.common.StateEnum;

import lombok.RequiredArgsConstructor;

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

@RequiredArgsConstructor
@Component
public class BattleState implements GameState {

	private final BattleService battleService;

	@Override
	public void onEnter(GameContext context) {
		battleService.welcomeMsg();

		Monster monster = context.getDungeon().spawnMonster(MonsterRank.NORMAL);

		Battle battle = new Battle(context.getPlayer(), monster);

		context.startBattle(battle);

		battleService.battleStart(battle);

		CommandHelper.commandList("battle");
	}

	@Override
	public void handleInput(String input, GameContext context) throws InterruptedException {
		switch (input.toLowerCase()) {
			case "attack" -> {
				battleService.processPlayerAttack(context.getPlayer(), monster);
				CommandHelper.commandList("battle");
			}
			case "run" ->
				context.changeState(StateEnum.DUNGEON);
			case "exit"  ->
				System.exit(0);
			default ->
				CommandHelper.commandList("dungeon");
		}
	}

	@Override
	public void onExit(GameContext context) {
		battleService.leaveMsg();
	}
}
