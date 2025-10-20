package com.kt.techup.chatpg.helper;

import com.kt.techup.chatpg.common.CommandEnum;

public class CommandHelper {

	public static void commandList(String filterType) {
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
