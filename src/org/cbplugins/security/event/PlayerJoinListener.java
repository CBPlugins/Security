package org.cbplugins.security.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.cbplugins.security.Security;
import org.cbplugins.security.log.LogManager;

public class PlayerJoinListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if(!Security.getInstance().getConfig().getBoolean("Log-Player-Join")) return;
		LogManager.log("§7[§cSECURITY§7] §cPlayer §6"+e.getPlayer().getName() + " §cjoined the game");
	}

}
