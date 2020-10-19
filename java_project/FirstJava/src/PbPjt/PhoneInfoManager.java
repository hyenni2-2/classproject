package PbPjt;

import java.util.Scanner;

public class PhoneInfoManager {

	private PhoneInfo[] pInfo;  // 정보 저장하는 배열
	private int pInfoCnt;           // 저장된 값을 확인하는 변수, 반복에도 사용 
	
	public int getInfoCnt() {  // cnt를 메인에서  쓰기 위해 getter 사용
		return pInfoCnt;
	}
		
	
	Scanner sc = new Scanner(System.in);

		// 생성자로 초기화하기
		public PhoneInfoManager(int input) {
			pInfo = new PhoneInfo[input];
			pInfoCnt = 0;
		}
		
		// 친구 저장하는 기능
		void saveInfo(PhoneInfo p) {
			pInfo[pInfoCnt++]=p;
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
		
		
		// 검색하는 메서드 
		// index로 비교하기.
		// 찾을 이름 입력받기
		
		void searchInfo() {
			if(pInfoCnt==0) {
				System.out.println("저장된 이름이 없어요. 메뉴로 돌아갑니다.");
				return;
			} 
			System.out.println("찾을 이름을 입력하세요.");
			String search = sc.nextLine();
		
			for(int i=0; i<pInfoCnt; i++) {
				if(pInfo[i].getName().equals(search)) {
					pInfo[i].showInfo();
					break;
				} else {
					System.out.println("존재하지 않아요~");
				}

	        
			}
			
		}
			
			

		// 전체 정보 출력하는 메서드
		void showAllInfo() {
			System.out.println("전체 정보 출력!================");
			for(int i=0; i<pInfoCnt; i++) {
				pInfo[i].showInfo();
			System.out.println("===========================");
			}
		}
			
		void showAllSimple() {
			System.out.println("기본 정보 출력!================");
			for(int i=0; i<pInfoCnt; i++) {
				pInfo[i].showBasicInfo();
			System.out.println("===========================");
			}
		
		
		}
		
	}


