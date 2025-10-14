package com.kt.techup.chatpg.helper;

import java.util.List;

public class PrintHelper {
	private static final int DEFAULT_WIDTH = 150;

	// 콘솔 너비를 직접 알기 어려워서 기본값 사용
	public static int getConsoleWidth() {
		return DEFAULT_WIDTH;  // 필요하면 환경 변수나 시스템 프로퍼티 등에서 얻을 수도 있음
	}

	// 문자열 가운데 정렬
	public static String centerAlign(String text) {
		if (text == null || text.length() >= DEFAULT_WIDTH) {
			return text;
		}
		int leftPadding = (DEFAULT_WIDTH - text.length()) / 2;
		int rightPadding = DEFAULT_WIDTH - text.length() - leftPadding;
		return " ".repeat(leftPadding) + text + " ".repeat(rightPadding);
	}

	// 문자열 가운데 정렬
	public static void centerAlignPt(String text) {
		if (text == null || text.length() >= DEFAULT_WIDTH) {
			System.out.println(text);
		}
		int leftPadding = (DEFAULT_WIDTH - text.length()) / 2;
		int rightPadding = DEFAULT_WIDTH - text.length() - leftPadding;
		System.out.println(" ".repeat(leftPadding) + text + " ".repeat(rightPadding));
	}

	// 사각 박스 모양 출력 (내용은 그 안에 리스트 등)
	public static void printBox(List<String> lines) {
		int width = getConsoleWidth();
		System.out.println("╔" + "═".repeat(width - 2) + "╗");
		for (String line : lines) {
			String content = line;
			if (line.length() > width - 2) {
				content = line.substring(0, width - 2);
			}
			System.out.println("║" + centerAlign(content) + "║");
		}
		System.out.println("╚" + "═".repeat(width - 2) + "╝");
	}
}
