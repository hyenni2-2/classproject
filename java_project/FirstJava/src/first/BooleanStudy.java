package first;

import java.util.Scanner;

public class BooleanStudy {

	public static void main(String[] args) {
		// 두 개의 정수를 입력받아 큰 수를 작은 수로 나눈 몫과 나머지 출력
		
		Scanner sc = new Scanner(System.in);
		
		int Num1;
		int Num2;
		
		System.out.println("첫 번째 수 = ");
		Num1 = sc.nextInt();
		
		System.out.println("두 번째 수 = ");
		Num2 = sc.nextInt();
		
		if(Num1 > Num2) {
			System.out.println("몫은 " + Num1/Num2);
			System.out.println("나머지는" + Num1%Num2);
		}
		else {
			System.out.println("몫은 " + Num2/Num1);
			System.out.println("나머지는" + Num2%Num1);

	}

		
		
		
		//cm로 표현된 키 입력하여 피트와 인치로 변환. 
	}
}
