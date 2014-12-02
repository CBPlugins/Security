package org.cbplugins.security.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.cbplugins.security.Security;
import org.cbplugins.security.log.LogManager;

public class EnchantItemListener implements Listener {
	
	@EventHandler
	public void onEnchantItem(EnchantItemEvent e) {
		if(!Security.getInstance().getConfig().getBoolean("Log-Enchant-Item")) return;
		if(e.isCancelled()) {
			LogManager.log("§7[§cSECURITY§7] §cPlayer §6" + e.getEnchanter().getName() + " §cfailed enchanting Item " + e.getItem().getType().toString());
		}else {
			LogManager.log("§7[§cSECURITY§7] §cPlayer §6" + e.getEnchanter().getName() + " §cenchanted Item " + e.getItem().getType().toString());
		}
	}

}
