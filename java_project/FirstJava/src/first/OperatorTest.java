package first;

import java.lang.Math;

public class OperatorTest {

	public static void main(String[] args) {

		/*
		 * int num1 = 10; int num2 = 8;
		 * 
		 * System.out.println("10/8 = " + num1/num2);
		 * 
		 * System.out.println("10/8 = " + num1%num2); // -8로 나눠보기
		 * System.out.println("10/-8 = " + num1%-num2);
		 * 
		 * System.out.println("10f/8f = " + 10f/8f);
		 * 
		 * System.out.println("10f/8 = " + 10f/8);
		 * 
		 * System.out.println("10/8 = " + (num1/(float)num2) * 100);
		 */

		/*
		 * char c1 = 'A'; char c2 = 'B';
		 * 
		 * System.out.println("'A' < 'B' => " + (c1 < c2)); // 65 < 66으로 변경이 되었기 때문에 참으로
		 * 출력. why? 부등호가 비교 연산자이기 때문. System.out.println("'0' == 0 => " + ('0' == 0));
		 * // 48 ==0이라는 의미인가? 란 뜻이 되므로 거짓.
		 * 
		 * System.out.println("10.0d == 10.0f => " + (10.0d == 10.0f)); //10.0d ==
		 * 10.0d로 형변환이 됨.
		 * 
		 * System.out.println("0.1d == 0.1f => " + (0.1d == 0.1f)); // 0.1d == 0.1d로
		 * 변환되나..
		 * 
		 * double d = (double)0.1f;
		 * 
		 * System.out.println("d => " + d); //형변환이 되어서 소숫점 17째 자리까지 표현하게 되어 0.1f과는 같지 않게
		 * 됨.
		 * 
		 * System.out.println("(float)d == 0.1f => " + ((float)d == 0.1f)); //소숫점 6째
		 * 자리까지만 표현하게 되어 0.1f와 같게 됨.
		 * 
		 */

		/*
		 * 
		 * int num1 = 10; int num2 = 20;
		 * 
		 * boolean result1 = (num1 == 10 && num2 == 20); // 우선순위 1 3번 우선순위 2 boolean
		 * result2 = (num1 <= 12 || num2 >= 30); // 1번 true 3번 true 2번 false
		 * 
		 * System.out.println("num1 == 10 && num2 == 20 => " + result1);
		 * System.out.println("num1 <= 12 || num2 >= 30 => " + result2);
		 * 
		 * // 기억해두기. 다시 한 번 확인하기 if(!(num1 == num2)) { // 같을 때 true가 나와야하지만 ! 부정연산자를
		 * 붙였으므로 값을 부정하게 되어서 결과값이 출력됨. System.out.println("num1과 num2는 같지 않다"); } else {
		 * System.out.println("num1과 num2는 같다"); }
		 * 
		 */

		/*
		 * 
		 * // 자릿수 맞추는 알고리즘 float pi = 3.141592f; float sPi =(int)(pi * 100)/100f;
		 * //100으로만 하면 정수값 int밖에 표현이 안되기 때문에 f를 붙여야함 System.out.println(sPi);
		 * 
		 * //Math클래스 사용 float sPi2 = Math.round(pi*100)/100f; //round 메서드는 int로 반환이 됨
		 * System.out.println(sPi2);
		 * 
		 * 
		 * //백단위까지 끊어보기 int price = 11234; int price2 = (price/1000)*1000;
		 * 
		 * System.out.println(price2);
		 * 
		 */

		int i = 5, j = 5;
		System.out.println(i++); // 출력 : 5, i=6,  
		System.out.println(++j); // 출력 : 1, j=1
		
		System.out.println("i = "+ i +", j = "+j);
		
		



	}

}
