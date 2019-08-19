package Test.SCP.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class KitListener implements Listener{
	
	public void kitInteraction(InventoryClickEvent e){
		
    	Player player = (Player) e.getWhoClicked();

	    if (e.getCurrentItem().getType() == Material.REDSTONE && e.getCurrentItem().getType().name().equalsIgnoreCase("MedKit")) {
	    	e.getCurrentItem().setType(Material.AIR);
	    	player.setHealth(20);
	    }
     }
}
