package com.kt.techup.chatpg.helper;

import com.kt.techup.chatpg.common.CommandEnum;

public class CommandHelper {

	public static void commandList(String filterType) {
		PrintHelper.centerAlignPt("[가능한 명령어 리스트]");
		for (
			CommandEnum commandEnum : CommandEnum.values()) {
			if (commandEnum.getType().equalsIgnoreCase(filterType)) {
				PrintHelper.centerAlignPt(
					"[ "+ commandEnum.getCommand() +" ] -> " +
						commandEnum.getDescription()
				);
			}
		}
	}


}
