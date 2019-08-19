package ponytools.report;

public class Report extends org.bukkit.plugin.java.JavaPlugin{
	
public static Report plugin;
	
	
   ReportFile rf = ReportFile.getInstance();
   
   public void onEnable() {
	   
	   plugin = this;

       registerConfig();
       
       String _logMessage = "** " + plugin.getName() + " v." + plugin.getDescription().getVersion() + " enabled.";
		
		getLogger().info("********************");
		getLogger().info("**");
		getLogger().info(_logMessage);  
		getLogger().info("**");
		getLogger().info("*******************");
		
		ReportFile.getInstance().setupFolders();
	     
	     getCommand("punish").setExecutor(new ReportPlayer(this));
	     getCommand("punishments").setExecutor(new ReportPlayer(this));

	     //getCommand("reports").setExecutor(new ReportPlayer(this));
	     
		ReportFile.getInstance().reloadData();
		
  }
   
   public String getPluginPrefix(){
	   
	   return getConfig().getString("Messages.prefix");
   }
  
  private void registerConfig() {
    getConfig().options().copyDefaults(true);
    reloadConfig();
    saveConfig();
  }
  
  public void onDisable() {
	  	  
	  String _logMessage = "** " + plugin.getName() + " v." + plugin.getDescription().getVersion() + " Disabled.";

	  getLogger().info("********************");
	  getLogger().info("**");
	  getLogger().info(_logMessage);  
	  getLogger().info("**");
	  getLogger().info("*******************");
    }
}