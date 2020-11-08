package NameBook;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class NameBookManager implements Util {
	// 사용자로부터 입력받는 변수 정의하기
	int input;
	NameBookInfo n = new NameBookInfo();
	int index;

	// 싱글톤으로 정의해보기
	// 인스턴스 생성
	private static NameBookManager manager = new NameBookManager();

	// private생성자
	private NameBookManager() {
	}

	// getInstance 메서드 정의
	public static NameBookManager getInstance() {
		return manager;
	}

	// NameBookInfo타입의 ArrayList 선언 - 저장 개수 100
	List<NameBookInfo> list = new ArrayList<NameBookInfo>(100);

	// 어레이리스트에 정보 저장
	private void saveInfo(NameBookInfo n) {
		list.add(n);
	}

	// 배열 인덱스를 검색하는 메서드
	private int searchIndex(String name) {
		index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				index = i;
			}
		}
		return index;
	}

	// 일반 정보 입력받는 메서드
	void generalInfo() {
		System.out.println("정보 입력 plz");
		System.out.println("1. 이름 : ");
		String name = Util.S.nextLine();
		n.setName(name); // NameBookInfo의 세터사용이 가능해짐
		// System.out.println(n.getName() + "저장"); 제대로 불러오기가 가능한지 확인하기
		System.out.println("2. 전화번호 : ");
		String pNum = Util.S.nextLine();
		n.setPhoneNumber(pNum);
		//System.out.println(n.getPhoneNumber());
		System.out.println("3. 주소 : ");
		String addr = Util.S.nextLine();
		n.setAddress(addr);
		//System.out.println(n.getAddress());
		System.out.println("4.이메일 : ");
		String email = Util.S.nextLine();
		n.setEmail(email);
		//System.out.println(n.getEmail());
		// list.add(n);
		saveInfo(n);

	}

	// 정보 입력 받기
	void insertInfo() {

		while (true) {
			System.out.println("어떤 정보를 입력하시나요?");
			System.out.println("---------------------");
			System.out.println("1. 일반");
			System.out.println("2. 대학");
			System.out.println("3. 회사");
			System.out.println("4. 혈액형");
			System.out.println("5. 홈으로 돌아가기");
			System.out.println("---------------------");
			System.out.println("> ");
			input = S.nextInt();
			S.nextLine();

			switch (input) {
			case 1:
				generalInfo();
				//saveInfo(n);
				break;
			case 2:
				generalInfo();
				System.out.println("5. 전공 : ");
				String major = Util.S.nextLine();
				System.out.println("6. 학년 : ");
				String year = Util.S.nextLine();
				saveInfo(new PhoneUnivInfo(n.getName(), n.getPhoneNumber(), n.getAddress(), n.getEmail(), major, year));
				break;
			case 3:
				System.out.println("정보 입력 plz");
				System.out.println("1. 이름 : ");
				String name = Util.S.nextLine();
				n.setName(name);
				System.out.println("2. 전화번호 : ");
				String pNum = Util.S.nextLine();
				n.setPhoneNumber(pNum);
				//System.out.println(n.getPhoneNumber());
				System.out.println("3.이메일 : ");
				String email = Util.S.nextLine();
				n.setEmail(email);
				//System.out.println(n.getEmail());
				System.out.println("4. 회사 : ");
				String company = Util.S.nextLine();
				saveInfo(new PhoneCompanyInfo(n.getName(), n.getPhoneNumber(), n.getEmail(), company));
				break;
			case 4:
				generalInfo();
				System.out.println("5. 혈액형 : ");
				String bType = Util.S.nextLine();
				saveInfo(new BloodTypeInfo(n.getName(), n.getPhoneNumber(), n.getEmail(), bType));
			case 5:
				return;

			}

		}

	}



	// 정보 삭제하기
	void deleteInfo() {
		if (list.size() == 0) {
			System.out.println("저장된 정보가 없어요. 메뉴로 돌아갑니다.");
			return;
		}

		System.out.println("삭제할 이름을 입력하세요.");
		String name = Util.S.nextLine();

		int index = searchIndex(name); // 지금 입력받은 이름을 인덱스로 저장

		if (index < 0) {
			System.out.println("찾는 이름이 없어요. 메뉴로 돌아갑니다.");
		} else {
			list.remove(index);
			saveInfo(n);
			System.out.println("정보를 삭제했습니다.");
		}

	}

	// 정보 전체보기
	void displayAll() {
		if (list.size() == 0) {
			System.out.println("저장된 정보가 없어요. 메뉴로 돌아갑니다.");
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println("정보를 표시합니다-----------");
			list.get(i).showAll();
			System.out.println("------------------------");
		}

	}

	// 파일 저장
	void saveFile() {
		ObjectOutputStream save;
		try {
			save = new ObjectOutputStream(new FileOutputStream("saveName.ser"));
			save.writeObject(list);
			save.close();
			System.out.println("파일 저장 완료! ");
		} catch (IOException e) {
			System.out.println("파일 저장에 에러가 발생 : " + e.getMessage());
			e.printStackTrace();
		}
	}

	// 파일 로드

	void loadFile() {
		try {
			ObjectInputStream load = new ObjectInputStream(new FileInputStream("saveName.ser"));
			list = (List<NameBookInfo>) load.readObject();
			load.close();
			System.out.println("데이터 불러오기 완료!");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("저장에 에러가 발생! " + e.getMessage());
			e.printStackTrace();
		}
	}

}
