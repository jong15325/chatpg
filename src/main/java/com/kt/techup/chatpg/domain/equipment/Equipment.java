package com.kt.techup.chatpg.domain.equipment;

import com.kt.techup.chatpg.domain.item.Item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Equipment {
	private final int itemIndex;
	private final Item item;
}
