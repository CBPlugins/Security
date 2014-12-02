package org.cbplugins.security.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cbplugins.security.Security;

public class NotifyExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("[SECURITY] You have to be a player.");
			return true;
		}
		
		Player p = (Player)sender;
		
		if(p.hasPermission("security.notify")) {
			boolean alreadyUse = Security.getInstance().getConfig().getBoolean(p.getName() + ".Notify");
			if(alreadyUse) {
				Security.getInstance().getConfig().set(p.getName() + ".Notify", false);
				Security.getInstance().saveConfig();
				p.sendMessage("§7[§cSECURITY§7] §cYou disabled notifications.");
				return true;
			}else {
				Security.getInstance().getConfig().set(p.getName() + ".Notify", true);
				Security.getInstance().saveConfig();
				p.sendMessage("§7[§cSECURITY§7] §cYou enabled notifications.");
				return true;
			}
		}else {
			p.sendMessage("§7[§cSECURITY§7] §cYou don't have permission.");
			return true;
		}
	}

}
