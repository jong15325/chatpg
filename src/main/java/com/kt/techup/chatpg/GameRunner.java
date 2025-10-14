package com.kt.techup.chatpg;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.command.Command;
import com.kt.techup.chatpg.command.CommandEnum;
import com.kt.techup.chatpg.common.CommandRegistry;
import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.helper.PrintHelper;
import com.kt.techup.chatpg.player.Equipment;
import com.kt.techup.chatpg.player.EquipmentEnum;
import com.kt.techup.chatpg.player.Player;

@Component
public class GameRunner implements CommandLineRunner {

	private final CommandRegistry commandRegistry = new CommandRegistry();

	@Override
	public void run(String... args) throws Exception {


		Scanner sc = new Scanner(System.in);

		PrintHelper.centerAlignPt("CHATPG에 오신 것을 환영합니다!");
		PrintHelper.centerAlignPt("나의 이름은 무엇인지 여기에 입력해주세요 : ");
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
		player.getEquipmentManager().getInventory().add(weapon);
		player.getEquipmentManager().getInventory().add(helmet);
		player.getEquipmentManager().getInventory().add(armor);
		player.getEquipmentManager().getInventory().add(boots);
		player.getEquipmentManager().getInventory().add(accessory);

		// 기본 장비를 장착
		player.getEquipmentManager().equip(weapon);
		player.getEquipmentManager().equip(helmet);
		player.getEquipmentManager().equip(armor);
		player.getEquipmentManager().equip(boots);
		player.getEquipmentManager().equip(accessory);

		boolean running = true;

		while (running) {
			PrintHelper.centerAlignPt("아래는 게임 메뉴에요");
			PrintHelper.centerAlignPt("진행할 행동을 아래 보기처럼 입력해주세요");

			String filterType = "main";
			for (CommandEnum commandEnum : CommandEnum.values()) {
				if (commandEnum.getType().equalsIgnoreCase(filterType)) {
					PrintHelper.centerAlignPt(
						"[ "+ commandEnum.getCommand() +" ] -> " +
							commandEnum.getDescription()
					);
				}
			}

			PrintHelper.centerAlignPt("무엇을 진행할까요?: ");
			String input = sc.nextLine();

			if ("종료".equalsIgnoreCase(input)) {
				PrintHelper.centerAlignPt("게임을 종료합니다.");
				running = false;
				continue;
			}

			Command command = commandRegistry.getCommand(input);
			if (command != null) {
				command.execute(context, input);
			} else {
				PrintHelper.centerAlignPt("존재하지 않는 명령어입니다.");
			}

		}

		sc.close();
	}

}
