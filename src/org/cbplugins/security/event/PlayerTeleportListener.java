package org.cbplugins.security.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.cbplugins.security.Security;
import org.cbplugins.security.log.LogManager;
import org.cbplugins.security.util.LocationParser;

public class PlayerTeleportListener implements Listener {
	
	@EventHandler
	public void onPlayerTeleport(PlayerTeleportEvent e) {
		if(!Security.getInstance().getConfig().getBoolean("Log-Player-Teleport")) return;
		if(e.isCancelled()) {
			LogManager.log("§7[§cSECURITY§7] §cPlayer §6"+e.getPlayer().getName()+" §cfailed teleport to "+LocationParser.locationToString(e.getTo()));
		}else {
			LogManager.log("§7[§cSECURITY§7] §cPlayer §6"+e.getPlayer().getName()+" §cteleported to "+LocationParser.locationToString(e.getTo()));
		}
	}

}
