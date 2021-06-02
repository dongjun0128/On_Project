package service;

import java.util.*;

public class Player{
    Scanner inputword = new Scanner(System.in);
    
    public String name; // 게임 참가자 이름 필드
    public String wordin;
    public Date date_now;
    public Date date_input;
    public double sub_time;
    
    public Player(String name)
    {
       this.name = name;
    }
    
    public String sayWord() { // 사용자로부터 단어를 입력받는 메소드
        wordin = inputword.next(); 
        return wordin;
     }
     
     public String insert_word() { // 사용자로부터 단어를 입력받는 메소드
        date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다 
         System.out.println("1초가 되었다고 생각할 때 키를 눌러주세요!");
        wordin = inputword.next(); 
        date_input = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다
         return wordin;
     }
    
    public boolean succeed_WordGame(char lastChar, String word, ArrayList<String> overlap_word) { 
    	WordCheck w = new WordCheck();
        if (lastChar == wordin.charAt(0)) { //마지막 단어의 끝 문자와 사용자 입력 단어의 첫 어절이 같으면 다음 체크
           if(overlap_word.contains(wordin)) {
             System.out.println("중복된 단어를 입력했습니다!");
              return false;
                // 중복된 단어가 나오면 false
           }
           if(wordin.length()!=3) {
              System.out.println("3단어가 아닙니다!");
              return false;
              // 3단어가 아니면 false
           }
           //실제로 등록된 단어인지
           if(!w.check(word))
        	   return false;
           
           return true;
           // 중복된 단어가 하나도 나오지 않으면 True
        }
        
        else { 
           System.out.println("단어가 이어지지 않습니다!");
           return false;
        //마지막 단어의 끝 문자와 사용자 입력 단어의 첫 어절이 다르면 false
        }
    }
    
    public boolean succeed_TimingGame(String CurrectWord, String UserWord, Date pre_time, Date now_time) 
    {
       long diff = -pre_time.getTime() + now_time.getTime();
       long sec = diff / 10;
       
       sub_time=Math.abs(100-sec);
       System.out.println(name+"님의 입력 시간과 1초의 차이난 시간은"+(sub_time/100)+"초 입니다");
       if(CurrectWord.equals(UserWord) == true) { // 같은 단어이면
          return true;
       }
       
       else { // 다른단어이면
          System.out.println("다른 단어를 입력했습니다!");
          return false;
       }
    }

}