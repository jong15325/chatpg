package com.kt.techup.chatpg.domain.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.domain.item.Item;
import com.kt.techup.chatpg.domain.player.Player;
import com.kt.techup.chatpg.helper.PrintHelper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class Inventory {
	private final List<Item> items;

	public Inventory() {
		this.items = new ArrayList<>();
	}

	/**
	 * 해당하는 인덱스의 인벤토리에 있는 아이템 반환
	 * @param inventoryIdx
	 * @return 아이템 정보 반환
	 */
	public Optional<Item> getItemByIdx(int inventoryIdx) {
		if(inventoryIdx < 0 || inventoryIdx >= items.size()) {
			return Optional.empty();
		}

		return Optional.of(items.get(inventoryIdx));
	}

	/**
	 * 인벤토리에 해당 아이템이 있는지 여부
	 * @param itemId
	 * @return 있으면 true 없으면 false
	 */
	public boolean hasItemById(int itemId) {
		return items.stream()
			.anyMatch(item -> item.getItemId() == itemId);
	}

	/**
	 * itemId에 해당하는 아이템을 인벤토리에 삽입
	 * @param item
	 * @return 성공 여부
	 */
	public void addItem(Item item) {
		items.add(item);
	}

	/**
	 * 특정 아이템을 인벤토리에서 제거
	 * @param item
	 * @return 성공 여부
	 */
	public boolean removeItem(Item item) {
		return items.remove(item);
	}

	/**
	 * 인벤토리의 특정 idx의 아이템 제거
	 * @param inventoryIdx
	 * @return 제거된 아이템 정보 반환 없으면 empty
	 */
	public Optional<Item> removeItemByIdx(int inventoryIdx) {
		if (inventoryIdx < 0 || inventoryIdx >= items.size()) {
			return Optional.empty();
		}

		return Optional.of(items.remove(inventoryIdx));
	}
}
