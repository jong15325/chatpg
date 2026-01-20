package com.kt.techup.chatpg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kt.techup.chatpg.domain.battle.Battle;
import com.kt.techup.chatpg.domain.dungeon.monster.Monster;
import com.kt.techup.chatpg.domain.player.Player;
import com.kt.techup.chatpg.helper.BattleDisplayHelper;
import com.kt.techup.chatpg.helper.PrintHelper;

/**
 *packageName    : com.kt.techup.chatpg.service
 * fileName       : BattleService
 * author         : howee
 * date           : 2025-10-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-10-29        howee       최초 생성
 */

@Service
public class BattleService {

	public void welcomeMsg() {
		PrintHelper.centerAlignPt("배틀 시작");
	}

	public void leaveMsg() {
		PrintHelper.centerAlignPt("배틀 종료!");
	}

	public void showBattleScreen(Battle battle) {
		BattleDisplayHelper.showBattleScreen(battle.getPlayer(), battle.getMonster(), battle.getBattleLog(), battle.getTurnCount());
	}

	public void battleStart(Battle battle) {
		battle.getBattleLog().clear();
		battle.addLog("전투가 시작되었습니다!");
	}

	public void processPlayerAttack(Battle battle) {
		Player player = battle.getPlayer();
		Monster monster = battle.getMonster();

		int damage = calculateDamage(player.getCurrentStats().getAttack(),
			monster.getTotalStats().getDefense());

		int actualDamage = monster.takeDamage(damage);

		battle.addLog(String.format("%s의 공격! %s에게 %d의 데미지!",
			player.getPlayerName(),
			monster.getMonster().getName(),
			actualDamage));

		battle.checkBattleEnd();

		if(!battle.isFinished())
			battle.switchTurn();
	}

	public void processMonsterAttack(Battle battle) {
		Player player = battle.getPlayer();
		Monster monster = battle.getMonster();

		int damage = calculateDamage(monster.getTotalStats().getAttack(),
			player.getCurrentStats().getDefense());

		int actualDamage = player.takeDamage(damage);

		battle.addLog(String.format("%s의 공격! %s에게 %d의 데미지!",
			monster.getMonster().getName(),
			player.getPlayerName(),
			actualDamage));

		battle.checkBattleEnd();

		if(!battle.isFinished())
			battle.switchTurn();
	}

	private int calculateDamage(int attack, int defense) {
		return Math.max(1, attack - defense);
	}
}
