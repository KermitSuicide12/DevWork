package Test.SCP;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Test.SCP.Config.DataFile;
import Test.SCP.kits.KitListener;
import Test.SCP.listeners.Signs;

public class Game extends JavaPlugin{

	public DataFile wins = new DataFile("Wins");
	public FileConfiguration config = getConfig();

	public static Game plugin;

	public String PLUGIN_PREFIX = "&8[&7Mini SCP&8]";
	public String PLUGIN_COMMAND_NO_PERMISSION = "You do not have the correct permission to run this command";
	public String PLUGIN_ACTION_NO_PERMISSION = "You do not have the correct permission to do that";
	public int GAME_RESTART_TIMER = 20;
	
	public int LOCATIONS_LOBBY_X = 1;
	public int LOCATIONS_LOBBY_Y = 1;
	public int LOCATIONS_LOBBY_Z = 1;
	public String LOCATIONS_LOBBY_WORLD = "world";
	
	public int LOCATIONS_SCP_X = 1;
	public int LOCATIONS_SCP_Y = 1;
	public int LOCATIONS_SCP_Z = 1;
	public String LOCATIONS_SCP_WORLD = "world";

	public int LOCATIONS_MTF_X = 1;
	public int LOCATIONS_MTF_Y = 1;
	public int LOCATIONS_MTF_Z = 1;
	public String LOCATIONS_MTF_WORLD = "world";

	public void onEnable() {
		
		this.getCommand("scp").setExecutor(new Commands(this));
		
		PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new KitListener(), this);
        pm.registerEvents(new Signs(), this);
        
		plugin = this;
		
        // Save a copy of the default config.yml if one is not there
        this.saveDefaultConfig();
        this.loadConfig();

	    this.config = getConfig();
	    this.config.options().copyDefaults(true);
	    saveConfig();	    
	  }
	  
	  public void onDisable() {
		  
		  saveConfig();
	  }

	  private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	  private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	  
	  public String date() {
		  
	      Date date = new Date();
	      System.out.println(sdf.format(date));

	      Calendar cal = Calendar.getInstance();
	      System.out.println(sdf.format(cal.getTime()));

	      LocalDateTime now = LocalDateTime.now();
	      System.out.println(dtf.format(now));

	      LocalDate localDate = LocalDate.now();
	      
	      return  DateTimeFormatter.ofPattern("HH:mm:ss").format(localDate);
	  }

		public void loadConfig(){
			//v1.0
			this.PLUGIN_PREFIX = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Plugin.Prefix")) + " " + ChatColor.RESET;
			this.PLUGIN_ACTION_NO_PERMISSION = this.getConfig().getString("Plugin.Action no permission");
			this.PLUGIN_COMMAND_NO_PERMISSION = this.getConfig().getString("plugin.Command no permission");
			this.GAME_RESTART_TIMER = this.getConfig().getInt("Game.Restart");
			
			this.LOCATIONS_LOBBY_X = this.getConfig().getInt("Locations.Lobby.X");
			this.LOCATIONS_LOBBY_X = this.getConfig().getInt("Locations.Lobby.Y");
			this.LOCATIONS_LOBBY_X = this.getConfig().getInt("Locations.Lobby.Z");
			this.LOCATIONS_LOBBY_WORLD = this.getConfig().getString("Locations.Lobby.World");
			
			this.LOCATIONS_SCP_X = this.getConfig().getInt("Locations.SCP.X");
			this.LOCATIONS_SCP_Y = this.getConfig().getInt("Locations.SCP.Y");
			this.LOCATIONS_SCP_Z = this.getConfig().getInt("Locations.SCP.Z");
			this.LOCATIONS_SCP_WORLD = this.getConfig().getString("Locations.SCP.World");
			
			this.LOCATIONS_MTF_X = this.getConfig().getInt("Locations.MTF.X");
			this.LOCATIONS_MTF_Y = this.getConfig().getInt("Locations.MTF.Y");
			this.LOCATIONS_MTF_Z = this.getConfig().getInt("Locations.MTF.Z");
			this.LOCATIONS_MTF_WORLD = this.getConfig().getString("Locations.MTF.World");
		}	
}