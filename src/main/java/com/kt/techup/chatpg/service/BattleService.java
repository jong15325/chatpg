package com.kt.techup.chatpg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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

	private List<String> battleLog = new ArrayList<>();
	private int turnCount = 0;

	public void welcomeMsg() {
		PrintHelper.centerAlignPt("배틀 시작");
	}

	public void leaveMsg() {
		PrintHelper.centerAlignPt("배틀 종료!");
	}

	public void showBattleScreen(Player player, Monster monster) {
		BattleDisplayHelper.showBattleScreen(player, monster, battleLog, turnCount);
	}

	public void battleStart(Player player, Monster monster) {
		battleLog.clear();
		turnCount = 1;
		battleLog.add("전투가 시작되었습니다!");
		showBattleScreen(player, monster);
	}

	public void processPlayerAttack(Player player, Monster monster) {
		int damage = calculateDamage(player.getCurrentStats().getAttack(),
			monster.getTotalStats().getDefense());
		int actualDamage = monster.takeDamage(damage);

		battleLog.add(String.format("%s의 공격! %s에게 %d의 데미지!",
			player.getPlayerName(),
			monster.getMonster().getName(),
			actualDamage));

		turnCount++;
		showBattleScreen(player, monster);
	}

	private int calculateDamage(int attack, int defense) {
		return Math.max(1, attack - defense);
	}
}
