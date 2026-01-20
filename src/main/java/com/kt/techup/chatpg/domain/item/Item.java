package com.kt.techup.chatpg.domain.item;

import com.kt.techup.chatpg.domain.player.Stats;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class Item {
	private final int itemId;
	private final ItemType itemType;
	private final String itemName;
	private final Stats stats;
	private final String description;
}
