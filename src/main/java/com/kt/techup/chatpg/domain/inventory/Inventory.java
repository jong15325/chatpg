package com.kt.techup.chatpg.domain.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.domain.item.Item;
import com.kt.techup.chatpg.domain.player.Player;
import com.kt.techup.chatpg.helper.PrintHelper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Inventory {
	private final Map<Integer, Item> items;
	private int inventoryNextId = 0;

	/**
	 * 다음 인벤토리 아이디 생성
	 * @return 다음 인벤토리 id
	 */
	public int generateNextInventoryId() {
		return inventoryNextId++;
	}

	/**
	 * 해당하는 inventoryId로 인벤토리에 있는 아이템 반환
	 * @param inventoryId
	 * @return 아이템 정보 반환 (빈 슬롯이면 empty)
	 */
	public Optional<Item> getItemByIdx(int inventoryId) {
		if(inventoryId < 0) {
			return Optional.empty();
		}

		return Optional.ofNullable(items.get(inventoryId));
	}

	/**
	 * 인벤토리에 해당 id를 가진 아이템이 있는지 여부
	 * @param itemId
	 * @return 있으면 true 없으면 false
	 */
	public boolean hasItemById(int itemId) {
		return items.values().stream()
			.anyMatch(item -> item.getItemId() == itemId);
	}

	/**
	 * 아이템을 인벤토리에 삽입
	 * @param item
	 * @return nextId 추가된 인벤토리 id
	 */
	public int addItem(Item item) {
		int nextId = generateNextInventoryId();

		items.put(nextId, item);

		return nextId;
	}

	/**
	 * 특정 아이템을 인벤토리에서 제거 (첫 번째로 발견된 아이템)
	 * @param inventoryId
	 * @return 성공 여부
	 */
	public void removeItem(int inventoryId) {
		items.remove(inventoryId);
	}

	/**
	 * 인벤토리 전체 슬롯 크기
	 * @return 전체 슬롯 개수
	 */
	public int getSize() {
		return items.size();
	}
}
