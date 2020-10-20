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
	
	
	// 변수 선언
	String name;
	String num;
	String bd;
	int count; //몇 번 입력했는지 확인하는 변수. 인덱스로도 활용할 수 있음.
	
	
	
	
    //	배열을 선언. 100개 저장
//	final PhoneInfor[] users = new PhoneInfor[100];
     Scanner sc = new Scanner(System.in);
	
	// 배열을 선언 - 생성자 이용해서 해보기
	final PhoneInfor[] users;
	
	// 생성자 
	Manager(){     // 이 Manager는 PhoneBookMain2에서의 참조변수 modiInfo 인스턴스에 쓰이는 생성자. 
		this(100);
	}
	
	public Manager(int size){
		users = new PhoneInfor[size]; // 위에 배열 선언한 users에 내용물인 int size를 넣음.
		
	}
	
	
	
	// 기능 삽입 
	// 저장하는 기능 만들기 - 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
	// 계속해서 돌아야 하니까 무한반복문 안에 넣기. -> 그럼 저장하는 부분만 계속해서 도는 거니까 나가는 것도 만들어야한다.
	// 무한반복문은 클래스 안에 만들게 되면 계속 돌아가니까 효용성이 떨어진다. 그러므로 클래스가 아니라 메인메서드에 만들기.
	// 클래스는 기능만 정의하기. 흐름까지 넣어버리면 너무 복잡해져버린다. 
	// 배열을 이용하는 거니까, 입력받은 정보를 배열에 저장시키기.
	
		void saveInfo() { // 매개변수를 넣으면 안된다. 사용자로부터 입력받을 거니까.
			System.out.println("이름을 입력하세요.");
			name = sc.nextLine();
			System.out.println("번호를 입력하세요.");
	        num = sc.nextLine();
	        System.out.println("생일을 입력하세요.");
	        bd = sc.nextLine().trim();    // 공백 없애주는 trim
	        
	        // 생일을 입력했을 때와 입력 안했을 때를 나눠서 만들어 보자
	        PhoneInfor info = null;    // PhoneInfor 타입을 참조하는 변수 선언
	        
	        // 분기하기
	        if(bd!=null && bd.length()>0) { //bd.length는 입력된 문자의 갯수를 말하는 거니까, 무조건 0보다 크게 되어있음.
	        	info = new PhoneInfor(name, num, bd);   // PhoneInfor 클래스에서 불러왔음.
	        } else {
	        	info = new PhoneInfor(name, num);
	        }
	        
	        // 배열에 저장하기(count 사용)
	        users[count] = info;   // users[0] = info의 주소값
	        count++;        //한 번 결과를 넣고 나서 그 후에 저장한 횟수를 +1해준다. 
	        
	}
	
          // 검색 : 이름을 기준으로 데이터를 찾아서 -> equals 
		 // 해당 데이터의 정보를 출력 -> 
		//  배열을 이용하여 배열 index로 검색해서 일치하는게 있는지 확인하기.
		  void searchInfo() { // 매개변수는 사용자로부터 입력받기 
			  
			  if(count==0) {
				  System.out.println("입력된 정보가 없으니 처음으로 돌아갑니다.");
				  return;
			  }
			  
			  System.out.println("검색할 이름을 입력하세요.");
			  String name = sc.nextLine();
			  
			  // index 선언
			  int index = searchIndex(name);
			  
			  if(index<0) {
				  System.out.println("일치하는 결과가 없어요.");
			  } else {
				users[index].showData();
			  }
			  
			  
			  
			  // index를 이용해서 이름 찾기. 반복해서 돌아가면서 찾아야 하니까 for문 넣기
//			  for(int i=0; i<count; i++) {
//				  if(users[i].name.equals(name)) {
//					index=i;                //index에 우리가 찾은 i값을 넣기
//					users[index].showData();
//					break;
//				  } else {
//					  System.out.println("찾는 이름이 없어요!");
//					  return;
//				  }
//				  
//			  }
		  }
		  
		  // 정보 삭제하기
		  // 배열의 index 값 찾는 기능 정의하기
		  // 저장된 값 찾기
	     // 찾아서 반환해야 함
		int searchIndex(String name) {
			 int result=-1;
			 
			 
	    for(int i=0; i<count; i++) {
	    	if(users[i].name.equals(name)) {
	    	result=i;
	    	break;
	    }	 
		 }
	    return result;
		}
		
		  // 배열에 저장된 값을 왼쪽으로 옮기기
		void deleteInfo() {
			if(count==0) {
				System.out.println("저장된 정보가 없어요. 처음으로 돌아갑니다.");
				return;
			}
		
		System.out.println("정보를 삭제합니다.");
		System.out.println("삭제할 이름은? ");
		name = sc.nextLine();
		
		int index=searchIndex(name);
		
		if(index<0) {
			System.out.println("찾는 이름이 없어요. ");
		} else {  // 이름을 찾았을 때
			for(int i=index; i<count-1; i++) {
				index=i;
			    users[i]=users[i+1];
			}
			count--;
			System.out.println("정보를 삭제했어요.");
		}
}
		
		// 지금까지의 데이터 보여주기
		void showAllData() {
			
			if(count==0) {
				System.out.println("저장된 정보가 없어요.");
				return;
			} 
			
			System.out.println("저장된 정보================");
				for(int i=0; i<count; i++) {
					users[i].showData();
				}
			System.out.println("========================");
			}
		
}
