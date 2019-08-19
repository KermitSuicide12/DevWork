package Test.SCP.classes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import Test.SCP.Game;
import Test.SCP.kits.InventoryHandler;
import Test.SCP.kits.MTFKit;

public class MTF {
	
	Game plugin;
	MTFKit kit = new  MTFKit();
	
	private int health;
	private Player MTF;

	public MTF(int health, Player MTF) {
		this.health = health;
		this.MTF = MTF;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Player getMTF() {
		return MTF;
	}

	public void setMTF(Player MTF) {
		this.MTF = MTF;
		
		InventoryHandler inv = new InventoryHandler(MTF);
		inv.saveInventory(MTF);

		MTF.setGameMode(GameMode.SURVIVAL);
		
		Location location = (Location) this.MTF.getLocation();
		World world = Bukkit.getWorld(plugin.LOCATIONS_MTF_WORLD);
        location.setX(plugin.LOCATIONS_MTF_X);
        location.setY(plugin.LOCATIONS_MTF_Y);
        location.setZ(plugin.LOCATIONS_MTF_Z);
        location.setWorld(world);
        location.setYaw(2);
        
        MTF.teleport(location);
	    
        MTF.setHealth(20);
        MTF.setCustomName(ChatColor.DARK_BLUE + "[MTF] " + ChatColor.WHITE + MTF.getName());
        MTF.setCustomNameVisible(true);
        MTF.setDisplayName(ChatColor.DARK_BLUE + "[MTF] " + ChatColor.WHITE + MTF.getName());
                
        kit.give(MTF);
        
        MTF.sendMessage("You are now the MTF class");
	}

	 public void death(Player p){
		 
		 spec spec = new spec();

		 spec.set(p);
	 }
}
