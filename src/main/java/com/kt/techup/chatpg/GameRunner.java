package com.kt.techup.chatpg;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.player.Equipment;
import com.kt.techup.chatpg.player.Player;

@Component
public class GameRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("=== CHATPG에 오신 것을 환영합니다 ===");
		System.out.print("나의 이름은 무엇인지 여기에 입력해주세요 : ");
		String playerName = sc.nextLine();

		// 플레이어 생성
		Player player = new Player(playerName, 1, 100, 10, 5);

		Equipment weapon = new Equipment("낡은 검", 10, 0, 0);
		Equipment helmet = new Equipment("가죽 모자", 0, 2, 10);
		Equipment armor = new Equipment("가죽 갑옷", 0, 3, 20);
		Equipment boots = new Equipment("가죽 신발", 0, 1, 5);
		Equipment accessory = new Equipment("낡은 반지", 5, 0, 10);

		player.equip(weapon, helmet, armor, boots, accessory);

		boolean running = true;

		while (running) {
			System.out.println("\n==============================");
			System.out.println("아래는 게임 메뉴에요 진행할 행동을 아래와 보기처럼 입력해주세요");
			System.out.println("내정보");
			System.out.println("장비");
			System.out.println("던전");
			System.out.println("종료");
			System.out.print("무엇을 진행할까요?: ");
			String choice = sc.nextLine();

			switch (choice) {
				case "내정보":
					player.showStatus();
					break;
				case "장비":
					player.showEquip();
					break;
				case "던전":
					running = false;
					break;
				case "종료":
					System.out.println("다음에 다시 만나요. 👋");
					running = false;
					break;
				default:
					System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
					break;
			}
		}

		sc.close();
	}

}
