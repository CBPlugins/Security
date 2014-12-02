package org.cbplugins.security.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.cbplugins.security.Security;
import org.cbplugins.security.log.LogManager;

public class PluginEnableListener implements Listener {
	
	@EventHandler
	public void onPluginEnable(PluginEnableEvent e) {
		if(!Security.getInstance().getConfig().getBoolean("Log-Plugin-Enable")) return;
		LogManager.log("§7[§cSECURITY§7] §cEnabled plugin §6" + e.getPlugin().getName());
	}

}
