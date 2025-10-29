package com.kt.techup.chatpg.helper;

import java.util.List;

import com.kt.techup.chatpg.domain.dungeon.monster.Monster;
import com.kt.techup.chatpg.domain.player.Player;

/**
 *packageName    : com.kt.techup.chatpg.helper
 * fileName       : BattleDisplayHelper
 * author         : kt_backend_jjh
 * date           : 2025. 10. 29.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 10. 29.        kt_backend_jjh       최초 생성
 */
public class BattleDisplayHelper {
	private static final int SCREEN_WIDTH = 80;
	private static final int HP_BAR_LENGTH = 10;

	/**
	 * 전투 화면 전체 출력
	 */
	public static void showBattleScreen(Player player, Monster monster, List<String> battleLog, int turnCount) {
		clearScreen();
		drawBorder("top");
		drawEmptyLine();
		drawPlayerAndMonsterInfo(player, monster);
		drawEmptyLine();
		drawCenterText("🎯 전투 중! 🎯");
		drawEmptyLine();
		drawTurnAndMonsterStats(turnCount, monster);
		drawEmptyLine();
		drawBorder("middle");
		drawEmptyLine();
		drawBattleLog(battleLog);
		drawEmptyLine();
		drawBorder("middle");
		drawEmptyLine();
		drawCommands();
		drawEmptyLine();
		drawBorder("bottom");
	}

	/**
	 * 화면 지우기
	 */
	private static void clearScreen() {
		// 간단한 방법: 여러 줄 출력
		for (int i = 0; i < 3; i++) {
			System.out.println();
		}
	}

	/**
	 * 테두리 그리기
	 */
	private static void drawBorder(String type) {
		switch (type) {
			case "top":
				System.out.println("╔" + "═".repeat(SCREEN_WIDTH - 2) + "╗");
				break;
			case "middle":
				System.out.println("║" + "─".repeat(SCREEN_WIDTH - 2) + "║");
				break;
			case "bottom":
				System.out.println("╚" + "═".repeat(SCREEN_WIDTH - 2) + "╝");
				break;
		}
	}

	/**
	 * 빈 줄 (테두리 포함)
	 */
	private static void drawEmptyLine() {
		System.out.println("║" + " ".repeat(SCREEN_WIDTH - 2) + "║");
	}

	/**
	 * 플레이어와 몬스터 정보
	 */
	private static void drawPlayerAndMonsterInfo(Player player, Monster monster) {
		// 첫 번째 줄: 이름과 체력바
		String playerInfo = String.format("  [플레이어] %-12s HP: %s %d/%d",
			player.getPlayerName(),
			createHPBar(player.getCurrentStats().getHp(), player.getBaseStats().getHp()),
			player.getCurrentStats().getHp(),
			player.getBaseStats().getHp());

		String monsterInfo = String.format("[몬스터] %s  ", monster.getMonster().getName());

		int totalLen = playerInfo.length() + monsterInfo.length();
		int spaces = SCREEN_WIDTH - 2 - totalLen;

		System.out.println("║" + playerInfo + " ".repeat(Math.max(0, spaces)) + monsterInfo + "║");

		// 두 번째 줄: 아이콘
		System.out.println("║     ⚔️                                                                   👹     ║");
		System.out.println("║    /█\\                                                                  /█\\    ║");
		System.out.println("║    / \\                                                                  / \\    ║");
	}

	/**
	 * 체력바 생성
	 */
	private static String createHPBar(int current, int max) {
		if (max == 0) return "░".repeat(HP_BAR_LENGTH);

		int filled = (int) ((double) current / max * HP_BAR_LENGTH);
		filled = Math.max(0, Math.min(HP_BAR_LENGTH, filled));

		return "█".repeat(filled) + "░".repeat(HP_BAR_LENGTH - filled);
	}

	/**
	 * 턴 수와 몬스터 스탯
	 */
	private static void drawTurnAndMonsterStats(int turnCount, Monster monster) {
		String leftPart = String.format("  턴: %d", turnCount);
		String rightPart = String.format("몬스터 HP: %s %d/%d  ",
			createHPBar(monster.getCurrentStats().getHp(), monster.getTotalStats().getHp()),
			monster.getCurrentStats().getHp(),
			monster.getTotalStats().getHp());

		int spaces = SCREEN_WIDTH - 2 - leftPart.length() - rightPart.length();
		System.out.println("║" + leftPart + " ".repeat(Math.max(0, spaces)) + rightPart + "║");

		String monsterStats = String.format("ATK: %d / DEF: %d  ",
			monster.getTotalStats().getAttack(),
			monster.getTotalStats().getDefense());

		spaces = SCREEN_WIDTH - 2 - monsterStats.length();
		System.out.println("║" + " ".repeat(Math.max(0, spaces)) + monsterStats + "║");
	}

	/**
	 * 전투 로그 출력
	 */
	private static void drawBattleLog(List<String> battleLog) {
		System.out.println("║  📜 전투 로그:" + " ".repeat(SCREEN_WIDTH - 14) + "║");

		// 최근 3개의 로그만 표시
		int startIndex = Math.max(0, battleLog.size() - 3);
		for (int i = startIndex; i < battleLog.size(); i++) {
			String log = battleLog.get(i);
			String paddedLog = String.format("  • %-" + (SCREEN_WIDTH - 6) + "s", log);
			System.out.println("║" + paddedLog + "║");
		}

		// 로그가 3개 미만이면 빈 줄로 채우기
		for (int i = battleLog.size(); i < 3; i++) {
			drawEmptyLine();
		}
	}

	/**
	 * 명령어 표시
	 */
	private static void drawCommands() {
		System.out.println("║  💡 명령어:" + " ".repeat(SCREEN_WIDTH - 13) + "║");
		System.out.println("║  [1] ⚔️  공격      [2] 🛡️  방어      [3] 🏃 도망" + " ".repeat(SCREEN_WIDTH - 46) + "║");
	}

	/**
	 * 중앙 정렬 텍스트
	 */
	private static void drawCenterText(String text) {
		int padding = (SCREEN_WIDTH - 2 - text.length()) / 2;
		String line = "║" + " ".repeat(padding) + text + " ".repeat(SCREEN_WIDTH - 2 - padding - text.length()) + "║";
		System.out.println(line);
	}
}