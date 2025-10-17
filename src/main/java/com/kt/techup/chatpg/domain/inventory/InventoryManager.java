package com.kt.techup.chatpg.domain.inventory;

import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.domain.item.Item;
import com.kt.techup.chatpg.domain.player.Player;
import com.kt.techup.chatpg.helper.PrintHelper;

@Component
public class InventoryManager {

	// 인벤토리 출력
	public void showInventory(Player player) {
		if (player.getInventory().getItems().isEmpty()) {
			PrintHelper.centerAlignPt("빈 인벤토리입니다.");
		} else {
			for (int i = 0; i < player.getInventory().getItems().size(); i++) {
				Item item = player.getInventory().getItems().get(i);

				PrintHelper.centerAlignPt((i + 1) + ". " + item.getItemName() +
					" (ATK +" + item.getAttackBoost() +
					", DEF +" + item.getDefenseBoost() +
					", HP +" + item.getHpBoost() + ")");
			}
		}

	}

	// 아이템 보유 확인
	public boolean hasItem(Player player, Item item) {
		return player.getInventory().getItems().contains(item);
	}

	// 인벤토리에 아이템 추가
	public boolean addItem(Player player, Item item) {
		player.getInventory().getItems().add(item);

		return true;
	}

	// 인벤토리에서 아이템 제거
	public boolean removeItem(Player player, Item item) {
		if(!hasItem(player, item)) {
			PrintHelper.centerAlignPt("인벤토리에 아이템이 없습니다.");
			return false;
		}

		player.getInventory().getItems().remove(item);

		return true;
	}

}
