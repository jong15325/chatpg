package com.kt.techup.chatpg.domain.item;

import com.kt.techup.chatpg.domain.equipment.EquipmentType;
import com.kt.techup.chatpg.domain.player.Stats;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 게임 내 모든 아이템 데이터를 관리하는 Enum
 * 각 아이템의 기본 스펙과 속성을 정의합니다
 */
@RequiredArgsConstructor
@Getter
public enum ItemData {

	// ========== 레벨 1 무기 (COMMON) ==========
	WOODEN_STICK(new EquipmentItem(1, EquipmentType.WEAPON, ItemTier.COMMON, 1, "나무 막대기", new Stats(5, 0, 5, 0), "평범한 나무로 만든 막대기. 시작하기엔 충분하다.")),
	RUSTY_DAGGER(new EquipmentItem(2, EquipmentType.WEAPON, ItemTier.COMMON, 1, "녹슨 단검", new Stats(0, 0, 6, 0), "오랜 세월 방치되어 녹이 슨 단검. 그래도 베는 건 가능하다.")),
	STONE_AXE(new EquipmentItem(3, EquipmentType.WEAPON, ItemTier.COMMON, 1, "돌 도끼", new Stats(0, 0, 7, 1), "날카롭게 갈은 돌날을 나무에 붙인 원시적인 도끼.")),

	// ========== 레벨 1 방어구 (COMMON) ==========
	TATTERED_CLOTH(new EquipmentItem(4, EquipmentType.HELMET, ItemTier.COMMON, 1, "낡은 천 두건", new Stats(10, 0, 0, 2), "해진 천으로 만든 두건. 햇빛을 가리는 정도의 역할만 한다.")),
	CLOTH_TUNIC(new EquipmentItem(5, EquipmentType.ARMOR, ItemTier.COMMON, 1, "천 튜닉", new Stats(15, 0, 0, 3), "얇은 천으로 만든 간단한 상의. 방어력은 기대하지 말자.")),
	LEATHER_SANDALS(new EquipmentItem(6, EquipmentType.BOOTS, ItemTier.COMMON, 1, "가죽 샌들", new Stats(8, 0, 0, 1), "발을 보호하는 최소한의 신발. 돌부리를 조심하자.")),
	COPPER_RING(new EquipmentItem(7, EquipmentType.ACCESSORY, ItemTier.COMMON, 1, "구리 반지", new Stats(5, 0, 2, 1), "구리로 만든 저렴한 반지. 약간의 마력이 깃들어 있다.")),

	// ========== 레벨 2 무기 (COMMON) ==========
	IRON_SHORTSWORD(new EquipmentItem(8, EquipmentType.WEAPON, ItemTier.COMMON, 2, "철 단검", new Stats(0, 0, 9, 0), "철로 단조된 짧은 검. 초보 모험가들이 애용한다.")),
	HUNTING_BOW(new EquipmentItem(9, EquipmentType.WEAPON, ItemTier.COMMON, 2, "사냥용 활", new Stats(5, 0, 8, 0), "작은 동물을 사냥하기 위한 활. 원거리 공격이 가능하다.")),
	WOODEN_CLUB(new EquipmentItem(10, EquipmentType.WEAPON, ItemTier.COMMON, 2, "나무 곤봉", new Stats(0, 0, 10, 1), "튼튼한 나무로 만든 곤봉. 단순하지만 효과적이다.")),

	// ========== 레벨 2 방어구 (COMMON) ==========
	LEATHER_CAP(new EquipmentItem(11, EquipmentType.HELMET, ItemTier.COMMON, 2, "가죽 모자", new Stats(15, 0, 0, 3), "부드러운 가죽으로 만든 모자. 머리를 보호해준다.")),
	LEATHER_VEST(new EquipmentItem(12, EquipmentType.ARMOR, ItemTier.COMMON, 2, "가죽 조끼", new Stats(20, 0, 0, 4), "질긴 가죽으로 만든 조끼. 가볍고 움직이기 편하다.")),
	LEATHER_BOOTS(new EquipmentItem(13, EquipmentType.BOOTS, ItemTier.COMMON, 2, "가죽 장화", new Stats(12, 0, 0, 2), "튼튼한 가죽 장화. 긴 여행에 적합하다.")),
	BRONZE_RING(new EquipmentItem(14, EquipmentType.ACCESSORY, ItemTier.COMMON, 2, "청동 반지", new Stats(10, 0, 3, 1), "청동으로 제작된 반지. 구리보다는 나은 마력을 지녔다.")),

	// ========== 레벨 3 무기 (COMMON~RARE) ==========
	STEEL_SWORD(new EquipmentItem(15, EquipmentType.WEAPON, ItemTier.COMMON, 3, "강철 검", new Stats(0, 0, 12, 0), "탄탄하게 단조된 강철 검. 믿을 수 있는 무기다.")),
	CRIMSON_BLADE(new EquipmentItem(16, EquipmentType.WEAPON, ItemTier.RARE, 3, "진홍의 검", new Stats(10, 0, 15, 2), "붉은빛이 도는 신비한 검. 진홍의 늑대를 쓰러뜨린 전사의 무기.")),
	FROST_SPEAR(new EquipmentItem(17, EquipmentType.WEAPON, ItemTier.RARE, 3, "서리 창", new Stats(15, 0, 14, 1), "얼음처럼 차가운 창날. 찌르면 냉기가 퍼진다.")),

	// ========== 레벨 3 방어구 (COMMON~RARE) ==========
	IRON_HELMET(new EquipmentItem(18, EquipmentType.HELMET, ItemTier.COMMON, 3, "철 투구", new Stats(22, 0, 0, 5), "철로 만든 견고한 투구. 머리를 확실히 보호한다.")),
	STEEL_CHAINMAIL(new EquipmentItem(19, EquipmentType.ARMOR, ItemTier.COMMON, 3, "강철 사슬갑옷", new Stats(30, 0, 0, 6), "강철 고리를 엮어 만든 갑옷. 베는 공격에 강하다.")),
	WOLF_BOOTS(new EquipmentItem(20, EquipmentType.BOOTS, ItemTier.RARE, 3, "늑대 가죽 부츠", new Stats(18, 0, 2, 3), "진홍의 늑대 가죽으로 만든 부츠. 민첩함이 향상된다.")),
	SILVER_RING(new EquipmentItem(21, EquipmentType.ACCESSORY, ItemTier.RARE, 3, "은 반지", new Stats(15, 0, 5, 2), "순은으로 만든 반지. 마법 저항력이 있다.")),

	// ========== 레벨 4 무기 (RARE) ==========
	VOLCANIC_MACE(new EquipmentItem(22, EquipmentType.WEAPON, ItemTier.RARE, 4, "화산 메이스", new Stats(12, 0, 17, 2), "화산암으로 만든 메이스. 뜨겁고 무거운 타격을 가한다.")),
	VENOM_DAGGER(new EquipmentItem(23, EquipmentType.WEAPON, ItemTier.RARE, 4, "맹독 단검", new Stats(8, 0, 16, 0), "맹독 미믹의 독이 스며든 단검. 한 방에 치명상을 입힌다.")),
	BLAZING_STAFF(new EquipmentItem(24, EquipmentType.WEAPON, ItemTier.RARE, 4, "불꽃 지팡이", new Stats(20, 0, 15, 1), "불꽃 하피의 깃털로 장식된 지팡이. 화염 마법을 증폭시킨다.")),

	// ========== 레벨 4 방어구 (RARE) ==========
	BEAR_HELMET(new EquipmentItem(25, EquipmentType.HELMET, ItemTier.RARE, 4, "곰 가죽 투구", new Stats(28, 0, 1, 7), "화산 곰의 두터운 가죽으로 만든 투구. 열기에 강하다.")),
	REINFORCED_ARMOR(new EquipmentItem(26, EquipmentType.ARMOR, ItemTier.RARE, 4, "강화 갑옷", new Stats(40, 0, 0, 9), "특수 처리된 철판으로 보강한 갑옷. 방어력이 뛰어나다.")),
	HARPY_BOOTS(new EquipmentItem(27, EquipmentType.BOOTS, ItemTier.RARE, 4, "하피 깃털 신발", new Stats(22, 0, 3, 4), "불꽃 하피의 깃털로 만든 신발. 발걸음이 가벼워진다.")),
	VOLCANIC_RING(new EquipmentItem(28, EquipmentType.ACCESSORY, ItemTier.RARE, 4, "화산석 반지", new Stats(18, 0, 7, 3), "화산에서 채취한 붉은 보석이 박힌 반지. 화염 저항력을 준다.")),

	// ========== 레벨 5 무기 (RARE) ==========
	IRON_GREATSWORD(new EquipmentItem(29, EquipmentType.WEAPON, ItemTier.RARE, 5, "철 대검", new Stats(15, 0, 20, 3), "무거운 철로 만든 양손 대검. 강력한 베기 공격이 가능하다.")),
	CENTAUR_SPEAR(new EquipmentItem(30, EquipmentType.WEAPON, ItemTier.RARE, 5, "센타우르 창", new Stats(20, 0, 19, 2), "철의 센타우르스가 사용하던 창. 찌르기에 특화되어 있다.")),
	TIGER_CLAW(new EquipmentItem(31, EquipmentType.WEAPON, ItemTier.RARE, 5, "호랑이 발톱", new Stats(10, 0, 21, 0), "사막 호랑이의 발톱으로 만든 무기. 빠른 연속 공격이 가능하다.")),

	// ========== 레벨 5 방어구 (RARE) ==========
	IRON_PLATE_HELM(new EquipmentItem(32, EquipmentType.HELMET, ItemTier.RARE, 5, "철 판금 투구", new Stats(35, 0, 2, 9), "두꺼운 철판으로 만든 투구. 묵직하지만 든든하다.")),
	STEEL_PLATE_ARMOR(new EquipmentItem(33, EquipmentType.ARMOR, ItemTier.RARE, 5, "강철 판금 갑옷", new Stats(50, 0, 1, 12), "강철 판을 이어붙여 만든 전신 갑옷. 최고의 방어력을 자랑한다.")),
	SAND_BOOTS(new EquipmentItem(34, EquipmentType.BOOTS, ItemTier.RARE, 5, "사막 행군 신발", new Stats(28, 0, 2, 5), "사막을 누비는 데 최적화된 신발. 모래 위에서도 미끄러지지 않는다.")),
	GOLD_RING(new EquipmentItem(35, EquipmentType.ACCESSORY, ItemTier.RARE, 5, "금 반지", new Stats(25, 0, 9, 4), "순금으로 만든 화려한 반지. 강력한 마력을 담고 있다.")),

	// ========== 레벨 6 무기 (EPIC) ==========
	NIGHTMARE_SCYTHE(new EquipmentItem(36, EquipmentType.WEAPON, ItemTier.EPIC, 6, "악몽의 낫", new Stats(25, 0, 24, 3), "악몽의 레이스가 휘두르던 검은 낫. 영혼까지 베어낸다.")),
	STORM_BLADE(new EquipmentItem(37, EquipmentType.WEAPON, ItemTier.EPIC, 6, "폭풍의 검", new Stats(30, 0, 23, 2), "번개를 머금은 검. 베는 순간 번개가 터진다.")),
	DREAD_HAMMER(new EquipmentItem(38, EquipmentType.WEAPON, ItemTier.EPIC, 6, "공포의 망치", new Stats(20, 0, 26, 4), "공포의 기사가 휘두르던 거대한 망치. 공포 그 자체다.")),

	// ========== 레벨 6 방어구 (EPIC) ==========
	WRAITH_HELMET(new EquipmentItem(39, EquipmentType.HELMET, ItemTier.EPIC, 6, "레이스 투구", new Stats(45, 0, 3, 12), "악몽의 레이스의 기운이 담긴 투구. 정신력을 보호한다.")),
	KNIGHT_ARMOR(new EquipmentItem(40, EquipmentType.ARMOR, ItemTier.EPIC, 6, "기사 갑옷", new Stats(65, 0, 2, 15), "공포의 기사가 입었던 검은 갑옷. 저주받았지만 강력하다.")),
	STORM_BOOTS(new EquipmentItem(41, EquipmentType.BOOTS, ItemTier.EPIC, 6, "폭풍 장화", new Stats(35, 0, 4, 7), "폭풍을 타고 걷는 듯한 장화. 발걸음이 번개처럼 빠르다.")),
	WITCH_AMULET(new EquipmentItem(42, EquipmentType.ACCESSORY, ItemTier.EPIC, 6, "마녀의 부적", new Stats(40, 0, 12, 5), "폭풍 마녀의 마력이 깃든 부적. 마법 공격력이 증가한다.")),

	// ========== 레벨 7 무기 (EPIC) ==========
	THUNDER_AXE(new EquipmentItem(43, EquipmentType.WEAPON, ItemTier.EPIC, 7, "천둥 도끼", new Stats(30, 0, 28, 4), "천둥 미노타우로스의 도끼. 휘두르면 천둥이 울린다.")),
	BASILISK_FANG(new EquipmentItem(44, EquipmentType.WEAPON, ItemTier.EPIC, 7, "바실리스크 송곳니", new Stats(25, 0, 27, 2), "맹독 바실리스크의 독니로 만든 검. 맹독이 흐른다.")),
	COSMIC_ORB(new EquipmentItem(45, EquipmentType.WEAPON, ItemTier.EPIC, 7, "우주의 오브", new Stats(45, 0, 25, 3), "우주의 코볼트가 지니고 있던 신비한 구슬. 별의 힘이 담겨있다.")),

	// ========== 레벨 7 방어구 (EPIC) ==========
	MINOTAUR_HELMET(new EquipmentItem(46, EquipmentType.HELMET, ItemTier.EPIC, 7, "미노타우로스 뿔 투구", new Stats(55, 0, 4, 14), "천둥 미노타우로스의 뿔로 만든 투구. 맹렬한 기세를 담았다.")),
	SCALE_ARMOR(new EquipmentItem(47, EquipmentType.ARMOR, ItemTier.EPIC, 7, "비늘 갑옷", new Stats(80, 0, 3, 18), "바실리스크의 단단한 비늘로 만든 갑옷. 독에도 강하다.")),
	KOBOLD_BOOTS(new EquipmentItem(48, EquipmentType.BOOTS, ItemTier.EPIC, 7, "코볼트 장화", new Stats(42, 0, 3, 8), "우주의 코볼트가 신던 장화. 중력을 거스를 수 있다.")),
	THUNDER_RING(new EquipmentItem(49, EquipmentType.ACCESSORY, ItemTier.EPIC, 7, "천둥 반지", new Stats(50, 0, 15, 6), "천둥의 기운이 깃든 반지. 번개 마법에 능숙해진다.")),

	// ========== 레벨 8 무기 (EPIC~LEGENDARY) ==========
	GOLEM_FIST(new EquipmentItem(50, EquipmentType.WEAPON, ItemTier.EPIC, 8, "골렘의 주먹", new Stats(35, 0, 32, 6), "고대 골렘의 주먹을 떼어내 만든 건틀릿. 암석처럼 단단하다.")),
	SPIDER_DAGGER(new EquipmentItem(51, EquipmentType.WEAPON, ItemTier.EPIC, 8, "여왕 거미 독침", new Stats(30, 0, 30, 3), "여왕 거미의 독침으로 만든 단검. 신경독이 스며있다.")),
	MOONLIGHT_KATANA(new EquipmentItem(52, EquipmentType.WEAPON, ItemTier.LEGENDARY, 8, "월광 도", new Stats(45, 0, 35, 5), "월광 뱀파이어가 휘두르던 은빛 도. 달빛을 머금고 있다.")),

	// ========== 레벨 8 방어구 (EPIC~LEGENDARY) ==========
	ANCIENT_HELMET(new EquipmentItem(53, EquipmentType.HELMET, ItemTier.EPIC, 8, "고대 투구", new Stats(70, 0, 5, 18), "고대 문명의 유물 투구. 세월의 무게가 느껴진다.")),
	GOLEM_ARMOR(new EquipmentItem(54, EquipmentType.ARMOR, ItemTier.EPIC, 8, "골렘 갑옷", new Stats(105, 0, 4, 22), "고대 골렘의 파편으로 만든 갑옷. 거의 부술 수 없다.")),
	VAMPIRE_BOOTS(new EquipmentItem(55, EquipmentType.BOOTS, ItemTier.LEGENDARY, 8, "뱀파이어 부츠", new Stats(55, 0, 6, 10), "월광 뱀파이어가 신던 부츠. 그림자처럼 조용히 움직인다.")),
	SPIDER_AMULET(new EquipmentItem(56, EquipmentType.ACCESSORY, ItemTier.EPIC, 8, "거미 부적", new Stats(65, 0, 18, 8), "여왕 거미의 눈을 가공한 부적. 촉각이 예민해진다.")),

	// ========== 레벨 9 무기 (LEGENDARY) ==========
	INFERNO_BLADE(new EquipmentItem(57, EquipmentType.WEAPON, ItemTier.LEGENDARY, 9, "지옥불 검", new Stats(50, 0, 40, 6), "지옥불 맨티코어의 불꽃을 담은 검. 베면 모든 것이 타오른다.")),
	GRIFFIN_TALON(new EquipmentItem(58, EquipmentType.WEAPON, ItemTier.LEGENDARY, 9, "그리핀 발톱", new Stats(55, 0, 38, 5), "창공의 그리핀의 발톱으로 만든 무기. 하늘을 찢는다.")),
	CHIMERA_STAFF(new EquipmentItem(59, EquipmentType.WEAPON, ItemTier.LEGENDARY, 9, "키메라 지팡이", new Stats(60, 0, 37, 4), "심연의 키메라의 뼈로 만든 지팡이. 혼돈의 마법을 다룬다.")),

	// ========== 레벨 9 방어구 (LEGENDARY) ==========
	MANTICORE_HELMET(new EquipmentItem(60, EquipmentType.HELMET, ItemTier.LEGENDARY, 9, "맨티코어 투구", new Stats(85, 0, 7, 22), "지옥불 맨티코어의 가죽으로 만든 투구. 불꽃에 면역이다.")),
	SKY_ARMOR(new EquipmentItem(61, EquipmentType.ARMOR, ItemTier.LEGENDARY, 9, "창공 갑옷", new Stats(130, 0, 6, 28), "창공의 그리핀 깃털로 짠 갑옷. 가볍고 하늘을 나는 듯하다.")),
	ABYSS_BOOTS(new EquipmentItem(62, EquipmentType.BOOTS, ItemTier.LEGENDARY, 9, "심연 장화", new Stats(70, 0, 8, 12), "심연의 키메라 가죽으로 만든 장화. 어둠 속에서도 걸을 수 있다.")),
	CHIMERA_NECKLACE(new EquipmentItem(63, EquipmentType.ACCESSORY, ItemTier.LEGENDARY, 9, "키메라 목걸이", new Stats(80, 0, 22, 10), "키메라의 심장 조각으로 만든 목걸이. 세 가지 마법을 사용할 수 있다.")),

	// ========== 레벨 10 무기 (LEGENDARY) ==========
	DRAGON_FANG(new EquipmentItem(64, EquipmentType.WEAPON, ItemTier.LEGENDARY, 10, "드래곤 송곳니", new Stats(70, 0, 50, 8), "천상의 드래곤의 송곳니로 만든 검. 신성한 기운이 흐른다.")),
	HYDRA_BLADE(new EquipmentItem(65, EquipmentType.WEAPON, ItemTier.LEGENDARY, 10, "히드라 검", new Stats(65, 0, 48, 7), "태초의 히드라의 독니로 만든 검. 베인 상처는 재생되지 않는다.")),
	PHOENIX_WING(new EquipmentItem(66, EquipmentType.WEAPON, ItemTier.LEGENDARY, 10, "피닉스 날개", new Stats(80, 0, 45, 6), "광휘의 피닉스의 날개로 만든 검. 부활의 힘이 깃들었다.")),

	// ========== 레벨 10 방어구 (LEGENDARY) ==========
	CELESTIAL_CROWN(new EquipmentItem(67, EquipmentType.HELMET, ItemTier.LEGENDARY, 10, "천상의 왕관", new Stats(110, 0, 10, 28), "천상의 드래곤이 지키던 왕관. 하늘의 축복을 받는다.")),
	DRAGON_SCALE_ARMOR(new EquipmentItem(68, EquipmentType.ARMOR, ItemTier.LEGENDARY, 10, "드래곤 비늘 갑옷", new Stats(170, 0, 8, 35), "천상의 드래곤의 비늘로 만든 갑옷. 거의 무적에 가깝다.")),
	RADIANT_BOOTS(new EquipmentItem(69, EquipmentType.BOOTS, ItemTier.LEGENDARY, 10, "광휘의 장화", new Stats(90, 0, 10, 15), "광휘의 피닉스 깃털로 만든 장화. 빛의 속도로 달린다.")),
	PRIMORDIAL_RING(new EquipmentItem(70, EquipmentType.ACCESSORY, ItemTier.LEGENDARY, 10, "태초의 반지", new Stats(110, 0, 30, 12), "태초의 히드라가 지니고 있던 반지. 고대의 힘이 깃들었다.")),

	// ========== 세트 1: 서리 사냥꾼 세트 (COMMON, Lv2) ==========
	FROST_HUNTER_SWORD(new EquipmentItem(71, EquipmentType.WEAPON, ItemTier.COMMON, 2, "[서리] 얼음 단검", new Stats(8, 0, 11, 0), "서리 유충의 얼음 조각으로 만든 단검. 차가운 냉기가 흐른다.")),
	FROST_HUNTER_HELMET(new EquipmentItem(72, EquipmentType.HELMET, ItemTier.COMMON, 2, "[서리] 서리 투구", new Stats(18, 0, 1, 4), "얼음으로 굳어진 투구. 차가움에 익숙해진다.")),
	FROST_HUNTER_ARMOR(new EquipmentItem(73, EquipmentType.ARMOR, ItemTier.COMMON, 2, "[서리] 서리 갑옷", new Stats(25, 0, 0, 5), "서리로 뒤덮인 갑옷. 냉기 공격에 강하다.")),
	FROST_HUNTER_BOOTS(new EquipmentItem(74, EquipmentType.BOOTS, ItemTier.COMMON, 2, "[서리] 서리 신발", new Stats(14, 0, 1, 3), "얼음 위에서도 미끄러지지 않는 신발.")),
	FROST_HUNTER_RING(new EquipmentItem(75, EquipmentType.ACCESSORY, ItemTier.COMMON, 2, "[서리] 서리 반지", new Stats(12, 0, 4, 2), "얼음 마법이 깃든 반지. 세트 효과: 냉기 저항 +20%")),

	// ========== 세트 2: 그림자 자객 세트 (RARE, Lv4) ==========
	SHADOW_BLADE(new EquipmentItem(76, EquipmentType.WEAPON, ItemTier.RARE, 4, "[그림자] 암영 단검", new Stats(10, 0, 18, 1), "그림자 프롱혼의 뿔로 만든 단검. 어둠에 숨는다.")),
	SHADOW_HOOD(new EquipmentItem(77, EquipmentType.HELMET, ItemTier.RARE, 4, "[그림자] 암영 두건", new Stats(30, 0, 2, 8), "그림자에 녹아드는 검은 두건. 은신에 유리하다.")),
	SHADOW_VEST(new EquipmentItem(78, EquipmentType.ARMOR, ItemTier.RARE, 4, "[그림자] 암영 조끼", new Stats(45, 0, 1, 10), "그림자로 짠 조끼. 가볍고 소리가 나지 않는다.")),
	SHADOW_BOOTS(new EquipmentItem(79, EquipmentType.BOOTS, ItemTier.RARE, 4, "[그림자] 암영 부츠", new Stats(25, 0, 4, 5), "그림자를 밟고 걷는 부츠. 발소리가 사라진다.")),
	SHADOW_RING(new EquipmentItem(80, EquipmentType.ACCESSORY, ItemTier.RARE, 4, "[그림자] 암영 반지", new Stats(20, 0, 8, 4), "그림자 마법이 깃든 반지. 세트 효과: 치명타 확률 +15%")),


	//소비 물약
	RED_POTION(new ConsumableItem(1000, "빨간 물약", new Stats(10, 0, 18, 1), "HP 50을 회복한다"))

	;

	private final Item item;

}
