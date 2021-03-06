package ver07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import ver03.Util;

public class PhoneBookManager implements Util {
	
	// 전화번호 정보를 저장할 배열을 가지고,
	// 배열을 이용한 정보의 저장, 삭제, 출력을 하는 기능
	
	// 배열 선언 : 상속 관계의 조상 클래스인 PhoneInfor 타입으로 선언
//	private PhoneInfor[] pBook;   // 전화번호 정보를 저장할 배열
//	private int cnt;             // 배열에 저장된 요소의 개수, 배열의 index
	
	// 배열을 이용해서 저장하는 방식을 ArrayList<T> 컬랙션을 이용해서 구현해 보자.
	List<PhoneInfor> pBook;
	
	
	
	// 생성자 : 싱글톤 처리 -> 외부에서 인스턴스 생성을 금지.
	private PhoneBookManager(int num){
		// pBook = new PhoneInfor[num];    // 생성자의 매개변수 인자를 전달 받아 배열 생성
		// cnt = 0;
		// List<PhoneInfor> 초기화 
		pBook = new ArrayList<PhoneInfor>();
		// 파일에서 인스턴스들을 로드
		load();
	}
	
	// 내부에서 인스턴스 생성
	private static PhoneBookManager manager = new PhoneBookManager(100);
	
	// 외부에서 참조변수를 받을 수 있는 메서드
	public static PhoneBookManager getInstance() {
		return manager;
	}

	// 정보 저장
	//   1. 배열에 저장하는 메서드 -> 다형성을 이용해서 하나의 메서드로 정의 addInfor(상위클래스 타입의 매개변수)
	//   2. 사용자에게 받은 데이터를 인스턴스로 생성하는 메서드
	//      입력의 구분 -> 구분에 따라 인스턴스 생성도 구분 -> addInfor()메서드를 이용해서 정보를 저장
	
	// 배열에 전화번호 정보를 저장하는 메서드
	private void addInfor(PhoneInfor info) {
		// pBook[cnt++] = info;
		
		//List에 정보 저장
		pBook.add(info);
		//System.out.println(info);
	}
	
	// 전화번호 정보를 인스턴스 생성하고 배열에 저장
	public void insertInfo() {
		
		// 100개 입력 0<=index<=99, cnt=100
		// pBook[100] -> 오류
		// 배열의 개수와 입력된 요소의 개수를 비교
//		if(pBook.length==cnt) {
//			System.out.println("더 이상 정보를 저장할 수 없습니다.");
//			System.out.println("일부 정보를 삭제하고 저장 공간을 확보해 주세요.");
//		}

		int select =0;
		
		// List는 저장 공간이 부족하면 저장공간을 확장
		while(true) {
		System.out.println("어떤 정보를 입력하시겠어요? ");
		// System.out.println("1. 기본"); 추상클래스 -> 인스턴스 생성 불가
		System.out.println(Menu.UNIV+". 대학");
		System.out.println(Menu.COM+". 회사");
		System.out.println(Menu.CAFE+". 동호회");

		try {	
			
			select = SC.nextInt();
        
        if(!(select>0 && select<4)) {
        	// System.out.println("메뉴 선택이 올바르지 않습니다.");
        	// System.out.println("초기 메뉴로 이동합니다. ");
        	// return;
        	BadinputException e = new BadinputException(String.valueOf(select));
        	throw e;
        }
		} catch(InputMismatchException | BadinputException e) {
			System.out.println("잘못된 메뉴 입력입니다. 다시 선택해 주세요.");
			continue;
		}
		break;
		}
         SC.nextLine();
		
        System.out.println("정보 입력을 시작합니다.");
        System.out.println("이름 >> ");
        String name = SC.nextLine();        
        System.out.println("전화번호 >> ");
        String pNum = SC.nextLine();
        System.out.println("주소 >> ");
        String addr = SC.nextLine();  // next로 썼기 때문에 표시를 안하고 넘겨버림....
        System.out.println("이메일 >> ");
        String email = SC.nextLine();
        
        
        switch(select) {
//        case 1: 
//        	// 인스턴스 생성 -> 배열에 저장 
//        	addInfor(new PhoneInfor(name, pNum, addr, email));
//        	break;
        case Menu.UNIV:
        	// 추가 정보 받고 -> 인스턴스 생성 -> 배열에 저장
        	// 전공, 학년
        	System.out.println("전공 >> ");
        	String major = SC.nextLine();
        	System.out.println("학년 >> ");
        	int grade = SC.nextInt();
        	
        	addInfor(new UnivPhoneInfor(name, pNum, addr, email, major, grade));
        	
        	break;
        case Menu.COM: 
        	// 추가 정보 받고 -> 인스턴스 생성 -> 배열에 저장
        	// 회사 이름
        	System.out.println("회사 이름 >> ");
        	String company = SC.nextLine();
        	addInfor(new CompanyPhoneInfor(name, pNum, addr, email, company));
        	break;
        case Menu.CAFE:
        	// 추가 정보 받고 -> 인스턴스 생성 -> 배열에 저장
        	// 동호회 이름, 닉네임
        	System.out.println("동호회 이름 >> ");
        	String cafeName = SC.nextLine();
        	System.out.println("닉네임 >> ");
        	String nickName = SC.nextLine();
        	addInfor(new CafePhoneInfor(cafeName, pNum, addr, email, cafeName, nickName));
        	break;
        }
        System.out.println("입력한 정보가 저장되었어요. (저장 개수 : "+pBook.size()+")");
	}
	
	// 정보 검색	
	// 배열의 index를 찾는 메서드
	// List의 index 찾기
	private int searchIndex(String name) {
		int index=-1;  // 정보가 없을 때
		for(int i=0; i<pBook.size(); i++) {
		// for(int i=0; i<cnt; i++) {
			// 이름으로 비교해야함
			if(pBook.get(i).getName().equals(name)) {
			// if(pBook[i].getName().equals(name)) {
				index=i;
			}
		}
		return index;
	}
	
	// 해당 index의 참조변수로 정보 출력 : 사용자가 입력한 이름으로 검색
    public void searchInfor() {
    	SC.nextLine();
    	System.out.println("검색하실 이름을 넣어주세요. ");
    	String name = SC.nextLine();
    	
    	int index = searchIndex(name);
    	
    	if(index<0) {
    		System.out.println("검색한 이름"+name+"의 정보가 없어요.");
    		System.out.println("메뉴로 돌아갑니다.");
    	} else {
    		System.out.println("검색 결과 ==============");
    		pBook.get(index).showInfor();
    		System.out.println("=====================");
    	}
    }
	
	
    // 사용자에게 이름을 입력받고 이름으로 검색한 후 정보를 삭제
    public void deleteInfor() {
     	if(pBook.size()==0) {
    		System.out.println("저장된 정보가 없어요.");
    		return;
    	}
    	
    	SC.nextLine();
    	
    	System.out.println("삭제하고자 하는 정보의 이름을 입력해주세요.");
    	String name = SC.nextLine();
    	
    	int index = searchIndex(name);
    	
    	if(index<0) {
    		System.out.println("찾으시는 정보가 존재하지 않습니다.");
    	    System.out.println("메뉴로 이동합니다. ");
    	} else {
    		// 배열의 요소를 왼쪽으로 시프트
//    		for(int i=index; i<cnt-1; i++) { // 내가 삭제하고자 하는 위치부터니까 index부터 시작, 왼쪽에 있는 걸 가지고오는거니까 -1 해야함
//    			pBook[i]=pBook[i+1];
//    		}
//    		cnt--;   // 저장된 갯수를 감소시켜줌.
    		// List에서의 요소 삭제는 인덱스의 시프트도 이루어진다.
    		pBook.remove(index);    		
    		System.out.println("요청하신 이름의 정보가 삭제되었어요.");
    	}
    }
    
    
    
    // 전체 정보를 출력하는 메서드
    public void showAllInfor() {
    	if(pBook.size()==0) {
    		System.out.println("저장된 정보가 없어요.");
    		return;
    	}
    	System.out.println("전체 정보를 출력합니다. ==============");
    	for(int i=0; i<pBook.size(); i++) {
    		pBook.get(i).showInfor();
    		System.out.println("============================");
    	}
    }

    // List:pBook에 저장되어 있는 인스턴스들을 저장
    public void save() {
    	
    	if(pBook.size()==0) {
    		System.out.println("저장된 데이터가 없어 파일 저장이 되지 않습니다.");
    		return;
    	}
    	
    	// 인스턴스를 저장할 수 있는 출력 스트림 생성
    	try {
        	ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("phonebook.ser"));
//            for(PhoneInfor pi : pBook) {
//            	out.writeObject(pi);
//            }
        	out.writeObject(pBook);
            out.close();
            System.out.println("저장되었습니다.(phonebook.ser)");
    	} catch(IOException e) {
    		System.out.println("저장하는 과정 중에 오류가 발생했습니다. ("+e.getMessage()+")\n다시 시도해주세요.");
    	}
    }
    
    // 프로그램으로 파일의 저장 데이터를 로드하는 메서드
    void load() {
    	// 파일의 존재 여부 확인 : File 클래스 이용
    	File file = new File("phonebook.ser");
    	if(!file.exists()) {
    		System.out.println("저장된 파일이 존재하지 않습니다. 파일 저장 후 Load됩니다.");
    		return;
    	}
    
    
    // 파일에 있는 데이터를 메모리에 저장 : pBook에 저장
    // 파일의 데이터를 읽을 수 있는 스트림 생성
    try {
    ObjectInputStream in = new ObjectInputStream(new FileInputStream("phonebook.ser"));
//    while(true) {
//			Object obj = in.readObject();
//    	    pBook.add((PhoneInfor)obj);
//    	    if(obj==null) {
//    	    	break;
//    	    }
//    	    pBook.add((PhoneInfor) obj);
//    }
    pBook = (List<PhoneInfor>) in.readObject();
    System.out.println("데이터 로드 완료.");
    } catch(IOException e) {
    	//System.out.println("데이터를 로드하는 과정에 오류가 발생했습니다. ");
    }  catch (ClassNotFoundException e) {
    	System.out.println("데이터를 로드하는 과정에 오류가 발생했습니다. ");
    	e.printStackTrace();
	}
    
    }
}

