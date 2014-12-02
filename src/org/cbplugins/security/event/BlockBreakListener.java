package org.cbplugins.security.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.cbplugins.security.Security;
import org.cbplugins.security.log.LogManager;
import org.cbplugins.security.util.LocationParser;

public class BlockBreakListener implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if(!Security.getInstance().getConfig().getBoolean("Log-Block-Break")) return;
		if(e.isCancelled()) {
			LogManager.log("§7[§cSECURITY§7] §cPlayer §6" + e.getPlayer().getName() + " §cfailed breaking block at " + LocationParser.locationToString(e.getBlock().getLocation()));
		}else {
			LogManager.log("§7[§cSECURITY§7] §cPlayer §6" + e.getPlayer().getName() + " §cbroke block at " + LocationParser.locationToString(e.getBlock().getLocation()));
		}
	}

}
