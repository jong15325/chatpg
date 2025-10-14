package com.kt.techup.chatpg.player;

import java.util.List;
import com.kt.techup.chatpg.common.Character;

public class Player extends Character {

	int exp;
	private List<Equipment> inventory;  // 플레이어 인벤토리
	Equipment weapon;
	Equipment helmet;
	Equipment boots;
	Equipment armor;
	Equipment accessory;

	public Player(String name, int level, int hp, int attack, int defense) {
		super(name, level, hp, attack, defense);
		this.exp = 0;
	}

	public void equip(Equipment weapon, Equipment helmet, Equipment boots, Equipment armor, Equipment accessory) {
		this.weapon = weapon;
		this.helmet = helmet;
		this.boots = boots;
		this.armor = armor;
		this.accessory = accessory;
	}

	public void showEquip() {
		System.out.println("=== 장비 정보 ===");
		System.out.println("무기: " + weapon.getName() + " (ATK +" + weapon.getAttackBoost() + ", HP +" + helmet.getHpBoost() + ")");
		System.out.println("헬멧: " + helmet.getName() + " (DEF +" + helmet.getDefenseBoost() + ", HP +" + helmet.getHpBoost() + ")");
		System.out.println("갑옷: " + armor.getName() + " (DEF +" + armor.getDefenseBoost() + ", HP +" + armor.getHpBoost() + ")");
		System.out.println("신발: " + boots.getName() + " (DEF +" + boots.getDefenseBoost() + ", HP +" + boots.getHpBoost() + ")");
		System.out.println("악세사리: " + accessory.getName() + " (ATK +" + accessory.getAttackBoost() + ", HP +" + accessory.getHpBoost() + ")");
		System.out.println("================");
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
