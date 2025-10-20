package com.kt.techup.chatpg.service;

import org.springframework.stereotype.Service;

import com.kt.techup.chatpg.helper.CommandHelper;
import com.kt.techup.chatpg.helper.PrintHelper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MainService {

	public void welcomeMain() {
		PrintHelper.centerAlignPt("메인 광장에 입장했습니다");
		PrintHelper.centerAlignPt("진행할 행동을 아래 보기처럼 입력해주세요");

		CommandHelper.commandList("main");

		PrintHelper.centerAlignPt("무엇을 진행할까요?");

	}
}
