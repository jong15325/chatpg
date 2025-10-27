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
		PrintHelper.centerAlignPt("[HP: " + player.getBaseStats().getHp() + " + ("+ player.getAddStats().getHp() +")]");
		PrintHelper.centerAlignPt("[SP: " + player.getBaseStats().getSp() + " + ("+ player.getAddStats().getSp() +")]");
		PrintHelper.centerAlignPt("[ATK: " + player.getBaseStats().getAttack() + " + ("+ player.getAddStats().getAttack() +")]");
		PrintHelper.centerAlignPt("[DEF: " + player.getBaseStats().getDefense() + " + ("+ player.getAddStats().getDefense() +")]");
	}

}
