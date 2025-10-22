package com.kt.techup.chatpg.domain.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Stats {
	private final int hp;
	private final int sp;
	private final int attack;
	private final int defense;
}
