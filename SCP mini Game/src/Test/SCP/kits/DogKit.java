package Test.SCP.kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DogKit {
	
	public void give(Player p){
		 
		 //armour
		 ItemStack head = new ItemStack(Material.DIAMOND_HELMET);
			ItemMeta headMeta = head.getItemMeta();
			headMeta.setDisplayName(ChatColor.DARK_RED + "[SCP] " + ChatColor.WHITE +"helmet");
			headMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
			head.setItemMeta(headMeta);
			
			ItemStack body = new ItemStack(Material.DIAMOND_CHESTPLATE);
			ItemMeta bodyMeta = body.getItemMeta();
			bodyMeta.setDisplayName(ChatColor.DARK_RED + "[SCP] " + ChatColor.WHITE +"body armour");
			bodyMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
			body.setItemMeta(bodyMeta);
			
			ItemStack leg= new ItemStack(Material.DIAMOND_LEGGINGS);
			ItemMeta legMeta = leg.getItemMeta();
			legMeta.setDisplayName(ChatColor.DARK_RED + "[SCP] " + ChatColor.WHITE +"leggings");
			legMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
			leg.setItemMeta(legMeta);
			
			ItemStack feet = new ItemStack(Material.DIAMOND_BOOTS);
			ItemMeta feetMeta = feet.getItemMeta();
			feetMeta.setDisplayName(ChatColor.DARK_RED + "[SCP] " + ChatColor.WHITE +"boots");
			feetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
			feet.setItemMeta(feetMeta);
			
			//items
			ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
			ItemMeta swordMeta = sword.getItemMeta();
			swordMeta.setDisplayName(ChatColor.DARK_RED + "[SCP] " + ChatColor.WHITE +"melee");
			swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
			swordMeta.addEnchant(Enchantment.DURABILITY, 5, true);
			sword.setItemMeta(swordMeta);
			
			ItemStack medkit = new ItemStack(Material.REDSTONE);
			ItemMeta medkitMeta = medkit.getItemMeta();
			medkitMeta.setDisplayName(ChatColor.DARK_RED + "Medkit");
			medkit.setItemMeta(medkitMeta);
			
			p.getInventory().setHelmet(head);
			p.getInventory().setChestplate(body);
			p.getInventory().setLeggings(leg);
			p.getInventory().setBoots(feet);
			p.getInventory().setItem(0, sword);
			p.getInventory().setItem(1, medkit);
	 }
	
	public void remove(Player p){

		 //armour
		 ItemStack head = new ItemStack(Material.DIAMOND_HELMET);
			ItemMeta headMeta = head.getItemMeta();
			headMeta.setDisplayName(ChatColor.DARK_RED + "[SCP] " + ChatColor.WHITE +"helmet");
			headMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
			head.setItemMeta(headMeta);
			
			ItemStack body = new ItemStack(Material.DIAMOND_CHESTPLATE);
			ItemMeta bodyMeta = body.getItemMeta();
			bodyMeta.setDisplayName(ChatColor.DARK_RED + "[SCP] " + ChatColor.WHITE +"body armour");
			bodyMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
			body.setItemMeta(bodyMeta);
			
			ItemStack leg= new ItemStack(Material.DIAMOND_LEGGINGS);
			ItemMeta legMeta = leg.getItemMeta();
			legMeta.setDisplayName(ChatColor.DARK_RED + "[SCP] " + ChatColor.WHITE +"leggings");
			legMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
			leg.setItemMeta(legMeta);
			
			ItemStack feet = new ItemStack(Material.DIAMOND_BOOTS);
			ItemMeta feetMeta = feet.getItemMeta();
			feetMeta.setDisplayName(ChatColor.DARK_RED + "[SCP] " + ChatColor.WHITE +"boots");
			feetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
			feet.setItemMeta(feetMeta);
			
			//items
			ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
			ItemMeta swordMeta = sword.getItemMeta();
			swordMeta.setDisplayName(ChatColor.DARK_RED + "[SCP] " + ChatColor.WHITE +"melee");
			swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
			swordMeta.addEnchant(Enchantment.DURABILITY, 5, true);
			sword.setItemMeta(swordMeta);
			
			ItemStack medkit = new ItemStack(Material.REDSTONE);
			ItemMeta medkitMeta = medkit.getItemMeta();
			medkitMeta.setDisplayName(ChatColor.DARK_RED + "Medkit");
			medkit.setItemMeta(medkitMeta);
			
			p.getInventory().remove(head);
			p.getInventory().remove(body);
			p.getInventory().remove(leg);
			p.getInventory().remove(feet);
			p.getInventory().remove(sword);
			p.getInventory().remove(medkit);
	}
}