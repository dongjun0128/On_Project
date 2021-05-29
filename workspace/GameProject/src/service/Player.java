package service;

import java.util.*;

public class Player{
    Scanner inputword = new Scanner(System.in);
    
    public String name; // 게임 참가자 이름 필드
    public String wordin;
    public Date date_now;
    
    public String sayWord() { // 사용자로부터 단어를 입력받는 메소드
        wordin = inputword.next(); 
        date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다 
        return wordin;
    }
    
    public boolean succeed_WordGame(char lastChar, String word, ArrayList<String> overlap_word) { 
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
		long diff = pre_time.getTime() - now_time.getTime();
		long sec = diff / 1000;
		
		if(pre_time.getTime() == now_time.getTime()) { //첫번째 입력하는 경우는 통과시키는 코드
			sec=5;
		}
		
		if(CurrectWord.equals(UserWord) == true) { // 같은 단어이면
			if(sec<=1) {//1초 이내 입력하면
				System.out.println("너무빨리 답했습니다!");
				return false;
			}
			
			return true;
		}
		
		else { // 다른단어이면
			System.out.println("다른 단어를 입력했습니다!");
			return false;
		}
	}

}
