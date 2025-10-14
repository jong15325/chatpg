package com.kt.techup.chatpg.monster;

import com.kt.techup.chatpg.common.Character;

public class Monster extends com.kt.techup.chatpg.common.Character {

	private MonsterEnum type;

	public Monster(String name, int level, int hp, int attack, int defense) {
		super(name, level, hp, attack, defense);
	}

	public Monster(MonsterEnum type) {
		super(type.getName(), type.getLevel(), type.getHp(), type.getAttack(), type.getDefense());
		this.type = type;
	}

	@Override
	public void attack(Character target) {
		int totalDamage = attack - target.defense;
		System.out.println(name + "이(가) " + target.name + "을(를) 공격! (" + totalDamage + " 피해)");
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
