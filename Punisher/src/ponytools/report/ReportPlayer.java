package ponytools.report;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReportPlayer
  implements CommandExecutor
{
	public boolean banned;
	public static String playerName = "";
	
  Report plugin;
  ReportPlayer rp;

public ReportPlayer(Report report) {
	this.plugin = report;
}

public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    if (cmd.getName().equalsIgnoreCase("punish")) {

    	final Player reporter = (Player) sender;
        if (args.length == 0) {
        	reporter.sendMessage(API.format(plugin.getPluginPrefix() + this.plugin.getConfig().getString("Messages.report_usage")));
        }
        if (args.length >= 2)
        {
          Player reported = Bukkit.getServer().getPlayer(args[1]);
          if (reported == null) {
        	  reporter.sendMessage(API.format(plugin.getPluginPrefix() + this.plugin.getConfig().getString("Messages.player_null").replace("%target%", args[0])));
        	  
        	  if(args[0].equalsIgnoreCase("kick")){

        		  StringBuilder x = new StringBuilder();
                  for (int i = 2; i < args.length; i++) {
                    x.append(args[i] + " ");
                  }

                  String date = API.date();

                  List<String> datelist = ReportFile.getInstance().getUserFile(reported).getStringList("Kick.Dates");
                  datelist.add(date);
                  
                  List<String> reportslist = ReportFile.getInstance().getUserFile(reported).getStringList("Kick.Reasons");
                  reportslist.add(x.toString());
                  
                  List<String> reporterslist = ReportFile.getInstance().getUserFile(reported).getStringList("Kick.Reporters");
                  reporterslist.add(reporter.getName());
                               
                  ReportFile.getInstance().getUserFile(reported).set("Kick.Reasons", reportslist);
                  ReportFile.getInstance().getUserFile(reported).set("Kick.Reporters", reporterslist);
                  ReportFile.getInstance().getUserFile(reported).set("Kick.Dates", datelist);
                  ReportFile.getInstance().saveUserFile(reported);

                  //p.sendMessage(API.format(plugin.getPluginPrefix() + this.plugin.getConfig().getString("Messages.reported_player").replace("%target%", t.getName()).replace("%reason%", x.toString())));
                  for (Player online : Bukkit.getServer().getOnlinePlayers()) {
                    if ((online.hasPermission("reportgui.reportsee")) || (online.isOp())){
                    	
                      online.sendMessage(API.format("&8&m--------I--------"));
                      online.sendMessage(API.format("                       "));
                      online.sendMessage(API.format("   &6&lNEW &cReport!      "));
                      online.sendMessage(API.format("                       "));
                      online.sendMessage(API.format("   &6Player &c" + reporter.getName()));
                      online.sendMessage(API.format("                       "));
                      online.sendMessage(API.format("   &6Reported &c" + reported.getName()));
                      online.sendMessage(API.format("                       "));
                      online.sendMessage(API.format("   &6Reason &c" + x.toString()));
                      online.sendMessage(API.format("                       "));
                      online.sendMessage(API.format("&8&m--------I--------"));
                  }
                }
                  
             } else {
            	 
       		  sender.sendMessage(ReportFile.getInstance().getPrefix() + "You can curretly only kick players");
       	     }
         }

    } else if(cmd.getName().equalsIgnoreCase("punishments")){
    	
    	ArrayList<String> reportsList = new ArrayList<String>();
    	
        Player requested = Bukkit.getServer().getPlayer(args[0]);
        
        for(String report : ReportFile.getInstance().getUserFile(requested).getStringList("Kick.Reports")){
        	reportsList.add(report);
        }
        
        sender.sendMessage(ReportFile.getInstance().getPrefix() + requested + " has " + reportsList.size() + " kicks");
        
        reportsList.clear();
    }
  }
	return banned;
  }
}