package com.kt.techup.chatpg.common;

import java.util.HashMap;
import java.util.Map;

import com.kt.techup.chatpg.command.Command;
import com.kt.techup.chatpg.command.ingame.GoDungeonCmd;
import com.kt.techup.chatpg.command.show.ShowEquippedCmd;
import com.kt.techup.chatpg.command.show.ShowInventoryCmd;
import com.kt.techup.chatpg.command.show.ShowStatusCmd;

public class CommandRegistry {
	private final Map<String, Command> commandMap = new HashMap<>();

	public CommandRegistry() {
		registerCommands();
	}

	private void registerCommands() {
		// Common commands
		commandMap.put("info", new ShowStatusCmd());
		commandMap.put("eq", new ShowEquippedCmd());
		commandMap.put("inven", new ShowInventoryCmd());

		// Battle commands
		//commandMap.put("attack", new AttackCmd());
		//commandMap.put("defense", new DefenseCmd());
		//commandMap.put("run", new RunCmd());

		// Game commands
		commandMap.put("dungeon", new GoDungeonCmd());
		//commandMap.put("exit", new ExitCmd());
	}

	public Command getCommand(String key) {
		return commandMap.get(key);
	}

	public Command getCommandList(String key) {
		return commandMap.get(key);
	}
}
