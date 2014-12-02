package org.cbplugins.security.util;

import org.bukkit.Location;

public class LocationParser {

	public static String locationToString(Location loc) {
		return loc.getWorld().getName() + ", " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ();
	}
	
}
