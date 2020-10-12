package first;

import java.util.Scanner;

public class FlowStudy {

	public static void main(String[] args) {
		// boolean형 변수 powerOn가 false일 때 true인 조건식
		boolean powerOn = false;
		boolean chk = !powerOn; // 부정을 해야 값이 true가 됨
		
		System.out.println(chk);
		
		// 문자열 참조변수 str이 “yes”일 때 true인 조건식
		String str = "yes";
		boolean chk2 = str == "yes";
		System.out.println(chk2);
		

		//1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하시오
		int i;
		int sum=0;
		for(i=1; i<21; i++) {
			if(i%2!=0 && i%3!=0) {
				sum=sum+i;
			}
		}
		System.out.println(sum);
		
		//1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)의 결과를 계산하시오.
		i=0;
		int beforeSum=0;
		sum=0;
		for(i=1; i<11; i++) {
			beforeSum += i;
			sum = sum+(sum+beforeSum);
		}
		System.out.println(sum);
		
		
		//1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때, 
		// 몇까지 더해야 (변수 선언해야함) 
		// 총합이 100이상이되는지 구하시오.
		
		int n = 1;
		sum = 0;
		while(sum<100) {
			if(n%2==1) {
				sum=sum+n;
			} else if(n%2==0) {
				sum = sum-n;
			}
			if(sum>=100) {
				System.out.println(n);
				break;
			}
			n++;
		}
		
		//두 개의 주사위를 던졌을 때, 
		// 눈의 합이 6이 되는 
		// 모든 경우의 수를 출력하는 프로그램을작성하시오.
        for(i=1; i<7; i++) {
        	for(int j=1; j<7; j++) {
        	 	if(j==6-i) {
        	 		System.out.println(i+","+j);
        	 	}
        	 	
        	}
        }

        System.out.println("===================================");
        
		// 방정식 2x+4y=10의 모든 해를 구하시오. 
       // 단, x와 y는 정수이고 
       // 각각의 범위는 0<=x<=10,  0<=y<=10 이다.
        for(i=0; i<11; i++) {
        	for(int j=0; j<11; j++) {
        		if(2*i+4*j==10) {
        			System.out.println(i+","+j);
        		}
        	}
        }
        
        System.out.println("===================================");

        
        // 피보나치 수열
        // 피보나치(Fibonnaci) 수열(數列)은 앞을 두 수를 더해서 다음 수를 만들어 나가는수열이다. 
        // 예를 들어 앞의 두 수가 1과 1이라면 그 다음 수는 2가 되고 그 다음 수는 1과 2를더해서 3이 되어서 1,1,2,3,5,8,13,21,... 과 같은 식으로 진행된다. 
        // 1과 1부터 시작하는피보나치수열의 10번째 수는 무엇인지 계산하는 프로그램을 완성하시오.
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;
		System.out.print(num1+","+num2);

		for (i=0; i<8; i++ ) {
			num3 = num1 + num2;
            System.out.print(", " + num3);
           
            num1=num2;
            num2=num3;
		}
		
        System.out.println("===================================");

		
		
		// [13] 다음은 주어진 문자열(value)이 숫자인지를 판별하는 프로그램이다. (1)에 알맞은 코드를넣어서 프로그램을 완성하시오.
		
		String value = "12o34";
		char ch = ' ';
		boolean isNumber = true;
		// 반복문과 charAt(inti)를 이용해서 문자열의 문자를
		// 하나씩 읽어서 검사한다.
		for(i=0; i<value.length();i++) {
         ch=value.charAt(i);
         if(ch>='a' && ch<='z') {
        	 isNumber = false;
        	 break;
         }
		}

		if (isNumber) {
		System.out.println(value+"는 숫자입니다.");
		} else {
		System.out.println(value+"는 숫자가 아닙니다.");
		}
		

		
		// [14] 다음은 숫자 맞추기 게임을 작성한 것이다. 
		// 1과 100사이의 값을 반복적으로 입력해서 -> 입력 받기
		// 컴퓨터가 생각한 값을 맞추면 게임이 끝난다. 
		// 사용자가 값을 입력하면, 컴퓨터는 자신이 생각한값과 비교해서 결과를 알려준다. -> 비교연산 
		// 사용자가 컴퓨터가 생각한 숫자를 맞추면 게임이 끝나고 몇 번만에 숫자를 맞췄는지 알려준다. 
		// (1)~(2)에 알맞은 코드를 넣어 프로그램을 완성하시오.

		
		
        System.out.println("===================================");

        
		// 1~100사이의 임의의 값을 얻어서 answer에 저장한다.
		int answer = (int)(Math.random()*100)+1;
		int input = 0; // 사용자입력을 저장할 공간
		int count = 0; // 시도횟수를 세기위한 변수
		// 화면으로 부터 사용자입력을 받기 위해서 Scanner클래스 사용
		Scanner s = new Scanner(System.in);

		do {
		count++;
		System.out.print("1과 100사이의 값을 입력하세요 :");
		input = s.nextInt(); // 입력받은 값을 변수 input에 저장한다.
        if(answer>input) {
        	System.out.println("더 큰 수입니다");
        } else if(answer<input) {
        	System.out.println("더 작은 수입니다");
        } else {
        	System.out.println(count + " 회만에 맞췄습니다. 게임을 종료합니다.");
        	break;
        }
		
		} while(true); // 무한반복문
		
		
		
		
		
		
		
		
		
	
	}

}
