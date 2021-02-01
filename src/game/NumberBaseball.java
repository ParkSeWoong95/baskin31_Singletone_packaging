package game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import com.itextpdf.text.log.SysoCounter;


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
      ArrayList<Integer> answer = random();
      System.out.print(answer.get(0));
      System.out.print(answer.get(1));
      System.out.print(answer.get(2));
      System.out.println(answer.get(3));
     
      chk(answer);
      
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
   
   // user로부터 4개의 입력을 받는 메소드
   
   public String input(){
      System.out.println("------------------------------------");
      System.out.println("정답을 입력해 주세요.");
      Scanner sc = new Scanner(System.in);
      while(true){
    	  String input = sc.next();
    	  if(input.length() != 4){
    		 System.out.println("0~9 사이의 숫자 4자리를 입력해 주세요.1");
    	  }else{
    		  for(int i=0; i<input.length(); i++){
    			  if(!('0' <= input.charAt(i) && input.charAt(i) <= '9')){
    				  System.out.println("0~9 사이의 숫자 4자리를 입력해 주세요."); 
    				  break;
    			  }
  			  sc.next();

    		  }
    		  return input;
    	  }
      }
//      if(input.charAt(i) )
//      int in = Integer.parseInt(input);
   }
   
   void chk(ArrayList<Integer> answer){
      int ball = 0;
      int strike = 0; 
      int cnt = 1;
      
      
      while(true){
    	  ArrayList<Integer> userInput = new ArrayList<>();
    	  String input = input();

    	  System.out.println("===================================");
    	  System.out.println(cnt + "번째 시도" + "\t");
    	  System.out.println("===================================");

    	  System.out.println("내가 입력한 정답 : " + input);
    	  for(int i=0; i<input.length(); i++){
        	  userInput.add(input.charAt(i)-'0');
          }
	      for(int i=0; i<answer.size(); i++){
	         if(answer.contains(userInput.get(i))){
	        	 if(answer.get(i) == userInput.get(i)){
	    		  strike++;
	    		  continue;
	        	 }
	         ball ++;   
	         }
	      }
	      if(strike == 4){
	    	  System.out.println();
	    	  System.out.println("♬  정답입니다 :) ♬");
	    	  System.out.println();
	    	  return;
	      }
	      System.out.println(ball + " Ball");
	      System.out.println(strike + " Strike");
	      ball = 0;
	      strike = 0;
	      cnt++;
	   }
   }


}