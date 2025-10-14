package com.kt.techup.chatpg.monster;

public class MonsterManager {

	public Monster createMonsterByLevel(int level) {
		for (MonsterEnum m : MonsterEnum.values()) {
			if (m.getLevel() == level) {
				return new Monster(m);
			}
		}
		// 없으면 기본 몬스터
		return new Monster(MonsterEnum.EMBER_SERPENT);
	}
}
