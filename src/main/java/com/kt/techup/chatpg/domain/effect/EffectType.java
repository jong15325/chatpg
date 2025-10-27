package com.kt.techup.chatpg.domain.effect;

/**
 *packageName    : com.kt.techup.chatpg.domain.effect
 * fileName       : EffectType
 * author         : howee
 * date           : 2025-10-27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-10-27        howee       최초 생성
 */
public enum EffectType {
	BUFF,           // 버프
	DEBUFF,         // 디버프
	INSTANT_HEAL,   // 즉시 회복
	INSTANT_DAMAGE, // 즉시 데미지
	DOT_DAMAGE,            // 지속 데미지
	DOT_HEAL             // 지속 회복
}
