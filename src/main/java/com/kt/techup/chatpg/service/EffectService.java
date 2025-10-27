package com.kt.techup.chatpg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kt.techup.chatpg.domain.effect.Effect;

import lombok.RequiredArgsConstructor;

/**
 *packageName    : com.kt.techup.chatpg.service
 * fileName       : EffectService
 * author         : howee
 * date           : 2025-10-27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-10-27        howee       최초 생성
 */

@Service
@RequiredArgsConstructor
public class EffectService {
	private final List<Effect> activeEffects;

	/**
	 * 효과 추가
	 * @param effect
	 */
	public void addEffect(Effect effect) {
		activeEffects.add(effect);
	}

	/**
	 * 효과 제거
	 */
	public  void removeEffect(String effectName) {
		activeEffects.removeIf(effect -> effect.getEffectName().equals(effectName));
	}

	public void clearAllEffects() {
		activeEffects.clear();
	}
}
