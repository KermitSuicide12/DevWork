package Test.SCP.classes;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class spec {

    public void spectatorMode(Player spec){

    	
    }

	public void set(Player gamePlayer) {
		gamePlayer.setGameMode(GameMode.SPECTATOR);
    	
		gamePlayer.setDisplayName(ChatColor.WHITE + gamePlayer.getName());
		gamePlayer.sendMessage("You are spectator");
		
	}
}
