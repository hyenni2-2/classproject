package Homework;

import java.util.Scanner;

public class PhoneBookMain3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		Manager modiInfo = new Manager(); // 새로운 인스턴스 생성. 매니저 클래스에서 가져오는 참조 변수 modiInfo라는 뜻
	
		
		while(true) {
		// 선택지 만들기
		System.out.println("2020 혜인이네 전화번호부");
		System.out.println("==============================");
		System.out.println("1.저장하기");
		System.out.println("2.검색하기");
		System.out.println("3.삭제하기");
		System.out.println("4.현재까지의 정보 확인");
		System.out.println("5.끝내기");
		System.out.println("==============================");
		System.out.println("번호를 선택하세요. : ");
		int choose = sc.nextInt();
		
		
		// 선택한 후 분기하기 
		switch(choose) {
		case 1:
			modiInfo.saveInfo();
			break;
		case 2:
			modiInfo.searchInfo();
			break;
		case 3:
			modiInfo.deleteInfo();
			break;
		case 4:
		   modiInfo.showAllData();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);			
		default:
			System.out.println("잘못 입력하셨습니다. 다시 선택해 주세요.");
		}
		

}

		
		
	}

}
