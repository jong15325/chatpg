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

		// 상단 테두리
		drawBorder("top");
		drawEmptyLine();

		// 1. HP바 영역
		drawHPBars(player, monster);
		drawEmptyLine();

		// 2. 이름 영역
		drawNames(player, monster);
		drawEmptyLine();

		// 3. 캐릭터 형태 영역
		drawCharacterSprites();
		drawEmptyLine();

		// 4. 스탯 영역
		drawStats(player, monster);
		drawEmptyLine();

		// 구분선
		drawBorder("middle");
		drawEmptyLine();

		// 5. 턴수 영역
		drawTurnCount(turnCount);
		drawEmptyLine();

		// 구분선
		drawBorder("middle");
		drawEmptyLine();

		// 6. 전투 로그 영역
		drawBattleLog(battleLog);
		drawEmptyLine();

		// 구분선
		drawBorder("middle");
		drawEmptyLine();

		// 7. 명령어 영역
		//drawCommands();
		drawEmptyLine();

		// 하단 테두리
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
	 * 1. HP바 영역
	 */
	private static void drawHPBars(Player player, Monster monster) {
		// 플레이어 HP바
		String playerHPBar = createHPBar(player.getCurrentStats().getHp(),
			player.getBaseStats().getHp());
		String playerHPText = String.format("%d/%d",
			player.getCurrentStats().getHp(),
			player.getBaseStats().getHp());

		// 몬스터 HP바
		String monsterHPBar = createHPBar(monster.getCurrentStats().getHp(),
			monster.getTotalStats().getHp());
		String monsterHPText = String.format("%d/%d",
			monster.getCurrentStats().getHp(),
			monster.getTotalStats().getHp());

		// 양쪽에 HP바 배치
		String leftHP = String.format("  HP: %s %s", playerHPBar, playerHPText);
		String rightHP = String.format("%s %s  ", monsterHPBar, monsterHPText);

		int spaces = SCREEN_WIDTH - 2 - leftHP.length() - rightHP.length();
		System.out.println("║" + leftHP + " ".repeat(Math.max(0, spaces)) + rightHP + "║");
	}

	/**
	 * 2. 이름 영역
	 */
	private static void drawNames(Player player, Monster monster) {
		String playerName = String.format("  [플레이어] %s", player.getPlayerName());
		String monsterName = String.format("[%s] %s  ",
			monster.getRank().getName(),
			monster.getMonster().getName());

		int spaces = SCREEN_WIDTH - playerName.length() - monsterName.length();
		System.out.println("║" + playerName + " ".repeat(Math.max(0, spaces)) + monsterName + "║");
	}

	/**
	 * 3. 캐릭터 형태 영역
	 */
	private static void drawCharacterSprites() {
		// 첫 번째 줄: 무기/아이콘
		System.out.println("║       ⚔️                                                                👹   ║");
		// 두 번째 줄: 머리
		System.out.println("║       █                                                                  █   ║");
		// 세 번째 줄: 몸통
		System.out.println("║      /█\\                                                                /█\\  ║");
		// 네 번째 줄: 다리
		System.out.println("║      / \\                                                                / \\  ║");
	}
	/**
	 * 4. 스탯 영역
	 */
	private static void drawStats(Player player, Monster monster) {
		// 플레이어 스탯
		String playerStats = String.format("  Lv.%d | ATK: %d | DEF: %d",
			player.getPlayerLevel(),
			player.getCurrentStats().getAttack(),
			player.getCurrentStats().getDefense());

		// 몬스터 스탯
		String monsterStats = String.format("Lv.%d | ATK: %d | DEF: %d  ",
			monster.getMonster().getLevel(),
			monster.getTotalStats().getAttack(),
			monster.getTotalStats().getDefense());

		int spaces = SCREEN_WIDTH - 2 - playerStats.length() - monsterStats.length();
		System.out.println("║" + playerStats + " ".repeat(Math.max(0, spaces)) + monsterStats + "║");
	}

	/**
	 * 5. 턴수 영역
	 */
	private static void drawTurnCount(int turnCount) {
		String turnText = String.format("🎯 전투 턴: %d", turnCount);
		drawCenterText(turnText);
	}

	/**
	 * 6. 전투 로그 영역
	 */
	private static void drawBattleLog(List<String> battleLog) {
		System.out.println("║  📜 전투 로그:" + " ".repeat(SCREEN_WIDTH - 13) + "║");
		drawEmptyLine();

		// 최근 5개의 로그만 표시
		int startIndex = Math.max(0, battleLog.size() - 5);
		for (int i = startIndex; i < battleLog.size(); i++) {
			String log = battleLog.get(i);
			// 로그가 너무 길면 자르기
			if (log.length() > SCREEN_WIDTH - 8) {
				log = log.substring(0, SCREEN_WIDTH - 11) + "...";
			}
			String paddedLog = String.format("    %-" + (SCREEN_WIDTH - 6) + "s", log);
			System.out.println("║" + paddedLog + "║");
		}

		// 로그가 5개 미만이면 빈 줄로 채우기
		for (int i = battleLog.size(); i < 5; i++) {
			drawEmptyLine();
		}
	}

	/**
	 * 7. 명령어 영역
	 */
	/*private static void drawCommands() {
		System.out.println("║  💡 명령어를 선택하세요:" + " ".repeat(SCREEN_WIDTH - 24) + "║");
		drawEmptyLine();
		System.out.println("║      [1] ⚔️  공격        [2] 🛡️  방어        [3] 🏃 도망" + " ".repeat(SCREEN_WIDTH - 56) + "║");
	}*/

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
	 * 중앙 정렬 텍스트
	 */
	private static void drawCenterText(String text) {
		int padding = (SCREEN_WIDTH - 2 - text.length()) / 2;
		int rightPadding = SCREEN_WIDTH - 2 - padding - text.length();
		String line = "║" + " ".repeat(padding) + text + " ".repeat(rightPadding) + "║";
		System.out.println(line);
	}
}