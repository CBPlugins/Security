package org.cbplugins.security.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.cbplugins.security.Security;
import org.cbplugins.security.log.LogManager;

public class PluginDisableListener implements Listener {
	
	@EventHandler
	public void onPluginDisable(PluginDisableEvent e) {
		if(!Security.getInstance().getConfig().getBoolean("Log-Plugin-Disable")) return;
		LogManager.log("§7[§cSECURITY§7] §cDisabled plugin §6" + e.getPlugin().getName());
	}

}
