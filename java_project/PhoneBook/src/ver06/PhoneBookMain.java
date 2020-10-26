package ver06;

import java.util.InputMismatchException;

import ver03.Util;

public class PhoneBookMain implements Util {

	public static void main(String[] args) {

		// PhoneBookManager manager = new PhoneBookManager(100);
        PhoneBookManager manager = PhoneBookManager.getInstance();
		
		while (true) {
			System.out.println("메뉴를 입력해 주세요. ==============");
			System.out.println(Menu.INSERT+". 저장");
			System.out.println(Menu.SEARCH+". 검색");
			System.out.println(Menu.DELETE+". 삭제");
			System.out.println(Menu.DISPLAY_ALL+". 모든 정보 출력");
			System.out.println(Menu.EXIT+". EXIT");

			System.out.println("\n>> ");

			int select = Util.SC.nextInt();

			try {
			if (!(select > 0 && select < 6)) {
				// System.out.println("메뉴의 선택이 올바르지 않습니다.\n다시 선택해 주세요.");
				// Exception e = new Exception("잘못된 메뉴 입력");
				BadinputException e = new BadinputException(String.valueOf(select));
				throw e;
			}
			} catch(InputMismatchException | BadinputException e) {
				System.out.println("메뉴 입력이 잘못되었습니다.");
				SC.nextLine();
				continue;
			} catch (Exception e1) {
				System.out.println("메뉴 입력이 잘못되었습니다.");
				SC.nextLine();
				continue;
			}
			

			switch (select) {
			case Menu.INSERT:
				manager.insertInfo();
				break;
			case Menu.SEARCH:
				manager.searchInfor();
				break;
			case Menu.DELETE:
				manager.deleteInfor();
				break;
			case Menu.DISPLAY_ALL:
				manager.showAllInfor();
				break;
			case Menu.EXIT:
				System.out.println("프로그램을 종료합니다. ");
				return;
			}

		}

	}

}
