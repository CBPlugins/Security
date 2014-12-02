package org.cbplugins.security.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.cbplugins.security.Security;
import org.cbplugins.security.log.LogManager;

public class PlayerCommandListener implements Listener {
	
	@EventHandler
	public void onPlayerCommand(PlayerCommandPreprocessEvent e) {
		if(!Security.getInstance().getConfig().getBoolean("Log-PlayerCommand")) return;
		if(e.isCancelled()) {
			LogManager.log("§7[§cSECURITY§7] §cPlayer §6"+e.getPlayer().getName()+" §cfailed executing command "+e.getMessage());
		}else {
			LogManager.log("§7[§cSECURITY§7] §cPlayer §6"+e.getPlayer().getName()+" §cexecuted command "+e.getMessage());
		}
	}

}
