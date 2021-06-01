package service;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu;

		Scanner scan = new Scanner(System.in);
		FileWrite f = new FileWrite();

		// System.out.println(new Date(System.currentTimeMillis()));
		while(true)
		{
			System.out.println("메뉴를 선택하세요");
			System.out.println("1. 음식 추천");
			System.out.println("2. 미니 게임");
			System.out.println("3. 종료(-1)");
			menu = scan.nextInt();
			if(menu == 1)
				weather(f);
			else if(menu == 2)
				game(f);
			else if(menu == -1)
				break;
		}

		System.out.println("프로그램이 종료되었습니다.");

	}
	public static void weather(FileWrite f) {
		Weather_API we = new Weather_API();
		we.start(f);
	}
	public static void game(FileWrite f) {
		WordGame w;
		Timing_Game t;
		NaverCrawlerMain n;
		int people, menu;
		String name;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("인원수를 입력해주세요: ");
		people = scan.nextInt();

		ArrayList<Player> player = new ArrayList<Player>();
		f.write("참가자 : ");
		for (int i = 0; i < people; i++) {
			// System.out.print((i+1)+"번째 사용자명 입력 : ");
			name = scan.next();
			f.write(name+" ");
			player.add(new Player(name));
		}
		f.write("\n");
		while (true) {
			System.out.println("게임을 선택해주세요");
			System.out.println("1. 3글자 쿵쿵따");
			System.out.println("2. 1초 간격 맞추기");
			System.out.println("3. 백종원 게임");
			System.out.println("4. 종료 -1");
			System.out.println("----> ");
			menu = scan.nextInt();
			if(menu == -1)
				break;
			switch (menu) {
			case 1:
				w = new WordGame();
				f.write("쿵쿵따 게임 : ");
				w.start(player, f);
				break;
			case 2:
				f.write("1초 간격 맞추기 게임 : ");
				t = new Timing_Game();
				t.start(player, f);
				break;
			case 3:
				f.write("백종원 게임 : ");
				n = new NaverCrawlerMain();
				n.start(player, f);
				break;
			}
		}
	}
}