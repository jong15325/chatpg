package com.kt.techup.chatpg.domain.battle;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *packageName    : com.kt.techup.chatpg.domain.battle
 * fileName       : TurnOwner
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
public enum TurnOwner {
	PLAYER("플레이어"),
	MONSTER("몬스터");

	private final String description;
}
