package Homework;



public class MethodExam {
	
	public static void main(String[] args) {
		
		// 1번
		// MethodExam cal(10,3); /스태틱클래스여서 인스턴스 메소드를 출력 x
		   cal(10,3);
		   
		   System.out.println("=============================");
		
		// 2번
		abs(-4,-6);   
		   System.out.println("=============================");

		
		// 3번
		//원넓이
		System.out.println(cirArea(5));
		//원둘레
		System.out.println(cirRound(3));
		//리턴할 경우 메인메소드에서 출력한다.
		   System.out.println("=============================");
          // System.out.println(isPrimeNumber(3));
		   //1~100까지의 범위에서 소수 찾기
		  for(int i=1; i<=100; i++) {
			   if(isPrimeNumber(i)) {
			   System.out.println(i);
			   }
		   }
		
		
	}
	
	
	
	// 문제4.
	// 전달되는 값이 소수(prime number)인지 아닌지를 판단
	// 소수인경우 true를, 소수가 아닌 경우 false를 반환하는 메서드를 정의
	// 이를 이용해서 1이상 100 이하의 소수를 전부 출력할 수 있도록 
	// main 메서드를 정의하자.
	
static boolean isPrimeNumber(int num) {
		int cnt=0;
		// 소수인지 판별. 소수일 경우 나누어 떨어지는 경우가 2번 이상 없으므로 count를 이용해서 계산
		for(int i=1; i<=num; i++) {
			if(num%i==0) {
				cnt++;
			}
		}
		
		return cnt>2?false:true;
	}
	
	// 문제3
	// 원의 반지름 정보를 전달하면, (받는다) 
	// 원의 넓이를 계산해서 반환하는 메서드 (π*r∧2)
	// 원의 둘레를 계산해서 반환하는 메서드를 각각 정의 (2*π*r)
	// 이를 호출하는 main메서드를 정의하자. (2*π*r), (π*r∧2)
	
static double cirArea(double radius) {
		 return Math.PI * radius * radius;
	}
   
	
static	double cirRound(double radius) {
		return Math.PI * radius * 2;
	}


	
	
	
	
	
	
	 // 문제2.
	 //두 개의 정수를 전달 받아서,(매개변수 받기) 
	 // 두수의 절대값을 계산하여 출력하는 메서드 -> 음수일 때 양수로 바꾸기 (-를 곱하기 -1 or 부호 연산자 붙이기)
	 // 이 메서드를 호출하는 main메서드를 정의
	 // 단 메서드 호출 시 전달되는 값의 순서에 상관없이 절대값 계산, 출력
	 // 리턴 없음
	
	static void abs(int num1, int num2) {
		System.out.println("num1의 절대값 : " +(num1>0?num1:-num1));
		System.out.println("num2의 절대값 : " +(num2>0?num2:-num2));
		// 절대값 구하는 알고리즘
		
	}
	
	
	
	
	
	// 문제 1
	// 두 개의 정수를 전달받아서, 
	// 두수의 사칙연산 결과를 출력하는 메서드
	// 이 메서드를 호출하는 main메서드를 정의
	// 단, 나눗셈은 몫과 나머지를 각각 출력
	// 리턴이 없음
	

	
 static	void cal(int num1, int num2) {
		// 사칙연산 : +,-,*,/,%
		System.out.println(num1+"+"+num2+"="+(num1+num2));
		System.out.println(num1+"-"+num2+"="+(num1-num2));
		System.out.println(num1+"*"+num2+"="+(num1*num2));
		System.out.println(num1+"/"+num2+"="+(num1/num2));
		System.out.println(num1+"%"+num2+"="+(num1%num2));

	}
	


 
 
 
 
 
 
 
	
	
	

	
	
	
	
	
	

}
