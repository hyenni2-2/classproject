package first;

import java.util.Scanner;

public class LoopAdd {

	public static void main(String[] args) {
		//문제 1. int형 변수 x가 10보다 크고 20보다 작을 때 true인 조건식
        int x = 1;	
		boolean chk1 = (x>10 && x<20);
	    System.out.println(chk1);
		
		
		
		
		//2. char형 변수 ch가 공백이나 탭이 아닐때 true
		char ch;
		ch = ' ';
		boolean chk2 = (ch !=' ' && ch!='\t');
		System.out.println(chk2);
	    
		
		//3. char형 변수 ch가 'x' 또는 'X'일 때 true
		
		ch = 'x';
		boolean chk3 = ch=='x' || ch == 'X';
		System.out.println(chk3);
		
		
		
		//4. char형 변수 ch가 숫자('0'~'9')일 때 true
		ch = '1';
		boolean chk4 = ch>='0' && ch<='9';
		System.out.println(chk4);
		
		
		
		
		//5. char형 변수 ch가 영문자(대문자 or 소문자)일 때 true
		ch = 'D';
		boolean chk5 = (ch>='a' && ch<='z') || (ch>='A' && ch<='Z');
		System.out.println(chk5);
		
		
		
		
		
		//6. int형 변수 year가 400으로 나눠떨어지거나 or 4로 나눠떨어지고 100으로 나눠떨어지지 않을 때 true
		int year;
		year = 2016;
		boolean chk6 = year%400==0 || (year%4==0 && year%100!=0);
		System.out.println(chk6);
		
		
		
		
		
		//7. boolean powerOn이 false일 때 true
		boolean powerOn = false;
		boolean chk7 = !powerOn;
		System.out.println(chk7);
		
		
		
		
		
		
		//8. 문자열 참조변수 str이 "yes"일 때 true
		String str = "yes";
		boolean chk8 = str == "yes";          //참조값 비교
		boolean chk88 = str.equals("yes");    //저장하는 문자열끼리 비교
		System.out.println(chk8);
		System.out.println(chk88);
		
		
		System.out.println("===========================");
		
		//1~20까지의 정수 중에서 2 or 3의 배수가 아닌 수의 총합
		int i;
		int sum=0;
		for(i=1; i<21; i++) {
			if(i%2!=0 && i%3!=0) {
				sum = sum + i;
			}
			
		}
		System.out.println(sum);   //최종 합은 가장 바깥에
		
		
		
		System.out.println("===========================");

		
		//1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)의 결과를 계산
		sum = 0;
		int beforeSum = 0;
		for(i=1; i<11; i++) {
			beforeSum = beforeSum + i;
			sum = sum + (sum+beforeSum);
		}
		System.out.println(sum);
		
		
		
		System.out.println("===========================");

		
		
		//1+(-2)+3+(-4)+... 
		// 과 같은 식으로 계속 더해나갔을 때, 
		// 몇까지 더해야 총합이 100이상이되는지 
		
		int n = 1;
		sum = 0;
		while(true) {
			int num = n%2==0? -n:n;
			// System.out.println(num);
			sum = sum + num;
			if(sum>=100) {
				System.out.println(n + "을 더했을 때 100 이상인 " + sum + "이 됩니다.");		
				break;
			}
			n++;
		}
	
			
			
			
		
		System.out.println("===========================");

		
		/*
		// for -> while문 변경
	    for(i=0; i<=10; i++){
		    for(int j=0; j<i; j++){
		System.out.println("*");
		System.out.println();
		    }
	    }
		
		System.out.println("===========================");
        /*
	    while(i<11) {
			if(j<i) {
	    		System.out.println("*");
	    	}
	    	System.out.println();
	    }
		*/
	    
	    
	    
	    // 두 개의 주사위를 던졌을 때, 
	    // 눈의 합이 6이 되는 : dice1 + dice2 = 6 -> dice2 = 6-dice1 
		// 모든 경우의 수를 출력하는 프로그램
	    // 주사위 눈의 범위 -> 1~6 -> 반복 범위
		System.out.println("===========================");
	    for(i=1; i<6; i++) {
	        System.out.print("첫 번째 주사위가 " + i +" 일 때,");
	        System.out.println("두 번째 주사위는 " + (6-i));
	        
	    }
	    
	   //math.random 이용해서 1-6 사이의 임의의 정수를 변수 value에 저장
	    int value = (int)(Math.random()*6)+1;
	    
	    System.out.println("value: " + value);
	    
	  
	  //방정식 2x+4y=10의 모든 해 구하기
	  //각각의 범위는 0<=x<=10, 0<=y<=10
	  for(x=0; x<11; x++) {
		  for(int y=0; y<11; y++) {
			  if(x+2*y==5) {
				 System.out.println("x="+x+" y="+y); 
			  }
		  }
	  }
	    
	    
	  //   만일 문자열이"12345"라면, 
	  // ‘1+2+3+4+5’의 결과인 15를 출력이 출력
	  // [Hint] String클래스의 charAt(inti)을 사용
	  
System.out.println("문제9===========================");

	  str = "12345";
	  int cNum = Integer.parseInt(str);   //문자형을 숫자형으로 반환
	  sum = 0;
	  for(i=0; i < str.length(); i++) {
		  //System.out.println(str.charAt(i));
          sum += str.charAt(i)-'0';   //char형이라 int형으로 변환하기 위해서 '0'(48)을 빼줌 = 49-48,50-49,...
	  }
	  System.out.println("sum="+sum);

	  // 나머지 10으로 해서 구할수도 있음.
	 
	  System.out.println("문제10===========================");

	  
	  // int타입의 변수 num 이 있을 때, 
	  // 각 자리의 합을 더한 결과를 출력하는 코드를 완성
	  // 만일 변수 num의 값이 12345라면, 
	  // ‘1+2+3+4+5’의 결과인 15를 출력
	  // [주의] 문자열로 변환하지 말고 숫자로만 처리해야 한다.
	  
	  // 자리수 구하기
	  //12345%10=5         num%10 -> 1의 자리수
	  //12345/10=1234      num/10 -> 10의 자리수가 1의 자리수가 된다
	  //1234%10=4         
	  //1234/10=123 /...
	  //반복의 조건은 num>0 
	  
	  
	  int num=12345;
	  sum=0;
	  while(num>0) {
		  System.out.println(num);
		  sum = sum + (num%10);
		  num = num/10;
	  }
	  System.out.println("sum="+sum);
	  
	  
	  System.out.println("문제11===========================");

	  
	  // 피보나치 수열
	  int num1=1;    //num1=num2;
	  int num2=1;    //num2=num3;
	  int num3=0;    //num3=num1+num2;
	  System.out.print(num1+","+num2);
	  for(i=0; i<8; i++) {
		  num3 = num1 + num2;
		  System.out.print(","+num3);
		  
		  num1=num2;
		  num2=num3;
	  }
	  
	  
	  System.out.println("\n문제13===========================");

	  
	  // 주어진 문자열(value)이 숫자인지를 판별하는 프로그램
	  str = "12o34";
	  ch = ' ';
	  boolean isNumber = true;
	  // 반복문과 charAt(int i)를 이용해서 문자열의 문자를
      // 하나씩 읽어서 검사한다.
	  for(i=0; i<str.length(); i++) {
		  ch=str.charAt(i);
		  if(!(ch>='0' && ch<='9')) {
			  isNumber=false;
			  break;
		  }
	  }
	  if (isNumber) {
 System.out.println(str+"는 숫자입니다.");
		  } else {
		  System.out.println(str+"는 숫자가 아닙니다.");
		  }
	  
	  /*
	  System.out.println("\n문제14===========================");

	  
	  // 다음은 숫자 맞추기 게임을 작성한 것이다. 
	  // 1과 100사이의 값을 반복적으로 입력해서
	  // 컴퓨터가 생각한 값을 맞추면 게임이 끝난다.
	  // 사용자가 값을 입력하면, -> 사용자가 입력함 
	  // 컴퓨터는 자신이 생각한값과 비교해서 결과를 알려준다. => 비교 연산 
	  // 사용자가 컴퓨터가 생각한 숫자를 맞추면 게임이 끝나고  => break
	  // 몇 번만에 숫자를 맞췄는지 알려준다. => count
	  
	  Scanner s = new Scanner(System.in);
	  
	  int answer = (int)(Math.random()*100)+1;
	  int input = 0; // 사용자입력을 저장할 공간
	  int count = 0; // 시도횟수를 세기위한 변수
	  
	  // 화면으로 부터 사용자입력을 받기 위해서 Scanner클래스 사용
	  
	  do  {
	      count++;
	      System.out.print("1과 100사이의 값을 입력하세요 :");
     	  input = s.nextInt(); // 입력받은 값을 변수 input에 저장한다.

     	  // 사용자가 입력한 값을 answer와 비교해서 결과 출력
     	  // 큰수다 or 작은 수다 or 맞췄다
     	  
     	  if(answer>input) {
     		  System.out.println("더 큰 수입니다.");
     	  } else if(answer<input) {
     		  System.out.println("더 작은 수입니다.");
     	  } else {
     		  System.out.println(count + "회 만에 맞추셨습니다. 게임을 종료합니다.");
     		  break;
     	  }
	  } while(true); // 무한반복문
	  */
	  
	  System.out.println("\n문제15===========================");

	  
	  
	   //다음은 회문수를 구하는 프로그램이다. 
	   // 회문수(palindrome)란, 숫자를 거꾸로 읽어도앞으로 읽는 것과 같은 수 
	  // 예를 들면 ‘12321’이나 ‘13531’같은 수를 말한다.
	  //[Hint] 나머지 연산자를 이용하시오.
	  
	  int number=9137319;
	  int tmp=number;
	  int result=0; // 변수 number를 거꾸로 변환해서 담을 변수
	  while(tmp!=0) {
	      result = result*10 + (tmp%10);
	      // 0   = 0 + 1
	      // 1   = 1*10 + 2
	      // 2   = (12)*10+3
	      //       123*10+2 
	      //       1232*10 + 1
	      tmp = tmp/10; // 12321 -> 1232 -> 123 -> 12 -> 1 -> 0
	  }
	  if(number==result) {
		  System.out.println(number + "는 회문수입니다.");
	  } else {
		  System.out.println(number + "는 회문수가 아닙니다.");
	  }
	  
	  
	  
	  
	  
	  

	}

}
