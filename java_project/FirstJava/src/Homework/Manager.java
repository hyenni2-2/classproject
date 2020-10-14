package Homework;

import java.util.Scanner;

public class Manager {
//	Project : ver 0.30
//	배열을 이용해서 프로그램 사용자가 입력하는 정보가 최대 100개까지
//	유지되도록 프로그램을 변경. 아래기능 삽입
//	저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
//	검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
//	삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제
//	데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로
//	재정리 2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장.
	
    //	배열을 선언. 100개 저장
	final PhoneInfor[] users = new PhoneInfor[100];
	Scanner sc = new Scanner(System.in);
	
	// 기능 삽입 - 생성자 생성
	// 저장하는 기능 만들기 - 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
	// 계속해서 돌아야 하니까 무한반복문 안에 넣기. -> 그럼 저장하는 부분만 계속해서 도는 거니까 나가는 것도 만들어야한다.
	// 무한반복문은 클래스 안에 만들게 되면 계속 돌아가니까 효용성이 떨어진다. 그러므로 클래스가 아니라 메인메서드에 만들기.
	// 클래스는 기능만 정의하기. 흐름까지 넣어버리면 너무 복잡해져버린다. 
		void saveInfo() { // 매개변수를 넣으면 안된다. 사용자로부터 입력받을 거니까.
			String name, num, bd;
			System.out.println("1.정보 저장");
			System.out.println("이름을 입력하세요.");
			name = sc.nextLine();
			System.out.println("번호를 입력하세요.");
	        num = sc.nextLine();
	        System.out.println("생일을 입력하세요.");
	        bd = sc.nextLine(); 
	}
	
          // 검색 : 이름을 기준으로 데이터를 찾아서 -> equals 
		 // 해당 데이터의 정보를 출력 -> for문으로 검색하기
		  void searchInfo() { // 매개변수는 사용자로부터 입력받기 
			  System.out.println("2.이름 검색");
			  System.out.println("이름을 입력하세요.");
			  String name = sc.nextLine();
			  if(name.equals(name)) {
				  System.out.println("");
			  }
			  
		  }
		
	   
		
	
	
	
	
}
