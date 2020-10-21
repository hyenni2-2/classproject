package first;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZero {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1=0, num2=0;
		
		
		while(true) {
			try {
				System.out.println("두 개의 정수를 입력해주세요.");
				System.out.println("숫자 1 >> ");
				num1 = sc.nextInt();
				sc.nextLine();
				System.out.println("숫자 2 >> ");
		        num2 = sc.nextInt();
				sc.nextLine();
			} catch(InputMismatchException e) {
				System.out.println("올바른 숫자를 입력하지 않았습니다.");
			    System.out.println("다시 입력해 주세요.");
			    sc.nextLine();
			    continue;    // 문제가 발생하면 다시 처음부터 해야하니까 continue
			}
			break;         // 문제없이 처리되면 빠져나가야 하니까 break
		}
		
        try {
        System.out.println("나눗셈의 몫 : " + (num1/num2));
        System.out.println("나눗셈의 나머지 : " + (num1%num2));
        } catch (ArithmeticException e) {
        	System.out.println("0으로 나눌 수 없습니다.");
        	System.out.println(e.getMessage());
        }
        System.out.println("프로그램을 종료합니다.");
	}

}
