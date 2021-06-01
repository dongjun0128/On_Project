package service;

import java.io.File;
import java.util.*;


public class Timing_Game 
{
   public void start(ArrayList<Player> play, FileWrite f) {
      Scanner scanner = new Scanner(System.in);
      String word;
      String CurrectWord[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "q", "w", "e", "r",
                         "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l","z", "x", "c", "v",
                         "b", "n", "m", ",", ".", "/", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "{", "}", "|",
                         "A", "S", "D", "F", "G", "H", "J", "K", "L", ":", "Z", "X", "C", "V", "B",
                         "N", "M", "<", ">", "?", "-", "_", "+", "=", "*"};
      /*           
      System.out.println("게임에 참가하는 인원은 몇 명입니까? >> ");
      int number = scanner.nextInt();
      
      Player[] play = new Player[number];
      
      for(int i=0;i<number;i++)
      {
         System.out.println("참가자의 이름을 입력하세요. >> ");
         play[i] = new Player();
         play[i].name = scanner.next();
      }
      */
      int number = play.size();
      
      Random rand = new Random();
      word = CurrectWord[rand.nextInt(77)];
      System.out.println("시작하는 단어는 "+word+"입니다.");
      
      for(int i=0;i<number;i++)
      {
         System.out.println(play.get(i).name + " >> ");
         
         play.get(i).insert_word();
         boolean continuing;
         
         continuing = play.get(i).succeed_TimingGame(word, play.get(i).wordin,play.get(i).date_now,play.get(i).date_input);   
         
         //주어진 단어 입력하지 않으면 짐.
         if(continuing == false)
         {
            System.out.println(play.get(i).name + "이 졌습니다.");    
            break;
         }
         
         //
         if(i == number-1) {
             double max=0;
             int player = 0;
             for(i=0;i<number;i++) {
                if(max<play.get(i).sub_time) {
                   max=play.get(i).sub_time;
                   player=i;
                }
             }
             f.write(play.get(player).name+"님이 "+(max/100)+"초로 졌습니다.\n");
         
             System.out.println(play.get(player).name+"님이 졌습니다.");
             System.out.println("차이난 시간 "+(max/100)+"초");
         }
         
      }
   }   
}