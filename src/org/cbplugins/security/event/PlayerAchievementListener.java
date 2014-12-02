package org.cbplugins.security.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.cbplugins.security.Security;
import org.cbplugins.security.log.LogManager;

public class PlayerAchievementListener implements Listener {
	
	@EventHandler
	public void onPlayerAchievement(PlayerAchievementAwardedEvent e) {
		if(!Security.getInstance().getConfig().getBoolean("Log-Player-Achievement")) return;
		if(e.isCancelled()) {
			LogManager.log("§7[§cSECURITY§7] §cPlayer §6" + e.getPlayer().getName() + " §cfailed awarding achievement " + e.getAchievement().toString());
		}else {
			LogManager.log("§7[§cSECURITY§7] §cPlayer §6" + e.getPlayer().getName() + " §cawarded achievement " + e.getAchievement().toString());
		}
	}

}
