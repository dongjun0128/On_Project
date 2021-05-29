package service;

import java.util.*;


public class Timing_Game 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String word;
		String CurrectWord[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "q", "w", "e", "r",
							    "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l","z", "x", "c", "v",
							    "b", "n", "m", ",", ".", "/", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "{", "}", "|",
							    "A", "S", "D", "F", "G", "H", "J", "K", "L", ":", "Z", "X", "C", "V", "B",
							    "N", "M", "<", ">", "?", "-", "_", "+", "=", "*"};
						
		System.out.println("게임에 참가하는 인원은 몇 명입니까? >> ");
		int number = scanner.nextInt();
		
		Player[] play = new Player[number];
		
		for(int i=0;i<number;i++)
		{
			System.out.println("참가자의 이름을 입력하세요. >> ");
			play[i] = new Player();
			play[i].name = scanner.next();
		}
		
		Random rand = new Random();
		word = CurrectWord[rand.nextInt(77)];
		System.out.println("시작하는 단어는 "+word+"입니다.");
		
		for(int i=0;i<number;i++)
		{
			System.out.println(play[i].name + " >> ");
			
			play[i].sayWord();
			
			boolean continuing;
			
			if(i==0) {
				continuing = play[i].succeed_TimingGame(word, play[i].wordin,play[i].date_now,play[i].date_now);
			}
			
			else {
				continuing = play[i].succeed_TimingGame(word, play[i].wordin,play[i].date_now,play[i-1].date_now);	
			}
			
			if(continuing == true)
			{

			}
			
			else if(continuing == false)
			{
				System.out.println(play[i].name + "이 졌습니다.");
				
				break;
			}
			
			
			if(i == number-1) {
				System.out.println(play[i].name + "이 졌습니다.");
			}
			
		}
	}	
}
