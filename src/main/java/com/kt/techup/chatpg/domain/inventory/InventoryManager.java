package com.kt.techup.chatpg.domain.inventory;

import com.kt.techup.chatpg.domain.item.Item;
import com.kt.techup.chatpg.helper.PrintHelper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InventoryManager {

	private final Inventory inventory;

	// 남은 슬롯 수
	public int getRemainingSlot() {
		return inventory.getMaxSize() - inventory.getItems().size();
	}

	// 보유 아이템 확인
	public boolean hasItem(Item item) {
		return inventory.getItems().contains(item);
	}

	// 인벤토리에 아이템 추가
	public boolean addItem(Item item) {
		if(getRemainingSlot() < 1) {
			PrintHelper.centerAlignPt("인벤토리에 남은 슬롯이 없습니다.");
			return false;
		}

		inventory.getItems().add(item);

		return true;
	}

	// 인벤토리에서 아이템 제거
	public boolean removeItem(Item item) {
		if(!hasItem(item)) {
			PrintHelper.centerAlignPt("인벤토리에 아이템이 없습니다.");
			return false;
		}

		inventory.getItems().remove(item);

		return true;
	}

}
