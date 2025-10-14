package com.kt.techup.chatpg;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.command.Command;
import com.kt.techup.chatpg.command.player.ShowEquippedCmd;
import com.kt.techup.chatpg.command.player.ShowInventoryCmd;
import com.kt.techup.chatpg.command.player.ShowStatusCmd;
import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.player.Equipment;
import com.kt.techup.chatpg.player.EquipmentEnum;
import com.kt.techup.chatpg.player.EquipmentManager;
import com.kt.techup.chatpg.player.Player;

@Component
public class GameRunner implements CommandLineRunner {

	private final Map<String, Command> commandMap = new HashMap<>();

	@Override
	public void run(String... args) throws Exception {

		// 명령어 등록
		commandMap.put("내정보", new ShowStatusCmd());
		commandMap.put("장비", new ShowEquippedCmd());
		commandMap.put("인벤토리", new ShowInventoryCmd());

		Scanner sc = new Scanner(System.in);

		System.out.println("=== CHATPG에 오신 것을 환영합니다 ===");
		System.out.print("나의 이름은 무엇인지 여기에 입력해주세요 : ");
		String playerName = sc.nextLine();

		// 플레이어 생성
		Player player = new Player(playerName, 1, 100, 10, 5);
		GameContext context = new GameContext(player);

		Equipment weapon = new Equipment("낡은 검", 10, 0, 0, EquipmentEnum.WEAPON);
		Equipment helmet = new Equipment("가죽 모자", 0, 2, 10, EquipmentEnum.HELMET);
		Equipment armor = new Equipment("가죽 갑옷", 0, 3, 20, EquipmentEnum.ARMOR);
		Equipment boots = new Equipment("가죽 신발", 0, 1, 5, EquipmentEnum.BOOTS);
		Equipment accessory = new Equipment("낡은 반지", 5, 0, 10, EquipmentEnum.ACCESSORY);

		// 인벤토리에 장비 추가
		player.getInventory().add(weapon);
		player.getInventory().add(helmet);
		player.getInventory().add(armor);
		player.getInventory().add(boots);
		player.getInventory().add(accessory);

		// 기본 장비를 장착
		player.getEquipmentManager().equip(weapon);
		player.getEquipmentManager().equip(helmet);
		player.getEquipmentManager().equip(armor);
		player.getEquipmentManager().equip(boots);
		player.getEquipmentManager().equip(accessory);

		boolean running = true;

		while (running) {
			System.out.println("=====================================================================");
			System.out.println("아래는 게임 메뉴에요 진행할 행동을 아래와 보기처럼 입력해주세요");
			System.out.println("내정보");
			System.out.println("장비");
			System.out.println("인벤토리");
			System.out.println("던전");
			System.out.println("종료");
			System.out.print("무엇을 진행할까요?: ");
			String input = sc.nextLine();

			if ("종료".equalsIgnoreCase(input)) {
				System.out.println("게임을 종료합니다.");
				running = false;
				continue;
			}

			Command command = commandMap.get(input);
			if (command != null) {
				command.execute(context, input);
			} else {
				System.out.println("존재하지 않는 명령어입니다.");
			}

		}

		sc.close();
	}

}
