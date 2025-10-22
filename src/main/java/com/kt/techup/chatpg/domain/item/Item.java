package com.kt.techup.chatpg.domain.item;

import com.kt.techup.chatpg.domain.player.Stats;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 게임 아이템의 기본 정보를 담는 추상 클래스
 * 모든 아이템은 이 클래스를 상속받아 구현됩니다
 */
@Getter
@RequiredArgsConstructor
public abstract class Item {
	private final int itemId;
	private final ItemType itemType;
	private final String itemName;
	private final Stats stats;
	private final String description;
}
