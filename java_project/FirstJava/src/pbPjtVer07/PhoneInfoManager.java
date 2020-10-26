package pbPjtVer07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneInfoManager {


	List<PhoneInfo07> pInfo;

	
	Scanner sc = new Scanner(System.in);

		// 생성자로 초기화하기
		public PhoneInfoManager(int input) {
			pInfo = new ArrayList<PhoneInfo07>();
			
		}
		
		// 친구 저장하는 기능
		void saveInfo(PhoneInfo07 p) {
			pInfo.add(p);
		}
		

		
		// 정보 입력받기 - 1: 대학친구, 2: 회사친구
		void saveFriend(int choice) {
	
			System.out.println("친구 정보를 입력합니다.");
	        System.out.println("이름은? ");
	        String name = sc.nextLine();
	        
	        System.out.println("번호는? ");
	        String num=sc.nextLine();
	        
	        System.out.println("주소는? ");
            String addr = sc.nextLine();
	        
	        System.out.println("메일은? ");
			String email = sc.nextLine();
			
			if(choice==1) {
				// 대학친구 정보를 받고 -> 인스턴스 생성 -> 배열에 저장
				System.out.println("전공은? ");
				String major=sc.nextLine();
				System.out.println("학년은? ");
				String year = sc.nextLine();
				saveInfo(new PhoneUnivInfor(name, num, addr, email, major, year));
			}  else if(choice==2) {
				// 회사 친구 정보 받고 -> 인스턴스 생성 -> 배열에 저장
				System.out.println("회사는? " );
				String company=sc.nextLine();
				saveInfo(new PhoneCompanyInfo(name, num, addr, email, company));
			}	else if(choice==3) {
				System.out.println("동호회는? ");
				String cafe = sc.nextLine();
				saveInfo(new PhoneCafeInfor(name, num, addr, email, cafe));
		
			} else if(choice==4) {
				System.out.println("가족 수는? ");
				int family = sc.nextInt();
				saveInfo(new PhoneFamilyInfor(name, num, addr, email, family));
			}
			System.out.println("입력 완료!");
		}
		
		
		// 배열 index를 검색하는 메서드
		// for문으로 찾기
		private int searchIndex(String name) {
			int index=-1;    // index에 -1이 오는 건 말이 안되니까, 저장된 값이 없다는 걸 처음에 선언하고 시작.
			
		for(int i=0; i<pInfo.size(); i++) {
			if(pInfo.get(i).getName().equals(name)) {
				index=i;
			}
		}
		return index;	
			
		}
		
		
		
		
		
		// 검색하는 메서드 
		// index로 비교하기.
		// 찾을 이름 입력받기
		
		void searchInfo() {
			if(pInfo.size()==0) {
				System.out.println("저장된 이름이 없어요. 메뉴로 돌아갑니다.");
				return;
			} 
			System.out.println("찾을 이름을 입력하세요.");
			String search = sc.nextLine();
			
			int index = searchIndex(search);
			
			if(index<0) {
				System.out.println("찾는 이름이 없어요. 다시 돌아갑니다.");
			} else {
				System.out.println("검색 결과는====================");
				pInfo.get(index).showInfo();
				System.out.println("============================");
			}
		

		}
		
		
		
			
		// 정보 삭제하는 메서드
		// 배열 값을 왼쪽으로 시프트하게 되면 배열 값 삭제 
		void deleteInfo() {
			System.out.println("삭제하고 싶은 이름을 입력하세요.");
			String name=sc.nextLine();
			
			// 배열 인덱스값찾기로 입력한 이름이랑 비교해보기
			int result=searchIndex(name);   // searchIndex 돌린 결과(index번지를 result에 대입)
			
			if(result<0) {
				System.out.println("입력한 결과가 없어요. 다시 돌아갑니다.");
				return;
			} else {    // 입력한 결과와 일치하는 것이 있을 경우
				pInfo.remove(result);
				System.out.println("해당 이름을 삭제했습니다.");
			}
			
			
		}
		
		
		
		
		

		// 전체 정보 출력하는 메서드
		public void showAllInfo() {
			if(pInfo.size()==0) {
				System.out.println("저장된 정보가 없어요. 다시 돌아갑니다.");
			} else {
			System.out.println("전체 정보 출력!================");
			for(int i=0; i<pInfo.size(); i++) {
				pInfo.get(i).showInfo();
			System.out.println("===========================");
			}
			}
		}
			
		public void showAllSimple() {
			if(pInfo.size()==0) {
				System.out.println("저장된 정보가 없어요. 다시 돌아갑니다.");
			} else {
			System.out.println("기본 정보 출력!================");
			for(int i=0; i<pInfo.size(); i++) {
				pInfo.get(i).showBasicInfo();
			System.out.println("===========================");
			}
		
		
			}
		}
		
	}
