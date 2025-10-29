package com.kt.techup.chatpg.domain.dungeon.monster;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MonsterData {

	// 1레벨
	EMBER_SERPENT("타오르는 뱀", 1, 28, 7, 2, 5, 1, 4),
	SHADOW_PRONGHORN("그림자 프롱혼", 1, 32, 6, 2, 6, 1, 4),
	FROST_LARVA("서리 유충", 1, 33, 5, 3, 7, 1, 4),

	// 2레벨
	DAWN_GOBLIN("여명의 고블린", 2, 37, 8, 3, 8, 3, 4),
	VINE_BAT("덩굴 박쥐", 2, 36, 8, 2, 8, 3, 4),
	GLASS_BEETLE("유리 딱정벌레", 2, 34, 9, 3, 9, 3, 4),

	// 3레벨
	/*CRIMSON_WOLF("진홍의 늑대", 3, 45, 11, 5, 12),
	SILENT_SCORPION("침묵의 전갈", 3, 43, 10, 3, 13),
	GLACIAL_SKELETON("빙결 해골", 3, 47, 11, 4, 13),
	// 4레벨
	VOLCANIC_BEAR("화산 곰", 4, 56, 13, 6, 16),
	VENOM_MIMIC("맹독 미믹", 4, 54, 12, 7, 18),
	BLAZING_HARPY("불꽃 하피", 4, 50, 13, 6, 17),
	// 5레벨
	IRON_CENTAUR("철의 센타우르스", 5, 66, 16, 8, 20),
	CRYPT_BANDIT("지하실 도적", 5, 65, 17, 7, 20),
	SAND_TIGER("사막 호랑이", 5, 70, 15, 8, 22),
	// 6레벨
	NIGHTMARE_WRAITH("악몽의 레이스", 6, 83, 19, 9, 27),
	STORM_WITCH("폭풍 마녀", 6, 80, 20, 10, 27),
	DREAD_KNIGHT("공포의 기사", 6, 97, 20, 11, 29),
	// 7레벨
	THUNDER_MINOTAUR("천둥 미노타우로스", 7, 115, 23, 11, 33),
	VENOMOUS_BASILISK("맹독 바실리스크", 7, 102, 19, 13, 34),
	COSMIC_KOBOLD("우주의 코볼트", 7, 92, 18, 9, 32),
	// 8레벨
	ANCIENT_GOLEM("고대 골렘", 8, 151, 28, 15, 45),
	QUEEN_SPIDER("여왕 거미", 8, 133, 22, 14, 44),
	MOONLIGHT_VAMPIRE("월광 뱀파이어", 8, 120, 26, 13, 54),
	// 9레벨
	INFERNO_MANTICORE("지옥불 맨티코어", 9, 145, 30, 17, 73),
	SKY_GRIFFIN("창공의 그리핀", 9, 140, 29, 15, 70),
	ABYSS_CHIMERA("심연의 키메라", 9, 153, 31, 17, 77),
	// 10레벨
	CELESTIAL_DRAGON("천상의 드래곤", 10, 225, 39, 19, 130),
	PRIMORDIAL_HYDRA("태초의 히드라", 10, 210, 38, 20, 120),
	RADIANT_PHOENIX("광휘의 피닉스", 10, 198, 36, 18, 110);*/

	;

	private final String name;
	private final int level;
	private final int hp;
	private final int attack;
	private final int defense;
	private final int expReward;
	private final int minFloor;
	private final int maxFloor;

	/**
	 * 출현 가능한 몬스터인지 확인
	 * @param floor
	 * @return 현재 층이 최소와 최대층 사이에서 출현 가능한 몬스터인지 여부 반환
	 */
	public boolean canSpawnAt(int floor) {
		return floor >= minFloor && floor <= maxFloor;
	}
	
}
