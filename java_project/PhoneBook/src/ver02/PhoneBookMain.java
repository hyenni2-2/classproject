package ver02;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		// 사용자에게 데이터를 받음
		Scanner s = new Scanner(System.in);
		
		
		 while(true) {
			// 인스턴스 생성을 위해 이름, 전화번호, 생일 데이터 받기
                System.out.println("데이터 저장을 위한 데이터를 입력해주세요.");
				System.out.println("이름을 입력하세요");
				String name = s.nextLine();
				System.out.println("번호를 입력하세요");
				String phoneNumber = s.nextLine();
				System.out.println("생일을 입력하세요");
				String birthday = s.nextLine();
				
				// 인스턴스 생성
				PhoneInfor infor = null;
				
				// trim() -> " 123 ", " 12 3 -> "12 3"
				//   ".trim" -> "12 3"
				
				
				
				// 입력값 없이 enter인 경우 공백 문자열을 반환
				// 문자열의 길이가 0이면 
				// if(birthday.length()==0) {
				if(birthday.trim().isEmpty()) { // length() == 0이면 true를 반환
					infor = new PhoneInfor(name, phoneNumber, null);
				} else {
					infor = new PhoneInfor(name, phoneNumber, birthday);
				}
				

				// 메서드 호출 
				infor.showInfor();
		 }
		
		
		
		
		
		
		

	}

}
