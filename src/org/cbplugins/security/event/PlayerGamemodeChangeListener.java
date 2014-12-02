package org.cbplugins.security.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.cbplugins.security.Security;
import org.cbplugins.security.log.LogManager;

public class PlayerGamemodeChangeListener implements Listener { 
	
	@EventHandler
	public void onGamemodeChange(PlayerGameModeChangeEvent e) {
		if(!Security.getInstance().getConfig().getBoolean("Log-GamemodeChange")) return;
		if(e.isCancelled()) {
			LogManager.log("§7[§cSECURITY§7] §cPlayer §6"+e.getPlayer().getName() + " §cfailed changing gamemode.");
		}else {
			LogManager.log("§7[§cSECURITY§7] §cPlayer §6"+e.getPlayer().getName() + " §cchanged gamemode.");
		}
	}

}
