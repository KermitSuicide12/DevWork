package Test.SCP.listeners;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import Test.SCP.SCP;

public class Signs implements Listener {
	
	SCP scp = new SCP();
	
	 @EventHandler
	 public void onSignChange(SignChangeEvent e) {
	    if(e.getLine(0).equalsIgnoreCase("[Mini SCP Join]")) {
	    	
	        e.setLine(0,ChatColor.GREEN + "[SCP Join]");
	        
	    } else if(e.getLine(0).equalsIgnoreCase("[Mini SCP Leave]")) {
	    	
	        e.setLine(0, ChatColor.GREEN + "[SCP Leave]");
	        
	    } else if(e.getLine(0).equalsIgnoreCase("[SCP Player List]")) {
	    	
	        e.setLine(0, ChatColor.GREEN + "[SCP Player List]");
	        
	    }
	}
	 
	 @EventHandler
	 public void SignClick(PlayerInteractEvent e) {
	 Player p = e.getPlayer();
	     if (e.getClickedBlock().getState() instanceof Sign) {
	         Sign sign = (Sign) e.getClickedBlock().getState();
	         if(sign.getLine(0).equalsIgnoreCase(ChatColor.GREEN + "[SCP Join]")) {
	        	 
                 if(!scp.GamePlayers.contains(p)){
	        		 
    	        	 scp.GamePlayers.add(p);
    	    		 p.sendMessage("You have joined the que for Mini SCP");

	        	 } else {
	        		 
		    		 p.sendMessage("You are already qued up for Mini SCP");

	        	 }
	    		 
	         } else if(sign.getLine(0).equalsIgnoreCase(ChatColor.GREEN + "[SCP Leave]")){
	        	 
                 if(scp.GamePlayers.contains(p)){
	        		 
    	        	 scp.GamePlayers.remove(p);
    	    		 p.sendMessage("You have left the que for Mini SCP");

	        	 } else {
	        		 
		    		 p.sendMessage("You have already left the qued for Mini SCP");

	        	 }	 
	         } else if(sign.getLine(0).equalsIgnoreCase(ChatColor.GREEN + "[SCP Player List]")){
	        	
    		    p.sendMessage("players Qued: " + scp.GamePlayers);
    		    
             }
	     }
	 }
}