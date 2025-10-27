package com.kt.techup.chatpg.domain.dungeon.monster;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *packageName    : com.kt.techup.chatpg.domain.dungeon.monster
 * fileName       : MonsterTrait
 * author         : kt_backend_jjh
 * date           : 2025. 10. 27.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 10. 27.        kt_backend_jjh       최초 생성
 */

@Getter
@RequiredArgsConstructor
public enum MonsterTrait {
	NONE("없음", "특수 능력 없음"),
	REGENERATION("재생", "매 턴 HP 5% 회복"),
	COUNTER("반격", "공격받을 시 50% 확률로 반격"),
	ARMOR("강화 방어", "방어력 +50%"),
	CRITICAL("치명타", "30% 확률로 공격력 2배"),
	POISON("독", "공격 시 독 상태이상 부여"),
	FURY("분노", "HP 50% 이하 시 공격력 2배");

	private final String name;
	private final String description;
}
