package service;

import java.util.*;

public class Board {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu, people;
		WordGame w;
		Scanner scan = new Scanner(System.in);
		System.out.println("인원수를 입력해주세요: ");
		people = scan.nextInt();
		System.out.println("게임을 선택해주세요");
		System.out.println("1. 3글자 쿵쿵따");
		System.out.println("2. 눈치게임");
		System.out.println("3. 백종원 게임");

		menu = scan.nextInt();
		switch(menu)
		{
		case 1:	
			w = new WordGame();
			//w.start();
			break;
		case 2:	
			break;
		case 3:	
			break;
		}
	}

}
