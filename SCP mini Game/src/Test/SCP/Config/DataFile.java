package Test.SCP.Config;
import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class DataFile{
	
    Plugin p;
    FileConfiguration data;
    
    private File rfile;
    private String FileName;
	
    //private static DataFile instance = new DataFile(FileName);

    public DataFile(String FileName){
    	this.FileName = FileName;
    }

    //public static DataFile getInstance() {
    //    return instance;
    //}
    
    public void delete() {
    	rfile.delete();
    }
   
    public void setup(Plugin p) {
    	
        if (!p.getDataFolder().exists()) {
    	    p.getDataFolder().mkdir();
        }
        File path = new File(p.getDataFolder() + File.separator + "/data");
        rfile = new File(path, File.separator + FileName + ".yml");
        if (!rfile.exists()) {
            try {
                path.mkdirs();
                rfile.createNewFile();

            } catch (IOException e) {

              Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create " + FileName + ".yml");
            }
       }
       this.data = YamlConfiguration.loadConfiguration(rfile);
    }
   
     public FileConfiguration getData() {
         return this.data;
     }
   
     public void saveData() {
         try {
             this.data.save(rfile);
             } catch (IOException e) {
                 Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save " + FileName + ".yml");
             }
     }
  
     public void reloadData() {
         this.data = YamlConfiguration.loadConfiguration(rfile);
     }
     
     
     
     //public static void clearReportFile(){

   	 // for (String players : getInstance().getData().getStringList("Reports")) {
   	//	getInstance().getData().getStringList(players).clear();
   	 //   }

    // }
}