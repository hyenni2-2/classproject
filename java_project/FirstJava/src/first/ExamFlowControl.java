package first;

import java.util.Scanner;

public class ExamFlowControl {

	public static void main(String[] args) {
		/*
		// 문제 2
		int num;
		num=300;
		if(num<0) {
			System.out.println("0 미만");
			
		} else if(num<100) { //else if 한 순간 위 0 미만이 아니라는 조건. 그러므로 num>=0은 안써도 됨
			System.out.println("0이상 100미만");
		} else if(num<200) { //num>=100 && num<200
			System.out.println("100이상 200미만");
		} else if(num<300) { //num>=200 && num<300
			System.out.println("200이상 300미만");
		} else {
			System.out.println("300 이상");
		}
		
		
		//  문제 3
        int num1 =50;
	    int num2 = 100;
	    int big; 
	    int diff;
		if(num1>num2) {
			big = num1;
		} else {
			big = num2;
		}
		System.out.println(big);
		
		
		if(num1>num2) {
			diff = num1-num2;
		} else {
			diff = num2-num1;
		}
		System.out.println(diff);
		*/
		
		// 문제 7
		
		int cnt = 1;
		while(cnt<=100) {
			System.out.println(cnt++);
			// cnt++;
		}
		do {
			// cnt--; // 뒷부분에 넣으면 감소가 안되어서 101출력하고 숫자가 줄어들음
			System.out.println(--cnt);
		} while(cnt>1);
		
		
		// 문제 8
		int i = 1; 
		int sum = 0; 
		int count = 0;
		while(i<=1000) { 
		if(i%14==0) {
				 System.out.println(i);
				 count++;
				 sum = sum +i;
		}
		 i++; 
		}
		System.out.println("출력된 숫자의 합은 : " + sum );
		System.out.println("출력된 숫자의 개수는 : " + count );

		
		//문제 9 
		int result=1;
		
		for(i=1; i<=10; i++) {
			result = result * i; // result *= i;
		}
		System.out.println("1~10까지 곱 : " + result);
		
		
		// Scanner sc = new Scanner(System.in); // Scanner 입력 후 ctrl + space 하면 스캐너 클래스 임포트 가능
		                                     // 스캐너가 클래스이므로 클래스를 불러오기 위해 임포트가 필요함 
		                                     // 같은 이름의 클래스를 불러올 수는 없음

		
		
		// 문제 11
		// ContinueBasic.java의 내부에 존재하는 while 문을 for 문으로 변경하여 작성
        System.out.println("문제 11 : 1~100 사이의 35의 배수의 개수 구하기 =================");

		int num=0;
		count=0;
		for(num=1; num<100; num++) {
			if(num%5!=0 || num%7!=0) {
				continue;
			}
			count++;
			System.out.println(num);
		}
			
//		while((num++)<100){
//		     if(num%5!=0 || num%7!=0) {
//		   continue;
//		   count++;
//           System.out.println(num);
//		}

		System.out.println("count: " + count);


		
		
		// 문제 12
		// 자연수 1부터 시작해서
		// (모든 홀수)와 (3의 배수인 짝수)를 더해 나간다. 
		// 그리고 그 합이 언제 (몇을 더했을 때) 1000이 넘어서는지, 
		// 그리고 1000이 넘어선 값은 얼마가 되는지 계산하여 출력하는 프로그램을 작성.
        // 프로그램 내부에 while문을 무한 루프로 구성하여 작성.
	
        num=1;
        sum=0;
        
		while(true) {
		  
			//(모든 홀수)와 (3의 배수인 and 짝수)
			if(num%2==1 || num%6==0) {
				sum += num;
			}
			// 위가 합을 구하는 조건
			// 아래가 탈출하는 조건..!!!!
			if(sum>1000) {
				System.out.println(num + "을 더하면 ");
				System.out.println("최초로 합이 1000이 넘어가는 합은 : " + sum);
				break;
			}
			
			num++;
		}
		
		// 문제 13
		// 구구단의 
		// 짝수 단(2,4,8)만 출력하는 프로그램 작성.
		// 단, 2단은 2x2까지, 4단은 4x4까지, 8단은 8x8 까지 출력
		// 반복문의 중첩 문제(구구단이니까)
		
		System.out.println("문제 13 : 구구단 출력 ==========================");
		// 단
		for(i=2; i<10; i=i*2) { // 2,4,8의 패턴 = x2한 수
			System.out.println(i+"단");
			for(int j=1; j<i+1; j++) { // i를 기준으로 생각해보기.
			System.out.println(i+"X"+j+"="+i*j);	
			}
		}
		
		
		
		// 문제 14
		// 다음 식을 만족하는 조합을 찾는 프로그램 작성. 
        //  A B       10의 자리 A, 1의 자리 B
		//+ B A       10의 자리 B, 1의 자리 A
        //------
		// 9 9        10A+B / 10B+A = 11A+11B=99 -> A+B=9
		// 조합을 찾는 프로그램..!!!!
		
		System.out.println("문제 14 =====================");
		
		System.out.println("  A B");
		System.out.println("+ B A");
		System.out.println("-------");
		System.out.println("  9 9");
		System.out.println("위의 조건이 성립하는 조합은 아래와 같습니다.");
		
		for(int n=0; n<10; n++) { // a+b=9, a=9-b
			int a, b;
			a=n;
			b=9-n;
			System.out.println("A="+a+"일 때, "+"B="+b+" 입니다.");	
		} // 굳이 b를 설정할 필요가 없음. 이미 대입되었으니까.
		
		
		
		
		
		
		
		
		
		
	}

}
