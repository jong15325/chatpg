package com.kt.techup.chatpg.domain.battle;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *packageName    : com.kt.techup.chatpg.domain.battle
 * fileName       : BattleStatus
 * author         : howee
 * date           : 2025-11-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-11-04        howee       최초 생성
 */

@Getter
@RequiredArgsConstructor
public enum BattleStatus {
	ONGOING("진행 중"),
	VICTORY("승리"),
	DEFEAT("패배");

	private final String description;
}
