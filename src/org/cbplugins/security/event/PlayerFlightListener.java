package org.cbplugins.security.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.cbplugins.security.Security;
import org.cbplugins.security.log.LogManager;

public class PlayerFlightListener implements Listener {
	
	@EventHandler
	public void onPlayerFlight(PlayerToggleFlightEvent e) {
		if(!Security.getInstance().getConfig().getBoolean("Log-Player-Flight")) return;
		if(e.isCancelled()) {
			LogManager.log("§7[§cSECURITY§7] §cPlayer §6"+e.getPlayer().getName()+" §cfailed toggle flight.");
		}else {
			LogManager.log("§7[§cSECURITY§7] §cPlayer §6"+e.getPlayer().getName()+" §ctoggled flight.");
		}
	}

}
