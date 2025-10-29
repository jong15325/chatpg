package com.kt.techup.chatpg.domain.player;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

import com.kt.techup.chatpg.domain.effect.Effect;
import com.kt.techup.chatpg.domain.effect.EffectType;
import com.kt.techup.chatpg.domain.equipment.Equipment;
import com.kt.techup.chatpg.domain.equipment.EquipmentType;
import com.kt.techup.chatpg.domain.inventory.Inventory;
import com.kt.techup.chatpg.domain.item.EquipmentItem;

import lombok.Getter;

@Getter
public class Player {

	private final String playerName;
	private int playerLevel;
	private int playerExp;
	private final Stats baseStats; // 기본 스탯
	private final Stats addStats; // 장비/소비 추가 스탯
	private final Stats currentStats; // 현재 스탯
	private List<Effect> effects; // 효과 적용
	private final Equipment equipment;
	private final Inventory inventory;

	public Player(String playerName) {
		this.playerName = playerName;
		this.playerLevel = 1;
		this.playerExp = 0;
		this.baseStats = new Stats(50, 20, 5, 1);
		this.addStats  = new Stats(0, 0, 0, 0);
		this.currentStats = new Stats(50, 20, 5, 1);
		this.equipment = new Equipment(new EnumMap<>(EquipmentType.class));
		this.inventory = new Inventory(new HashMap<>());
	}

	/**
	 * 장착 장비 스탯 증가
	 * @param item
	 */
	public void addStats(EquipmentItem item) {
		addStats.add(item.getStats());
	}

	/**
	 * 장착 장비 스탯 감소
	 * @param item
	 */
	public void subStats(EquipmentItem item) {
		addStats.sub(item.getStats());
	}

	/**
	 * 받는 데미지
	 * @param damage
	 */
	public int takeDamage(int damage) {
		return 0;
	}

	public boolean isDead() {
		return currentStats.getHp() <= 0;
	}

	public boolean gainExp(int exp) {
		return false;
	}

	public void resetCurrentStats() {
		// 스탯 회복
		// 사용 아이템 스탯 초기화
	}

}
