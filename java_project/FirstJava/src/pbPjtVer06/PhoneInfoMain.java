package pbPjtVer06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneInfoMain implements MenuVer05 {


	public static void main(String[] args) throws MenuException {
		
		Scanner sc = new Scanner(System.in);

		int put = 0;
		PhoneInfoManager manager = new PhoneInfoManager(put);   // 순서에 유의해서 만들기. 
		
		// 무한반복문으로 질문 사항 만들기
		int choose;
		
		while(true) {
			System.out.println("몇 명을 저장하시겠어요? ");
			try {
				put = sc.nextInt();
				if(put<=0) {
					MenuException e = new MenuException("입력 에러");
					throw e;
				}
			} catch(InputMismatchException|MenuException e) {
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요. ");
				sc.nextLine();      // 뒤에 생긴 공백으로 인한 에러를 처리해줌..!!
				continue;
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

			int choice=0;
			
			
			// 선택한 번호 입력받기(Manager에 정보 입력받는 변수명이랑 같아야함)
			
			try {
			 choice = sc.nextInt();
			 if(choice==0 && choice>9) {
				 MenuException me=new MenuException("입력 에러");
				 throw me;
			 }
			} catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다. 다시 입력하세요.");
				sc.nextLine();
				continue;
			}
			
			
				
			
		switch(choice) {
		case MenuVer05.UNIV: case MenuVer05.COM: case MenuVer05.CAFE: case MenuVer05.FAM:
			manager.saveFriend(choice);
			break;
		case MenuVer05.SEARCH: 
			manager.searchInfo();
			break;
		case MenuVer05.DELETE:
			manager.deleteInfo();
			break;
		case MenuVer05.DISPLAY_ALL:
			manager.showAllInfo();
			break;
		case MenuVer05.DISPLAY_BASIC:
			manager.showAllSimple();
			break;
		case MenuVer05.EXIT:
			System.out.println("프로그램 종료!");
			System.exit(0);
			return;
		default:
			System.out.println("잘못된 숫자! 다시 입력하세요.");
				}

		if(put==manager.pInfo.size()) {
			System.out.println("더 이상 저장할 수 없습니다.");
			System.out.println("전체 정보를 확인할까요?");
			System.out.println("확인 : 1,  취소 : 2");
		
			choose = sc.nextInt();
			
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
		
		}
		
		
		

	}

}