package ver05;

import ver03.Util;

public class PhoneBookManager {
	
	// 전화번호 정보를 저장할 배열을 가지고,
	// 배열을 이용한 정보의 저장, 삭제, 출력을 하는 기능
	
	// 배열 선언 : 상속 관계의 조상 클래스인 PhoneInfor 타입으로 선언
	private PhoneInfor[] pBook;   // 전화번호 정보를 저장할 배열
	private int cnt;             // 배열에 저장된 요소의 개수, 배열의 index
	
	// 생성자 : 싱글톤 처리 -> 외부에서 인스턴스 생성을 금지.
	private PhoneBookManager(int num){
		pBook = new PhoneInfor[num];    // 생성자의 매개변수 인자를 전달 받아 배열 생성
		cnt = 0;
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
		pBook[cnt++] = info;
		System.out.println(info);
	}
	
	// 전화번호 정보를 인스턴스 생성하고 배열에 저장
	public void insertInfo() {
		
		// 100개 입력 0<=index<=99, cnt=100
		// pBook[100] -> 오류
		// 배열의 개수와 입력된 요소의 개수를 비교
		if(pBook.length==cnt) {
			System.out.println("더 이상 정보를 저장할 수 없습니다.");
			System.out.println("일부 정보를 삭제하고 저장 공간을 확보해 주세요.");
		}
		
		System.out.println("어떤 정보를 입력하시겠어요? ");
		// System.out.println("1. 기본"); 추상클래스 -> 인스턴스 생성 불가
		System.out.println(Menu.UNIV+". 대학");
		System.out.println(Menu.COM+". 회사");
		System.out.println(Menu.CAFE+". 동호회");

        int select = Util.sc.nextInt();
        Util.sc.nextLine();
        
        if(!(select>0 && select<4)) {
        	System.out.println("메뉴 선택이 올바르지 않습니다.");
        	System.out.println("초기 메뉴로 이동합니다. ");
        	return;
        }

        System.out.println("정보 입력을 시작합니다.");
        System.out.println("이름 >> ");
        String name = Util.sc.nextLine();        
        System.out.println("전화번호 >> ");
        String pNum = Util.sc.nextLine();
        System.out.println("주소 >> ");
        String addr = Util.sc.nextLine();  // next로 썼기 때문에 표시를 안하고 넘겨버림....
        System.out.println("이메일 >> ");
        String email = Util.sc.nextLine();
        Util.sc.nextLine();
        
        switch(select) {
//        case 1: 
//        	// 인스턴스 생성 -> 배열에 저장 
//        	addInfor(new PhoneInfor(name, pNum, addr, email));
//        	break;
        case Menu.UNIV:
        	// 추가 정보 받고 -> 인스턴스 생성 -> 배열에 저장
        	// 전공, 학년
        	System.out.println("전공 >> ");
        	String major = Util.sc.nextLine();
        	System.out.println("학년 >> ");
        	int grade = Util.sc.nextInt();
        	
        	addInfor(new UnivPhoneInfor(name, pNum, addr, email, major, grade));
        	
        	break;
        case Menu.COM: 
        	// 추가 정보 받고 -> 인스턴스 생성 -> 배열에 저장
        	// 회사 이름
        	System.out.println("회사 이름 >> ");
        	String company = Util.sc.nextLine();
        	addInfor(new CompanyPhoneInfor(name, pNum, addr, email, company));
        	break;
        case Menu.CAFE:
        	// 추가 정보 받고 -> 인스턴스 생성 -> 배열에 저장
        	// 동호회 이름, 닉네임
        	System.out.println("동호회 이름 >> ");
        	String cafeName = Util.sc.nextLine();
        	System.out.println("닉네임 >> ");
        	String nickName = Util.sc.nextLine();
        	addInfor(new CafePhoneInfor(cafeName, pNum, addr, email, cafeName, nickName));
        	break;
        }
        System.out.println("입력한 정보가 저장되었어요. (저장 개수 : "+cnt+")");
	}
	
	// 정보 검색	
	// 배열의 index를 찾는 메서드
	private int searchIndex(String name) {
		int index=-1;  // 정보가 없을 때
		
		for(int i=0; i<cnt; i++) {
			// 이름으로 비교해야함
			if(pBook[i].getName().equals(name)) {
				index=i;
			}
		}
		return index;
	}
	
	// 해당 index의 참조변수로 정보 출력 : 사용자가 입력한 이름으로 검색
    public void searchInfor() {
    	Util.sc.nextLine();
    	System.out.println("검색하실 이름을 넣어주세요. ");
    	String name = Util.sc.nextLine();
    	
    	int index = searchIndex(name);
    	
    	if(index<0) {
    		System.out.println("검색한 이름"+name+"의 정보가 없어요.");
    		System.out.println("메뉴로 돌아갑니다.");
    	} else {
    		System.out.println("검색 결과 ==============");
    		pBook[index].showInfor();
    		System.out.println("=====================");
    	}
    }
	
	
    // 사용자에게 이름을 입력받고 이름으로 검색한 후 정보를 삭제
    public void deleteInfor() {
     	if(cnt==0) {
    		System.out.println("저장된 정보가 없어요.");
    		return;
    	}
    	
    	Util.sc.nextLine();
    	
    	System.out.println("삭제하고자 하는 정보의 이름을 입력해주세요.");
    	String name = Util.sc.nextLine();
    	
    	int index = searchIndex(name);
    	
    	if(index<0) {
    		System.out.println("찾으시는 정보가 존재하지 않습니다.");
    	    System.out.println("메뉴로 이동합니다. ");
    	} else {
    		// 배열의 요소를 왼쪽으로 시프트
    		for(int i=index; i<cnt-1; i++) { // 내가 삭제하고자 하는 위치부터니까 index부터 시작, 왼쪽에 있는 걸 가지고오는거니까 -1 해야함
    			pBook[i]=pBook[i+1];
    		}
    		cnt--;   // 저장된 갯수를 감소시켜줌.
    		System.out.println("요청하신 이름의 정보가 삭제되었어요.");
    	}
    }
    
    
    
    // 전체 정보를 출력하는 메서드
    public void showAllInfor() {
    	if(cnt==0) {
    		System.out.println("저장된 정보가 없어요.");
    		return;
    	}
    	System.out.println("전체 정보를 출력합니다. ==============");
    	for(int i=0; i<cnt; i++) {
    		pBook[i].showInfor();
    		System.out.println("============================");
    	}
    }
	
}
