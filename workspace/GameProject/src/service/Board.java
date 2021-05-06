package service;

import java.util.*;

public class Board {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu, people;
		WordGame w;
		Scanner scan = new Scanner(System.in);
		System.out.println("인원을 선택하세요 : ");
		people = scan.nextInt();
		System.out.println("게임을 선택하세요.");
		System.out.println("1. 세 글자 쿵쿵따");
		System.out.println("2. 눈치게임");
		System.out.println("3. 날씨 기반 안주 추천 서비스");

		menu = scan.nextInt();
		switch(menu)
		{
		case 1:	
			w = new WordGame(people);
			w.start();
			break;
		case 2:	
			break;
		case 3:	
			break;
		}
	}

}
