package com.kt.techup.chatpg.domain.battle;

import java.util.ArrayList;
import java.util.List;

import com.kt.techup.chatpg.domain.dungeon.monster.Monster;
import com.kt.techup.chatpg.domain.player.Player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *packageName    : com.kt.techup.chatpg.domain.battle
 * fileName       : Battle
 * author         : howee
 * date           : 2025-10-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-10-29        howee       최초 생성
 */

@Getter
public class Battle {
	private final Player player;
	private final Monster monster;
	private BattleStatus status;
	private TurnOwner currentTurn;
	private int turnCount;
	private final List<String> battleLog;

	public Battle(Player player, Monster monster) {
		this.player = player;
		this.monster = monster;
		this.status = BattleStatus.ONGOING;
		this.currentTurn = TurnOwner.PLAYER; // 플레이어 선공
		this.turnCount = 1;
		this.battleLog = new ArrayList<>();
	}

	/**
	 * 전투 로그
	 * @param log
	 */
	public void addLog(String log) {
		this.battleLog.add(log);
	}

	/**
	 * 턴 전환
	 */
	public void switchTurn() {
		if (currentTurn == TurnOwner.PLAYER) {
			currentTurn = TurnOwner.MONSTER;
		} else {
			currentTurn = TurnOwner.PLAYER;
			turnCount++;
		}
	}

	/**
	 * 전투 종료 여부
	 * @return
	 */
	public boolean isFinished() {
		return status != BattleStatus.ONGOING;
	}

	public void setVictory() {
		if (this.status == BattleStatus.ONGOING) {
			this.status = BattleStatus.VICTORY;
		}
	}

	public void setDefeat() {
		if (this.status == BattleStatus.ONGOING) {
			this.status = BattleStatus.DEFEAT;
		}
	}

	/**
	 * 전투 종료 체크
	 */
	public void checkBattleEnd() {
		if (monster.getCurrentStats().getHp() <= 0) {
			setVictory();
		} else if (player.getCurrentStats().getHp() <= 0) {
			setDefeat();
		}
	}
}
