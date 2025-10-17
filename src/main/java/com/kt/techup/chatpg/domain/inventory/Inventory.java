package com.kt.techup.chatpg.domain.inventory;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.domain.item.Item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Inventory {
	private final List<Item> items;
}
