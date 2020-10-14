package ver03;

import java.util.Scanner;

public class PhoneBookManager {
//	Project : ver 0.30
//	배열을 이용해서 프로그램 사용자가 입력하는 정보가 최대 100개까지
//	유지되도록 프로그램을 변경. 아래기능 삽입
//	저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
//	검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
//	삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제
//	데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로
//	재정리 2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장.

	
     // 배열 : 전화번호 정보(이름, 전화번호, 생일)를 저장하는 목적
     final PhoneInfor[] phoneBook;    // 정보 저장을 위한 배열 선언, 중간에 정보가 바뀌면 안되니까 final 사용
     // PhoneInfor타입의 참조변수. 주소값을 가져오는 것
     int cnt;                   // 저장된 정보의 개수 : 반복횟수로도 사용 가능, 배열에 새로운 데이터 입력 시 index로도 사용 가능
     
     Scanner sc;
     
     
    // 초기화 - 생성자
    PhoneBookManager(){
    	// phoneBook = new PhoneInfor[100];   // 배열의 저장공간을 100개로 생성
        this(100);    
    }
    
    
    
    
    PhoneBookManager(int size) {
    	phoneBook = new PhoneInfor[size];   // 생성자 오버로딩을 이용해서 초기화.
        sc = new Scanner(System.in);
    }
     
    // 기능 : 저장, 검색, 삭제
    
    // 저장 기능
    // 사용자로부터 데이터를 받아서 -> 
    // 인스턴스 생성 -> 
    // 배열에 생성된 인스턴스 참조값을 저장 : 저장 index는 cnt를 이용, 
    // 저장 후에는 cnt를 증가. cnt++
    
    void insertMember() { // 사용자로부터 데이터를 받기 때문에 매개변수 x
    	System.out.println("친구의 정보 입력을 시작합니다.");
    	
    	// 이름,전화번호,생일 입력받기
    	System.out.println("이름을 입력하세요. : ");
    	String name = Util.sc.nextLine();
    	System.out.println("전화번호를 입력하세요. : ");
    	String pNum = Util.sc.nextLine();
    	System.out.println("생일을 입력하세요. : ");
    	String bd = Util.sc.nextLine().trim();    // 앞뒤 공백을 지워서 문자 저장
    
    	// 배열에 저장하기 위한 인스턴스의 참조변수 선언
        PhoneInfor infor = null;
        
        // 생일이 입력되었는지 여부에 따라 인스턴스 생성을 다르게 처리한다.
        if(bd!=null && bd.length()>0) { //length는 무조건 0부터 세서 반환
        	infor = new PhoneInfor(name, pNum, bd);
        } else {
        	infor = new PhoneInfor(name,pNum);
        }
    	
        phoneBook[cnt++] = infor;       //phoneBook[0](참조변수) = 0x111;(infor의 주소)
        // cnt++;   // 추가된 정보의 개수를 +1
   	
    }
    
    // 정보 검색
    // 검색하고자 하는 이름을 사용자로부터 받고 -> 매개변수 필요없음
    // 배열의 요소(참조 값 -> 인스턴스 참조) 
    // PhoneInfor.name 변수의 값과 검색 이름을 비교(동등 비교) 
    // 동등하다면 해당 index를 찾을 수 있다.
    // 검색된 index로 정보를 출력
    
    void searchMember() {
    	
    	if(cnt==0) {
    		System.out.println("저장된 데이터가 없습니다. 다시 메뉴로 이동합니다.");
    		return;     
    		// 메서드의 종료. 저장된 데이터가 없으면 아래 메서드가 실행될 필요가 없음.
    	}
    	
    	// 찾고자 하는 이름 받기
    	System.out.println("정보 검색을 시작합니다.");
    	System.out.println("찾을 이름을 입력하세요.");
    	String name = sc.nextLine();
    	
    	// 이름을 요소 index 검색 시작
    	int index = searchIndex(name);   // 배열에는 -1이 있을 수가 없으나, 분기를 위해 -1을 대입
    	
    	// 검색 : index를 찾는다.(반복)
//    	for(int i=0; i<cnt; i++) {
//    		if(phoneBook[i].name.equals(name)) {    //사용자가 입력한 문자와 저장된 문자가 같은지 확인
//    			index=i;
//    			break;
//    		}
//    	}
    	
    	if(index<0) {	
    		System.out.println("찾으시는 이름의 정보가 존재하지 않습니다.");
    	} else {
    		// 정보 출력
    		phoneBook[index].showInfor();
    	}
    	
    }
    
    
    // 이름 문자열을 받아서, -> 매개변수 
    // 배열의 정보와 비교하고  -> 리턴
    // index를 찾아서 반환하는 메서드
    int searchIndex(String name) {
    	int result=-1;
    	
    	// 검색
    	for(int i=0; i<cnt; i++) {
    		if(phoneBook[i].name.equals(name)) {    //사용자가 입력한 문자와 저장된 문자가 같은지 확인
    			result=i;
    			break;
    		}
    	}
    		return result;
    }
    
    
    
    // 정보 삭제
    // 삭제하고자 하는 이름을 사용자로부터 받는다 -> 
    // 배열에서 이름으로 검색해서 index를 찾는다
    // 배열에서 찾은 index의 참조값을 삭제 : 
    // 인스턴스 참조하는 참조변수가 없으면 삭제된다
    // 참조값에 null을 입력하거나 다른 주소값을 입력 ->
    // 이전에 있던 참조값은 없어진다.
    // 삭제 대상의 index부터 왼쪽으로 값을 시프트 처리
    // cnt-1 
    void deleteMember() {
    	if(cnt==0) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
    	System.out.println("정보 삭제를 진행합니다.");
    	System.out.println("삭제하고자 하는 정보의 이름을 입력해 주세요.");
    	String name = sc.nextLine();
    	
    	// 이름을 요소 index 검색 시작
    	int index = searchIndex(name);
    	
    	
    	
    	// int index = -1;   // 배열에는 -1이 있을 수가 없으나, 분기를 위해 -1을 대입
    	
    	// 검색 : index를 찾는다.(반복)
//    	for(int i=0; i<cnt; i++) {
//    		if(phoneBook[i].name.equals(name)) {    //사용자가 입력한 문자와 저장된 문자가 같은지 확인
//    			index=i;
//    			break;
//    		}
//    	}
    	if(index<0) {
    		System.out.println("삭제하고자 하는 정보가 존재하지 않습니다.");
    	} else {
    		// 삭제 처리 : 삭제해야하는 index부터 왼쪽으로 시프트 처리
    		// index=3;
    		// phoneBook[3] = phoneBook[4]
    		// phoneBook[4] = phoneBook[5]
    		for(int i=index; i<cnt-1; i++) {
    			phoneBook[i]=phoneBook[i+1];
    		}
    		cnt--;
    		System.out.println("정보를 삭제했습니다.");
    	}
    }
    		
    	
    	// 전체 정보 출력
    	void displayAll() {
    		if(cnt==0) {
    			System.out.println("등록된 정보가 없습니다.");
    			return;
    		}
    		System.out.println("전체 정보를 출력합니다.("+cnt+")");
		    System.out.println("---------------------");

    		for(int i=0; i<cnt; i++) {
    		    phoneBook[i].showInfor();
    		    System.out.println("---------------------");
    		}
    	}	
	
	
	
}
