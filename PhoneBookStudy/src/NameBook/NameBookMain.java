package NameBook;

import java.util.InputMismatchException;

public class NameBookMain implements NameMenu {

	public static void main(String[] args) {

		NameBookManager manager = NameBookManager.getInstance();
		int select;

		while (true) {
			System.out.println("+++++++++++++++++++++전화번호부");
			System.out.println(INPUT + ".입력");
			System.out.println(DELETE + ".삭제");
			System.out.println(SHOW + ".정보 조회");
			System.out.println(EXIT + ".종료");
			System.out.println(SAVE + ".파일 저장");
			System.out.println("+++++++++++++++++++++++++++++");
			System.out.println("메뉴 선택 >> ");
			
			select = Util.S.nextInt();
			
			try {
				if(select<=0 && select>6) {
					System.out.println("잘못된 입력입니다. 처음으로 돌아갑니다.");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다. 처음으로 돌아갑니다.");
				continue;
			}

			switch (select) {
			case INPUT:
				manager.insertInfo();
				break;
			case DELETE:
				manager.deleteInfo();
				break;
			case SHOW:
				manager.displayAll();
				break;
			case EXIT:
				System.out.println("종료합니다.");
				return;
			case SAVE:
				manager.saveFile();
				break;

			}

		}

	}

}