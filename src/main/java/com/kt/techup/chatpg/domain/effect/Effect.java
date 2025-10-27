package com.kt.techup.chatpg.domain.effect;

import com.kt.techup.chatpg.domain.player.Stats;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *packageName    : com.kt.techup.chatpg.domain.player
 * fileName       : Effect
 * author         : howee
 * date           : 2025-10-27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-10-27        howee       최초 생성
 */

@Getter
@RequiredArgsConstructor
public class Effect {
	private final String effectName;
	private final Stats stats;
	private final int duration;
	private final EffectType effectType;
}
