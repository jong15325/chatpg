package com.kt.techup.chatpg.domain.dungeon;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *packageName    : com.kt.techup.chatpg.domain.dungeon
 * fileName       : DungeonRoomType
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
public enum DungeonRoomType {
	NORMAL("일반 방", "몬스터가 출현합니다"),
	ELITE("정예 방", "강력한 몬스터가 출현합니다"),
	BOSS("보스 방", "보스 몬스터가 출현합니다"),
	TREASURE("보물 방", "아이템을 획득할 수 있습니다"),
	REST("휴식 방", "HP/SP를 회복할 수 있습니다"),
	SHOP("상점 방", "아이템을 구매할 수 있습니다"),
	EVENT("이벤트 방", "랜덤 이벤트가 발생합니다");

	private final String name;
	private final String description;
}
