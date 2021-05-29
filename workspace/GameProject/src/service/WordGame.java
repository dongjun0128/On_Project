package service;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



/*
class convert{
	public String convert(String word) {
		
	}
}*/

public class WordGame {
   public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String word; //프로그램에서 첫 단어 설정해주기
    String First_word[] = {"아버지","어머니","신발장","노트북","마우스","자전거"};
    
    System.out.println("게임에 참가하는 인원은 몇명입니까? >> ");
    int number = scanner.nextInt();
    
    Player[] play = new Player[number];
    
    for(int i=0; i<number; i++) {
        System.out.println("참가자의 이름을 입력하세요 >> ");
        play[i] = new Player(); // 이 코드 없으면 Nullpointexception
        play[i].name = scanner.next();
        //입력받은 이름을 Player 배열의 이름 필드에 각각 저장하는 코드
    }
    
    int i = 0, j = 0;
    Random rd = new Random();
    word=First_word[rd.nextInt(5)];
    System.out.println("시작하는 단어는 "+word+"입니다.");
    
    ArrayList<String> overlap_word = new ArrayList<String>();
    overlap_word.add(word);
    
    while(true) {
        j = i % number; //끝말잇기가 한 텀에 끝나지 않을 수도 있음
        int lastIndex = word.length()-1; //마지막 문자에 대한 인덱스
        char lastChar = word.charAt(lastIndex); //마지막 문자
        
        System.out.println(play[j].name + " >> ");
        play[j].sayWord(); // 사용자의 단어 입력 받기
        boolean continuing = play[j].succeed_WordGame(lastChar,play[j].wordin,overlap_word);
        //1. 끝문자랑 동일하고
        //2. 중복되지않는 단어
        //3. 3글자인지 체크
        
        if(continuing == false) {
            System.out.println(play[j].name + "이 졌습니다.");
            break;
        }
        
        overlap_word.add(play[j].wordin);
        //올바른 단어이면 단어 중복 체크 집합에 추가
        
        word = play[j].wordin;
        i++;
    }
}

}