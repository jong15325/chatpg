package com.kt.techup.chatpg.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.kt.techup.chatpg.command.Command;
import com.kt.techup.chatpg.command.move.MoveDungeonCmd;
import com.kt.techup.chatpg.command.show.ShowEquippedCmd;
import com.kt.techup.chatpg.command.show.ShowInventoryCmd;
import com.kt.techup.chatpg.command.show.ShowStatusCmd;
import com.kt.techup.chatpg.service.InventoryService;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CommandRegistry {

	private final InventoryService inventoryService;

	private final Map<String, Command> commandMap = new HashMap<>();

	@PostConstruct
	private void registerCommands() {
		// Common commands
		commandMap.put("info", new ShowStatusCmd());
		commandMap.put("eq", new ShowEquippedCmd());
		commandMap.put("inven", new ShowInventoryCmd(inventoryService));

		// Battle commands
		//commandMap.put("attack", new AttackCmd());
		//commandMap.put("defense", new DefenseCmd());
		//commandMap.put("run", new RunCmd());

		// Game commands
		commandMap.put("dungeon", new MoveDungeonCmd());
		//commandMap.put("exit", new ExitCmd());
	}

	public Command getCommand(String key) {
		return commandMap.get(key);
	}
}
