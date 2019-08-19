package Test.SCP.kits;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InventoryHandler {
	
	Player p;
	
	public InventoryHandler(Player p){
		this.p = p;
	}

	ItemStack[] inventory = p.getInventory().getContents();
	ItemStack[] saveInventory = new ItemStack[inventory.length];
	
	public void saveInventory(Player p){
		for(int i = 0; i < inventory.length; i++)
		{
		    if(inventory[i] != null)
		    {
		        saveInventory[i] = inventory[i].clone();
		    }
		}
	}
	
	public void loadInventory(Player player){
		
	    if(saveInventory != null){
            player.getInventory().setContents(saveInventory);
        }else{
            player.sendMessage(ChatColor.RED + "We're sorry, your items were not saved, it's all gone.");
        }
	}
}
