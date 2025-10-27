package com.kt.techup.chatpg.domain.dungeon.monster;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *packageName    : com.kt.techup.chatpg.domain.dungeon.monster
 * fileName       : MonsterBehavior
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
public enum MonsterBehavior {
	AGGRESSIVE("공격적", "매 턴 공격"),
	DEFENSIVE("방어적", "HP가 낮으면 방어"),
	TACTICAL("전술적", "상황에 따라 행동 변경"),
	BERSERKER("광전사", "HP가 낮을수록 공격력 증가"),
	HEALER("치유형", "주기적으로 HP 회복");

	private final String name;
	private final String description;

}
