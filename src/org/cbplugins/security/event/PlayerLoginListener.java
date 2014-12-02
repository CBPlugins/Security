package org.cbplugins.security.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.cbplugins.security.Security;
import org.cbplugins.security.log.LogManager;

public class PlayerLoginListener implements Listener {
	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e) {
		if(!Security.getInstance().getConfig().getBoolean("Log-Player-Login")) return;
		LogManager.log("§7[§cSECURITY§7] §cPlayer §6" + e.getPlayer().getName() + " §ctried logging in with result: " + e.getResult().toString());
	}

}
