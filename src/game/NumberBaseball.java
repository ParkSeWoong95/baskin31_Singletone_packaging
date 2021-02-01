package game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


/*:: BaseballGame.java 클래스 :: 

- 숫자야구게임의 룰을 적용한 심판의 역할을 하는 클래스- 

(2) 사용자의 입력숫자 3개에 대해서 숫자와 위치를 체크하여 결과 반환
(숫자만 일치 : Ball / 숫자와 위치 둘다일치 : Strike)
(3) 스트라이크가 3개이면 우승으로 판정 
(4) 게임의 시도횟수가 10번 초과하면 실패(게임오버) 판정
*/

public class NumberBaseball{
   
   public void start(){

      System.out.println("***********************************");
      System.out.println("\t숫자 야구 게임을 시작합니다\t");
      System.out.println("***********************************");
      
      while(true){
    	  int i=1;
    	  ArrayList<Integer> input = input();
    	  ArrayList<Integer> answer = random();
    	  System.out.println(i + "번째 도전");
    	  if(chkStrike(answer, input) == 4){
    		  System.out.println("정답입니다^^");
    		  break;
    	  }
    	  System.out.println(chkBall(answer,input) + " Ball");
    	  System.out.println(chkStrike(answer, input) + "Strike");
    	  
    	 
      }
      
   }
   
   //임의의 중복되지 않은 3개의 숫자 생성 (0~9까지의 난수)
   public ArrayList<Integer> random(){
      HashSet<Integer> ans = new HashSet<>();
      while(ans.size() < 4){
         ans.add((int)(Math.random() * 10));
      }
      ArrayList<Integer> answer = new ArrayList<>(ans);
      return answer;
   }
   
   // user로부터 3개의 입력을 받는 메소드
   
   public ArrayList<Integer> input(){
      ArrayList<Integer> input = new ArrayList<>();
      Scanner sc = new Scanner(System.in);
      System.out.println();
      System.out.println("정답을 입력해 주세요.");
      String in = sc.next();
      for(int i=0; i < in.length(); i++){
    	  if('0' <= in.charAt(i) && in.charAt(i) <= '9'){
    		  input.add(in.charAt(i)-'0');    		  
    	  }else{
    		 System.out.println("잘못 입력하셨습니다. 0~9 사이의 숫자 4자리를 입력해주세요.");
    	  }
      }
      return input;
   }
   
   int chkBall(ArrayList<Integer> answer, ArrayList<Integer> input){
      int ball = 0;
      for(int i=0; i<answer.size(); i++){
         if(answer.contains(input.get(i))){
         ball ++;   
         }
      }
      return ball;
   }
   
   int chkStrike(ArrayList<Integer> answer, ArrayList<Integer> input){
      int strike = 0; 
	  for(int i=0; i<answer.size(); i++){
    	 if(answer.get(i) == input.get(i)){
    		  strike++;
    	 }
      }
      
      return strike;
   }

}