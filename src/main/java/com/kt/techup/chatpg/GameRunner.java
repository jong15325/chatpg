package com.kt.techup.chatpg;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.common.GameContext;
import com.kt.techup.chatpg.domain.item.ItemData;
import com.kt.techup.chatpg.helper.CommandHelper;
import com.kt.techup.chatpg.helper.PrintHelper;
import com.kt.techup.chatpg.domain.player.Player;
import com.kt.techup.chatpg.service.EquipmentService;
import com.kt.techup.chatpg.service.InventoryService;
import com.kt.techup.chatpg.service.MainService;
import com.kt.techup.chatpg.state.StateFactory;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GameRunner implements CommandLineRunner {

	private final MainService mainService;
	private final InventoryService inventoryService;
	private final EquipmentService equipmentService;
	private final StateFactory stateFactory;

	@Override
	public void run(String... args) throws Exception {

		Scanner sc = new Scanner(System.in);

		PrintHelper.centerAlignPt("CHATPG에 오신 것을 환영합니다!");
		PrintHelper.centerAlignPt("나의 이름은 무엇인지 여기에 입력해주세요 : ");
		String playerName = sc.nextLine();

		// 플레이어 생성
		Player player = new Player(playerName);
		GameContext context = new GameContext(player, stateFactory);

		// 기본 아이템 지급
		player.getInventory().addItem(ItemData.WOODEN_STICK.getItem());
		player.getInventory().addItem(ItemData.TATTERED_CLOTH.getItem());
		player.getInventory().addItem(ItemData.CLOTH_TUNIC.getItem());
		player.getInventory().addItem(ItemData.LEATHER_SANDALS.getItem());
		player.getInventory().addItem(ItemData.COPPER_RING.getItem());

		// 기본 장비를 장착
		/*player.getEquipmentManager().equip(weapon);
		player.getEquipmentManager().equip(helmet);
		player.getEquipmentManager().equip(armor);
		player.getEquipmentManager().equip(boots);
		player.getEquipmentManager().equip(accessory);*/

		boolean running = true;

		while (true) {
			String input = sc.nextLine();
			context.getCurrentState().handleInput(input, context);
		}
	}
}
