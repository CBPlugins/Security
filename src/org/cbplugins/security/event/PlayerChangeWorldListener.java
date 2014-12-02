package org.cbplugins.security.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.cbplugins.security.Security;
import org.cbplugins.security.log.LogManager;

public class PlayerChangeWorldListener implements Listener {
	
	@EventHandler
	public void onPlayerChangeWorld(PlayerChangedWorldEvent e) {
		if(!Security.getInstance().getConfig().getBoolean("Log-Player-Change-World")) return;
		LogManager.log("§7[§cSECURITY§7] §cPlayer §6" + e.getPlayer().getName() + " §cchanged world from " + e.getFrom().getName() + " to " + e.getPlayer().getWorld().getName());
	}

}
