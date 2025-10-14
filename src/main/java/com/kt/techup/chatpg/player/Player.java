package com.kt.techup.chatpg.player;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import com.kt.techup.chatpg.common.Character;
import com.kt.techup.chatpg.helper.PrintHelper;

import lombok.Getter;

@Getter
public class Player extends Character {

	private int exp;
	private final EquipmentManager equipmentManager;

	public Player(String name, int level, int hp, int attack, int defense) {
		super(name, level, hp, attack, defense);
		this.equipmentManager = new EquipmentManager(new ArrayList<>());
	}

	public void showStatus() {
		PrintHelper.centerAlignPt("    [Lv." + level + "] "+ name);
		PrintHelper.centerAlignPt("|   [HP: " + hp + "]   |");
		PrintHelper.centerAlignPt("|   [ATK: " + attack + "]   |");
		PrintHelper.centerAlignPt("|   [DEF: " + defense + "]   |");
	}

	@Override
	public void attack(Character target) {
		int totalDamage = attack - target.getDefense();
		PrintHelper.centerAlignPt(name + "이(가) " + target.getName() + "을(를) 공격! (" + totalDamage + " 피해)");
		target.takeDamage(totalDamage);
	}

	@Override
	public void takeDamage(int damage) {
		hp -= damage;
		if (hp <= 0) {
			hp = 0;
			PrintHelper.centerAlignPt(name + "이(가) 쓰러졌습니다!");
		} else {
			PrintHelper.centerAlignPt(name + "의 남은 HP: " + hp);
		}
	}

}
