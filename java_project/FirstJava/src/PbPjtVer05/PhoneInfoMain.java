package PbPjtVer05;

import java.util.Scanner;

public class PhoneInfoMain implements MenuVer05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 배열에 몇 명 넣을지 설정
		System.out.println("몇 명을 저장하시겠어요? ");
		int put = 0;
		put = sc.nextInt();
		PhoneInfoManager manager = new PhoneInfoManager(put);   // 순서에 유의해서 만들기. 

		
		
		// 무한반복문으로 질문 사항 만들기
		while(true) {
			if(put==manager.getInfoCnt()) {
				System.out.println("더 이상 저장할 수 없습니다.");
				System.out.println("전체 정보를 확인할까요?");
				System.out.println("확인 : 1,  취소 : 2");
				int choose = sc.nextInt();
				switch(choose) {
				case 1:
					manager.showAllInfo();
					System.out.println("프로그램을 종료합니다.");
					break;
				case 2: 
					System.out.println("프로그램을 종료합니다.");
					break;
				} 
				break;
			}
			
			System.out.println("2020 옐로우 페이지==============");
			System.out.println(MenuVer05.UNIV+". 대학 친구 정보 저장");
			System.out.println(MenuVer05.COM+". 회사 동기 정보 저장");
			System.out.println(MenuVer05.CAFE+". 동호회 친구 정보 저장");
			System.out.println(MenuVer05.FAM+". 가족 정보 저장");
			System.out.println(MenuVer05.SEARCH+". 이름 찾아보기");
			System.out.println(MenuVer05.DELETE+". 정보 삭제하기");
			System.out.println(MenuVer05.DISPLAY_ALL+". 전체 정보 확인하기");
			System.out.println(MenuVer05.DISPLAY_BASIC+". 기본 정보 확인하기");
			System.out.println(MenuVer05.EXIT+". EXIT");
			System.out.println("===========================");

			// 선택한 번호 입력받기(Manager에 정보 입력받는 변수명이랑 같아야함)
			int choice = sc.nextInt();
			
		switch(choice) {
		case 1: case 2: case 3: case 4:
			manager.saveFriend(choice);
			break;
		case 5: 
			manager.searchInfo();
			break;
		case 6:
			manager.deleteInfo();
			break;
		case 7:
			manager.showAllInfo();
			break;
		case 8:
			manager.showAllSimple();
			break;
		case 9:
			System.out.println("프로그램 종료!");
			System.exit(0);
			return;
		default:
			System.out.println("잘못된 숫자! 다시 입력하세요.");
		}
		
		
}	
		
		
		
		
		

	}

}
