package Test.SCP;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;

public class Commands implements CommandExecutor {
	
	Game game;
	
	SCP scp = new SCP();
	
	public Commands(Game game) {
		
		this.game = game;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		Player GamePlayer = (Player) sender;

		if (args.length == 0 || (args.length >= 1 && args[0].toLowerCase().equals("help")) ){
			if (sender instanceof Player && !sender.hasPermission("ponytools.help")) {
				sender.sendMessage(game.PLUGIN_PREFIX + ChatColor.RED + game.PLUGIN_COMMAND_NO_PERMISSION);
				return false;
			}
			
			int page = 1;
			int totalpages = 1; //change when you add a page on the case below
			
			if(args.length >= 2){
				try {
					page = Integer.parseInt(args[1]);
				} catch (Exception ignored) {
					sender.sendMessage(game.PLUGIN_PREFIX + ChatColor.RED + "Invalid Page number");
					return false;
				}
			}
			if(page<1)
				page = 1;
			
			if(page>totalpages)
				page = totalpages;

			//display help
			sender.sendMessage("" + ChatColor.DARK_GRAY + ChatColor.STRIKETHROUGH + "--------------" + ChatColor.DARK_AQUA + " SCP Mini Game v" + game.getDescription().getVersion() + " Help " + ChatColor.DARK_GRAY + ChatColor.STRIKETHROUGH + "--------------");
			
			sender.sendMessage("");
			switch(page){
				case 1:
				default:
					sender.sendMessage(ChatColor.DARK_AQUA + "/scp help [page] " + ChatColor.WHITE + "- Show Mini SCP commands help.");
					sender.sendMessage(ChatColor.DARK_AQUA + "/scp reload " + ChatColor.WHITE + "- Reload the Mini SCP config.");
					sender.sendMessage(ChatColor.DARK_AQUA + "/scp start " + ChatColor.WHITE + "- Force start the Game.");
					sender.sendMessage(ChatColor.DARK_AQUA + "/SCP location SCP|MTF|Lobby " + ChatColor.WHITE + "- Sets current location to selected class spawn.");
					break;
			}
			sender.sendMessage("");
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[Page &f" + page + "&7 of &f" + totalpages + "&7]"));
			sender.sendMessage("" + ChatColor.DARK_GRAY + ChatColor.STRIKETHROUGH + "---------------------------------------------------");
			
		}else if (args.length >= 1) {		
            
			switch (args[0].toLowerCase()) {
			
			default:
					sender.sendMessage(game.PLUGIN_PREFIX + ChatColor.RED + "Unknown command");
					return true;
					
			    case "reload":

					game.reloadConfig();
					game.loadConfig();
			    	GamePlayer.sendMessage(game.PLUGIN_PREFIX + "Mini SCP config reloaded.");
			    	break;

				case "start":

		    		scp.startGame(GamePlayer);
					break;
					
				case "location":
					
					int X = GamePlayer.getLocation().getBlockX();
					int Y = GamePlayer.getLocation().getBlockY();
					int Z = GamePlayer.getLocation().getBlockZ();
					String world = GamePlayer.getLocation().getWorld().getName();
					
					if(args[0].equalsIgnoreCase("SCP")){

						game.getConfig().set("Locations.SCP.X", X);
						game.getConfig().set("Locations.SCP.Y", Y);
						game.getConfig().set("Locations.SCP.Z", Z);
						game.getConfig().set("Locations.SCP.World", world);
						GamePlayer.sendMessage(game.PLUGIN_PREFIX + "SCP spawn point set to " + X + " " + Y + " " + Z + " in world " + world);
						
					} else if(args[0].equalsIgnoreCase("MTF")){
						
						game.getConfig().set("Locations.MTF.X", X);
						game.getConfig().set("Locations.MTF.Y", Y);
						game.getConfig().set("Locations.MTF.Z", Z);
						game.getConfig().set("Locations.MTF.World", world);
						GamePlayer.sendMessage(game.PLUGIN_PREFIX + "MTF spawn point set to " + X + " " + Y + " " + Z + " in world " + world);
						
					} else if(args[0].equalsIgnoreCase("Lobby")){
						
						game.getConfig().set("Locations.Lobby.X", X);
						game.getConfig().set("Locations.Lobby.Y", Y);
						game.getConfig().set("Locations.Lobby.Z", Z);
						game.getConfig().set("Locations.Lobby.World", world);
						GamePlayer.sendMessage(game.PLUGIN_PREFIX + "Lobby spawn point set to " + X + " " + Y + " " + Z + " in world " + world);
						
					} else {
						sender.sendMessage(game.PLUGIN_PREFIX + ChatColor.DARK_RED +"Usage: /SCP set SCP|MTF|Lobby");
					}

					break;
		            }  
		     }
		return false;
	}

}
