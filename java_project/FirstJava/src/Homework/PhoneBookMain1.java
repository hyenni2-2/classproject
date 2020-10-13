package Homework;

import java.util.Scanner;

public class PhoneBookMain1 {

	public static void main(String[] args) {
		PhoneInfor info = new PhoneInfor();
		PhoneInfor info2 = new PhoneInfor();
		
		info.data("진효선", "010-1111-1111");
		info2.data("최혜인", "010-1111-2222", "19901031");
		
	    info.showData();
	    info2.showData();
	    
	    PhoneBookMain1 input = new PhoneBookMain1();
	    
	    input.inputData();

	}

	
//	Project : ver 0.20
//	"프로그램 사용자로부터 데이터 입력"
//	프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스를 생성하는 것이 핵심.
//	단 반복문을 이용해서 프로그램의 흐름을 계속 유지하도록 한다.
	
	
   Scanner s = new Scanner(System.in);
   String name;
   String number;
   String birthday;
   
 void inputData() {	
		System.out.println("정보를 입력하세요");
	 while(true) {
		System.out.println("이름 : ");
		name = s.nextLine();
		System.out.println("전화번호 : ");
		number = s.nextLine();
		System.out.println("생년월일 : ");
		birthday = s.nextLine();
      System.out.println("계속해서 입력할까요? 1:계속 2:종료");
      int result = s.nextInt();
      if(result==2) {
    	  System.out.println("입력을 종료합니다");
         break;
      }
      
	}
	
	
}
	
}
