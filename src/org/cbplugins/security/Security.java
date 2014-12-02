package org.cbplugins.security;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.cbplugins.security.command.NotifyExecutor;
import org.cbplugins.security.event.BlockBreakListener;
import org.cbplugins.security.event.BlockPlaceListener;
import org.cbplugins.security.event.EnchantItemListener;
import org.cbplugins.security.event.PlayerAchievementListener;
import org.cbplugins.security.event.PlayerChangeWorldListener;
import org.cbplugins.security.event.PlayerCommandListener;
import org.cbplugins.security.event.PlayerFlightListener;
import org.cbplugins.security.event.PlayerGamemodeChangeListener;
import org.cbplugins.security.event.PlayerJoinListener;
import org.cbplugins.security.event.PlayerKickListener;
import org.cbplugins.security.event.PlayerLoginListener;
import org.cbplugins.security.event.PlayerQuitListener;
import org.cbplugins.security.event.PlayerTeleportListener;
import org.cbplugins.security.event.PluginDisableListener;
import org.cbplugins.security.event.PluginEnableListener;

public class Security extends JavaPlugin {
	
	private static Security instance;
	
	public void onEnable() {
		saveDefaultConfig();
		saveConfig();
		instance = this;
		registerCommands();
		registerEvents();
	}
	
	public void registerCommands() {
		getCommand("notify").setExecutor(new NotifyExecutor());
	}
	
	public void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new BlockBreakListener(), this);
		pm.registerEvents(new BlockPlaceListener(), this);
		pm.registerEvents(new EnchantItemListener(), this);
		pm.registerEvents(new PlayerAchievementListener(), this);
		pm.registerEvents(new PlayerChangeWorldListener(), this);
		pm.registerEvents(new PlayerCommandListener(), this);
		pm.registerEvents(new PlayerFlightListener(), this);
		pm.registerEvents(new PlayerGamemodeChangeListener(), this);
		pm.registerEvents(new PlayerJoinListener(), this);
		pm.registerEvents(new PlayerKickListener(), this);
		pm.registerEvents(new PlayerLoginListener(), this);
		pm.registerEvents(new PlayerQuitListener(), this);
		pm.registerEvents(new PlayerTeleportListener(), this);
		pm.registerEvents(new PluginDisableListener(), this);
		pm.registerEvents(new PluginEnableListener(), this);
	}
	
	public static Security getInstance() {
		return instance;
	}

}
