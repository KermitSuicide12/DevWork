package ponytools.report;
import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ReportFile{
	
    private static ReportFile instance = new ReportFile();
    Report report;
    
    public static ReportFile getInstance() {
    	
        return instance;
    }

    File userfolder;
    private FileConfiguration users = null;
    private File usersfile = null;

     public FileConfiguration getData() {
         return this.users;
         
     }
  
     public void reloadData() {
         this.users = YamlConfiguration.loadConfiguration(usersfile);
     }

     public void setupFolders()
     {
       this.userfolder = new File(report.getDataFolder() + File.separator + "Users");
       if (!this.userfolder.exists())
       {
         System.out.println(report.getPluginPrefix() + "Users folder did not exist.... Creating");
         this.userfolder.mkdirs();
         System.out.println(report.getPluginPrefix() + "Users folder created!");
       }
     }
     
     public String getPrefix()
     {
       return this.getPrefix();
     }
     
     public void fileCheckPlayer(Player p)
     {
       this.usersfile = new File("plugins/" + Report.plugin.getName() + "/Users", p.getName() + ".yml");
       if (!this.usersfile.exists()) {
         try
         {
           this.usersfile.createNewFile();
         }
         catch (IOException ex)
         {
           System.out.println(report.getPluginPrefix() + "Could not create users.yml");
         }
       }
     }
     
     public FileConfiguration getUserFile(Player p)
     {
       this.usersfile = new File("plugins/StaffSecure/Users", p.getName() + ".yml");
       this.users = YamlConfiguration.loadConfiguration(this.usersfile);
       return this.users;
     }
     
     public void saveUserFile(Player p)
     {
       this.usersfile = new File("plugins/StaffSecure/Users", p.getName() + ".yml");
       
       saveFile(this.usersfile, this.users);
     }
     
     public static void saveFile(File file, FileConfiguration config)
     {
       try
       {
         config.save(file);
       }
       catch (IOException e) {}
     }
}