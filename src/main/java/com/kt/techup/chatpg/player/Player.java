package com.kt.techup.chatpg.player;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import com.kt.techup.chatpg.common.Character;

import lombok.Getter;

@Getter
public class Player extends Character {

	private int exp;
	private final List<Equipment> inventory;
	private final EquipmentManager equipmentManager;

	public Player(String name, int level, int hp, int attack, int defense) {
		super(name, level, hp, attack, defense);
		this.inventory = new ArrayList<>();
		this.equipmentManager = new EquipmentManager(inventory);
	}

	public void showStatus() {
		System.out.println("=== 내 정보 ===");
		System.out.println(name + " [Lv." + level + "] HP: " + hp + " ATK: " + attack + " DEF: " + defense);
		System.out.println("================");
	}

	@Override
	public void attack(Character target) {
		int totalDamage = attack - target.getDefense();
		System.out.println(name + "이(가) " + target.getName() + "을(를) 공격! (" + totalDamage + " 피해)");
		target.takeDamage(totalDamage);
	}

	@Override
	public void takeDamage(int damage) {
		hp -= damage;
		if (hp <= 0) {
			hp = 0;
			System.out.println(name + "이(가) 쓰러졌습니다!");
		} else {
			System.out.println(name + "의 남은 HP: " + hp);
		}
	}

}
