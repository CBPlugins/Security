package org.cbplugins.security.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.cbplugins.security.Security;

public class LogManager {

	@SuppressWarnings("deprecation")
	public static void log(String log) {
		Date date = new Date();
		String d = "plugins/Security/"+date.getDay()+"-"+date.getMonth()+"-"+date.getYear()+".log";
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter out = null;
		try{
			File file = new File(d);
			if(!file.exists()) {
				file.createNewFile();
			}
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			StringBuffer sb = new StringBuffer();
			String sep = System.getProperty("line.separator");
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line + sep);
			}
			sb.append("["+new Date().toString() + "] "+log + sep);
			out = new FileWriter(d);
			out.write(sb.toString());
			for(Player p : getOnlinePlayers()) {
				if(Security.getInstance().getConfig().getBoolean(p.getName() + ".Notify")) {
					p.sendMessage(log);
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
			try{
				if(br != null) {
					br.close();
				}
				if(fr != null) {
					fr.close();
				}
				if(out != null) {
					out.close();
				}
			}catch(Exception ex) {}
		}finally {
			try{
				if(br != null) {
					br.close();
				}
				if(fr != null) {
					fr.close();
				}
				if(out != null) {
					out.close();
				}
			}catch(Exception ex) {}
		}
	}
	
	public static List<Player> getOnlinePlayers() {
		List<Player> players = new ArrayList<Player>();
		for(World w : Bukkit.getWorlds()) {
			for(Player p : w.getPlayers()) {
				players.add(p);
			}
		}
		return players;
	}
	
}
