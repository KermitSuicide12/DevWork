package Test.SCP.classes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import Test.SCP.Game;
import Test.SCP.kits.DogKit;

public class Dog {
		
	DogKit kit = new DogKit();
	Game plugin;
		
	private int health = 3300;
	private Player SCP;

	public Dog(int health, Player SCP) {
		this.health = health;
		this.SCP = SCP;

	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Player getSCP() {
		return SCP;
	}

	public void setSCP(Player SCP) {
		this.SCP = SCP;
		
		//InventoryHandler inv = new InventoryHandler(SCP);
		//inv.saveInventory(SCP);

		SCP.setGameMode(GameMode.SURVIVAL);
				
		Location location = (Location) this.SCP.getLocation();
		World world = Bukkit.getWorld(plugin.LOCATIONS_SCP_WORLD);
        location.setX(plugin.LOCATIONS_SCP_X);
        location.setY(plugin.LOCATIONS_SCP_Y);
        location.setZ(plugin.LOCATIONS_SCP_Z);
        location.setWorld(world);
        location.setYaw(2);
        
        SCP.teleport(location);
	    
        SCP.setHealth(20);
        SCP.setCustomName(ChatColor.DARK_BLUE + "[SCP] " + ChatColor.WHITE + SCP.getName());
        SCP.setCustomNameVisible(true);
        SCP.setDisplayName(ChatColor.DARK_BLUE + "[SCP] " + ChatColor.WHITE + SCP.getName());
                
        kit.give(SCP);
        
        SCP.sendMessage("You are now the SCP class");
	}

	 public void death(Player p){
		 
		 spec spec = new spec(); 

		 spec.set(p);
	 }
}
