package org.cbplugins.security.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.cbplugins.security.Security;
import org.cbplugins.security.log.LogManager;
import org.cbplugins.security.util.LocationParser;

public class BlockPlaceListener implements Listener {
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		if(!Security.getInstance().getConfig().getBoolean("Log-Block-Place")) return;
		if(e.isCancelled()) {
			LogManager.log("§7[§cSECURITY§7] §cPlayer §6" + e.getPlayer().getName() + " §cfailed placing block at " + LocationParser.locationToString(e.getBlock().getLocation()));
		}else {
			LogManager.log("§7[§cSECURITY§7] §cPlayer §6" + e.getPlayer().getName() + " §cplaced block at " + LocationParser.locationToString(e.getBlock().getLocation()));
		}
	}

}
