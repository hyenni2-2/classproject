package first;

import java.util.Scanner;

public class BooleanStudy {

	public static void main(String[] args) {
		// 두 개의 정수를 입력받아 큰 수를 작은 수로 나눈 몫과 나머지 출력
		
		/*
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

*/		
		
		// 메트로폴리스
		
		boolean isCapital;
		int jongro;
		int riches;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("19세 이상입니까?(19세 이상: 1 19세 미만 : 0)");
		isCapital = (sc.nextInt() == 1) ? true : false;
	    
		
	    if(isCapital=true) {
	    	System.out.println("종로구에 거주합니까?(yes:1 no : 0)");
	    	isCapital = (sc.nextInt() == 1) ? true : false;
	    		if(isCapital=true){
	    	    	System.out.println("선거권이 있습니다.");
	    		}
	    		else {
	    	    	System.out.println("선거권이 없습니다.");
	    		} 
	    }
	    /*
	    else {
	    	System.out.println("선거권이 없습니다.");
	    }
		*/
		
		
		
		
		
		
		
		
		
		
		//서울 종로구 지방선거권 유무 확인 프로그램 만들기
		
		int a;
		
		
		
		
		
		
		
		
		
		
	}
}
