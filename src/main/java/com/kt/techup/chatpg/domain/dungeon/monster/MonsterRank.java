package com.kt.techup.chatpg.domain.dungeon.monster;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *packageName    : com.kt.techup.chatpg.domain.dungeon.monster
 * fileName       : MonsterRank
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
public enum MonsterRank {
	NORMAL("일반", 1.0, 1.0),
	ELITE("정예", 1.5, 2.0),
	BOSS("보스", 3.0, 5.0)

	;

	private final String name;
	private final double statsMultiplier;    // 스탯 배율
	private final double rewardMultiplier;   // 보상 배율
}
