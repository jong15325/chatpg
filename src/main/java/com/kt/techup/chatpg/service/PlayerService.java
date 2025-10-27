package com.kt.techup.chatpg.service;

import org.springframework.stereotype.Service;

import com.kt.techup.chatpg.domain.player.Player;
import com.kt.techup.chatpg.helper.PrintHelper;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class PlayerService {

	public void welcomeMsg() {
		PrintHelper.centerAlignPt("스테이터스 열기!");
	}

	public void leaveMsg() {
		PrintHelper.centerAlignPt("스테이터스 닫기!");
	}

	public void showStatus(Player player) {
		PrintHelper.centerAlignPt("[Lv." + player.getPlayerLevel() + "] "+ player.getPlayerName());
		PrintHelper.centerAlignPt("[HP: " + player.getStats().getHp() + "]");
		PrintHelper.centerAlignPt("[SP: " + player.getStats().getSp() + "]");
		PrintHelper.centerAlignPt("[ATK: " + player.getStats().getAttack() + "]");
		PrintHelper.centerAlignPt("[DEF: " + player.getStats().getDefense() + "]");
	}

}
