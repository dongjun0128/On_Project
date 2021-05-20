package service;

import java.util.*;

public class Board {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu, people;
		WordGame w;
		Scanner scan = new Scanner(System.in);
		System.out.println("�ο��� �����ϼ��� : ");
		people = scan.nextInt();
		System.out.println("������ �����ϼ���.");
		System.out.println("1. �� ���� ������");
		System.out.println("2. ��ġ����");
		System.out.println("3. ���� ��� ���� ��õ ����");

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
