package com.kt.techup.chatpg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kt.techup.chatpg.domain.dungeon.Dungeon;
import com.kt.techup.chatpg.domain.dungeon.monster.Monster;
import com.kt.techup.chatpg.domain.dungeon.monster.MonsterData;
import com.kt.techup.chatpg.helper.MonsterSpawnHelper;
import com.kt.techup.chatpg.helper.PrintHelper;

/**
 *packageName    : com.kt.techup.chatpg.service
 * fileName       : DungeonService
 * author         : howee
 * date           : 2025-10-28
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-10-28        howee       최초 생성
 */

@Service
public class DungeonService {
	
	public void welcomeMsg() {
		PrintHelper.centerAlignPt("던전 입장!");
	}

	public void leaveMsg() {
		PrintHelper.centerAlignPt("던전 나가기!");
	}

	public void showAvailableMonsters(int currentFloor) {
		PrintHelper.centerAlignPt("========================================");
		PrintHelper.centerAlignPt(String.format("         %d층 던전 정보", currentFloor));
		PrintHelper.centerAlignPt("========================================");

		if (MonsterSpawnHelper.isBossFloor(currentFloor)) {
			PrintHelper.centerAlignPt("          [🔥 보스 층 🔥]");
			PrintHelper.centerAlignPt("");
			PrintHelper.centerAlignPt("  ⚠️  강력한 보스 몬스터가 출현합니다!");
			PrintHelper.centerAlignPt("");
		} else {
			PrintHelper.centerAlignPt("      [출현 가능한 몬스터]");
			PrintHelper.centerAlignPt("----------------------------------------");

			List<MonsterData> availableMonsters = MonsterSpawnHelper.getAvailableMonsters(currentFloor);

			if (availableMonsters.isEmpty()) {
				PrintHelper.centerAlignPt("  출현 가능한 몬스터가 없습니다.");
			} else {
				for (MonsterData monster : availableMonsters) {
					PrintHelper.centerAlignPt(String.format("  [Lv.%d] %s (HP:%d / ATK:%d / DEF:%d)",
						monster.getLevel(),
						monster.getName(),
						monster.getHp(),
						monster.getAttack(),
						monster.getDefense()));
				}
			}
		}
	}

	public void enterFloor(Dungeon dungeon) {
		PrintHelper.centerAlignPt("던전 입장 및 몬스터 출현");
	}
}
