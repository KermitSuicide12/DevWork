package ponytools.report;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class API{
	
  public static int slotmax = 0;
  public static boolean isreported = false;

  public static boolean getReport(Player p)
  {
    if (ReportFile.getInstance().getData().getString("Reports." + p.getUniqueId()) == null) {
      isreported = false;
    } else {
      isreported = true;
    }
    return isreported;
  }
  
  public static String getReporters(Player p)
  {
    List<String> reports = ReportFile.getInstance().getData().getStringList("Reports." + p.getName() + ".reporters");
    return reports.toString();
  }

  public static String format(String msg){
	  
    return ChatColor.translateAlternateColorCodes('&', msg);
  }

  private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

  public static String date() {
	  
      Date date = new Date();
      System.out.println(sdf.format(date));

      Calendar cal = Calendar.getInstance();
      System.out.println(sdf.format(cal.getTime()));

      LocalDateTime now = LocalDateTime.now();
      System.out.println(dtf.format(now));

      LocalDate localDate = LocalDate.now();
      
      return  DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
  }
}