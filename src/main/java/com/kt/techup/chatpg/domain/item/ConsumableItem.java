package com.kt.techup.chatpg.domain.item;

import com.kt.techup.chatpg.domain.item.effect.ConsumableEffect;

import lombok.Getter;

/**
 * 소비 아이템을 나타내는 클래스
 * 포션, 음식, 버프 아이템 등 일회성으로 사용 가능한 아이템을 포함합니다
 * Strategy Pattern을 사용하여 다양한 효과를 적용합니다
 */
@Getter
public class ConsumableItem extends Item {
	private final ConsumableEffect effect;

}
