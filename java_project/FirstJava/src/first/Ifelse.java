package first;

import java.util.Scanner;

public class Ifelse {

	public static void main(String[] args) {
		// 문자열 처리 : String 클래스 이용 => 객체 생성 -> 클래스가 가지는 변수와 메서드를 메모리에 로드한다.

		
		/*
		// 참조 변수 : 객체의 메모리 주소값을 저장
		String str = null; // null -> 참조변수가 객체의 주소값을 저장하고 있지 않는다. 
		
		str = "abc"; // "" 공백 문자열을 이용한 객체를 생성하고 주소값을 반환 
		
		System.out.println(str.toString()); // str.toString();은 문자열을 반환
		System.out.println(str.equals("abc"));
		
		if(str != null && !str.equals("")) {
			System.out.println(str.charAt(1));
		}
		*/
		
		/*
		int num1=50;
		int num2=20;
		
		int big = 0; //큰수
		int diff = 0; //두 수의 차이
		
		// 삼항 연산자 이용
		// big = num1>num2 ? num1 : num2; // big = num1 ;
		// diff = num1>num2? num1-num2 : num2 - num1;
		
		
		//if else문으로 바꿔보기
		if(num1>num2) {
			big = num1;
			diff = num1 - num2;
		}
		else {
			big = num2;
			diff = num2 - num1;
		}
		
		System.out.println("큰수 : " + big +",  큰 수와 작은 수의 차이는 " +diff+ "입니다.");

		*/
		
		/*
		int n = 0;
		
		System.out.println("메뉴를 선택하세요\n1.입력 2.보기 3.수정 4.삭제");
		
		Scanner sc =new Scanner(System.in);
		
		n = sc.nextInt();
		
		
		
		switch (n) {
		case 1:
			System.out.println("입력 합니다.");
			// System.out.println("Simple JAVA");
			break;
		case 2:
			System.out.println("데이터를 열람합니다.");
			// System.out.println("Funny JAVA");
			break;
		case 3:
			System.out.println("정보를 수정합니다.");
			// System.out.println("Fantastic JAVA");
			break;
		case 4:
			System.out.println("데이터를 삭제합니다.");
			break;
		}
		
		*/
		
		
		/* switch 케이스를 이용해서 작성해보기
		num < 0 이라면 “0 미만” 출력
		0 ≤ num <100 이라면 “0이상 100 미만“ 출력
		100 ≤ num < 200 이라면 “100이상 200 미만“ 출력
		200 ≤ num < 300 이라면 “200이상 300 미만“ 출력
		300 ≤ num 이라면 “300이상 “ 출력
		*/
		

		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요 : ");
        num = sc.nextInt();
		
		if(num<0) {
			System.out.println("0 미만입니다");
		}
		else { // 이 else문을 안 써주면 음수일 경우에도 몫이 0이 되기 때문에 0이상 100미만이라는 값이 출력. else를 쓰게 되면
			   // 0 미만이 아닌 경우에서! 조건을 정해주는 거기 때문에 문제 없이 출력이 됨. 
		switch (num/100) {
		case 0:
			System.out.println("0이상 100미만");
			break;
		case 1:
			System.out.println("100이상 200미만");
			break;
		case 2:
			System.out.println("200이상 300미만");
			break;
		case 3:
			System.out.println("300이상");
			break;
        default:    // default를 쓰게 되면 switch 문의 case 조건에 해당되지 않는 값을 출력할 수 있음. 
        	       // 예를 들어 453이면, 300이상이고 case에 해당되지 않기에 아랫값을 출력할 수 있음.
        	System.out.println("400이상");
        	break;
        	
        	// 변수의 범위가 넓어져도 계속해서 switch 문을 써서 범위를 확대시켜 나가야함. 자동으로 해줄 수 있는 건 없음. 
		}
		
		}
		
		
		
		
		
	}

}
