package Test.SCP;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import Test.SCP.classes.MTF;
import Test.SCP.listeners.Signs;

public class SCP {

    public ArrayList<Player> spectators = new ArrayList<Player>();
	public ArrayList<Player> GamePlayers = new ArrayList<Player>();
	public ArrayList<Integer> countDown = new ArrayList<Integer>();
	
	public boolean GameActive = false;

	Game plugin;
	Signs signs;

    public void prepareGame(){

		GameActive = true;
    	
    	if(!(countDown.size() == 10)){
		  countDown.add(10);
		  countDown.add(9);
		  countDown.add(8);
		  countDown.add(7);
		  countDown.add(6);
		  countDown.add(5);
		  countDown.add(4);
		  countDown.add(3);
		  countDown.add(2);
		  countDown.add(1); 	  
    	}
    }
    
    public void postGame(Player GamePlayer){
   		  
		  for (Player player : GamePlayers) { 		    
				player.setHealth(20);
				
				Location lobbyLoc = player.getLocation();
				World world = Bukkit.getWorld(plugin.LOCATIONS_LOBBY_WORLD);
				lobbyLoc.setX(plugin.LOCATIONS_LOBBY_X);
				lobbyLoc.setX(plugin.LOCATIONS_LOBBY_Y);
				lobbyLoc.setX(plugin.LOCATIONS_LOBBY_Z);
				lobbyLoc.setWorld(world);
				player.teleport(lobbyLoc);
				
				GamePlayers.remove(player);
		  }
		  GameActive = false;
    }
    
    public void startGame(Player GamePlayer){
    	    			
    	prepareGame();
    	
    	for (Player player : GamePlayers) { 		    
			
		      for (int counter = 10; counter < countDown.size(); counter--) { 		      
		    	  player.sendMessage("game stars in " + countDown.get(counter));
		    	  
		    	  if(counter == 0){

			    	  player.sendMessage("Game started!!");
		    		  
		    	  }
		      }  
	     }
		
		setSCP(GamePlayer);
    }
    

	  public void setSCP(Player p){
		  
		  MTF mtf = new MTF(150, p);
		  
		  for(Player players : Bukkit.getServer().getOnlinePlayers()){
			  mtf.setMTF(players);
		  }
		  
		  
		  ArrayList<Player> Joueurs = new ArrayList<Player>(Bukkit.getServer().getOnlinePlayers().size());
		   
		  Joueurs.addAll(Bukkit.getOnlinePlayers());
		       
		  int random = new Random().nextInt(Joueurs.size());
		       
		  Player scp = (Player) Bukkit.getServer().getOnlinePlayers().toArray()[random];
		  Joueurs.remove(scp);
		  
		  p.sendMessage("111");
	  }

	    //SCPs
		public boolean SCP_TERMINATED = false;
		
		//Game
		public int GAME_TIME_MINS = 0;
		public int GAME_TIME_SECS = 0;
		public int GAME_RESTART_TIMER = 20;
		
		//Warhead
		public int WAREHED_TERMINATED = 0;
		public boolean WAREHED_DETONATED = false;
		
		public void EndMenu(Player sender){
			
			if(SCP_TERMINATED = true){
				
				sender.sendMessage("       MTF Win");
				
			} else if(SCP_TERMINATED = false){
				
				sender.sendMessage("       SCP Wins");
				
			}
			
			if(WAREHED_DETONATED == true){
			
			sender.sendMessage("Alpha Warehead Detonation Terminated " + WAREHED_TERMINATED + " beings");
			
			}else if(WAREHED_DETONATED == false){
				
				sender.sendMessage("       Alpha Warehead was not Detonated");
				
			}
			sender.sendMessage("");
			sender.sendMessage("The mission took " + GAME_TIME_MINS + " minutes and " + GAME_TIME_SECS + " seconds");
			sender.sendMessage("        Next round in " + GAME_RESTART_TIMER + " Seconds");
		}
}
