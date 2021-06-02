package service;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner; 
public class BaekGame {
   void start(ArrayList<Player> player, FileWrite f) {
      String id = "eF0P8j81Qsygsbq8ZRI9";
      String secret = "fCkEzHwjp1"; 
      ArrayList<String> title = new ArrayList<String>();
      Scanner scr = new Scanner(System.in);
      try {
         for(int i=0;i<player.size();i++)
         {
            NaverCrawler crawler = new NaverCrawler(); 
            System.out.print(player.get(i).name + " >> ");
            String search = scr.next();
            search = "백종원 "+search + " 레시피";
            String[] test = search.split(" ");
            String url = URLEncoder.encode(search, "UTF-8");
            String response = crawler.search(id, secret, url);
            String[] fields = {"title", "link", "description"};
            Map<String, Object> result = crawler.getResult(response, fields); 
            //if(result.size() > 0) System.out.println("total -> " + result.get("total"));
            
            if(Integer.parseInt(result.get("total").toString())>8000)
            {
               f.write(player.get(i).name + "가(이) 벌칙에 당첨되었습니다.\n");
               System.out.println(player.get(i).name + "가(이) 벌칙에 당첨되었습니다");
            }
            else 
               System.out.println(player.get(i).name + " 통과!");
               /*
            List<Map<String, Object>> items = (List<Map<String, Object>>) result.get("result");
            for(Map<String, Object> item : items) {
               System.out.println("===================================================="); 
               System.out.println(fields[0]+"->"+item.get(fields[0]));
               title.add(replaceString(item.get(fields[0]).toString()));
               //if(gameCheck(item.get(fields[0]),test))
               //   System.out.println("통과");
               
               for(String field : fields)
                  System.out.println(field + "->" + item.get(field));
                
            }
            
            for( String s : title)
            {
               System.out.println(s);
            }
            */
         }


      } catch (Exception e) {
         e.printStackTrace(); 
      }
   } 
   public static boolean gameCheck(Object o, String[] s)
   {
      if(o.toString().contains(s[0])&&o.toString().contains(s[1]))
         return true;
      return false;
   }
   public static String replaceString(String o)
   {
      String match1 = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
      String match2 = "[a-zA-Z\\s]";
      o = o.replaceAll(match1, "");
      o = o.replaceAll(match2, "");
      return o;
   }
}