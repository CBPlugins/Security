package org.cbplugins.security.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.cbplugins.security.Security;
import org.cbplugins.security.log.LogManager;

public class PlayerKickListener implements Listener {
	
	@EventHandler
	public void onPlayerKick(PlayerKickEvent e) {
		if(!Security.getInstance().getConfig().getBoolean("Log-Player-Kick")) return;
		if(e.isCancelled()) {
			LogManager.log("§7[§cSECURITY§7] §cPlayer §6" + e.getPlayer().getName() + " §cfailed kicking a player.");
		}else {
			LogManager.log("§7[§cSECURITY§7] §cPlayer §6" + e.getPlayer().getName() + " §ckicked a player.");
		}
	}

}
