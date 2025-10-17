package com.kt.techup.chatpg.service;

import org.springframework.stereotype.Service;

import com.kt.techup.chatpg.domain.player.PlayerManager;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerService {
	private final PlayerManager playerManager;

	public void createPlayer() {
		playerManager.createPlayer();
	}

}
