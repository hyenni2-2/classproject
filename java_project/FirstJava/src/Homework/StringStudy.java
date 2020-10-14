package Homework;

public class StringStudy {

	public static void main(String[] args) {
		// 문제 1. 다음 형태로 String 인스턴스를 생성.
        // String str = “ABCDEFGHIJKLMN”;
		// 이 문자열을 역순으로 출력
		
		String str = "ABCDEFGHIJKLMN";
		for(int i=str.length()-1; i>=0; i--) {
			System.out.print(str.charAt(i));
		}
		
		System.out.println("\n========================");
	    //StringBuffer 클래스 이용
		StringBuffer sb = new StringBuffer(str);
		System.out.println(new String(sb));
		
		sb = sb.reverse();
		System.out.println(sb);
				
		
		System.out.println("\n========================");
		
		
		// 문제 2. 다음 형태로 주민번호를 담고 있는 String 인스턴스를 하나 생성
        // String str = “990929-1010123”
		//이 문자열을 이용하여 중간에 삽입된 – 를 뺀 String 인스턴스를 생성.
	
		str = "990929-1010123";
		StringBuilder sb1 = new StringBuilder("990929");
		sb1.append(1010123);
		System.out.println(sb1);
		
		System.out.println("\n문제 2-for문:========================");
		sb = new StringBuffer(); // 16개 문자 저장
		//String charAt() 이용
		for(int i=0; i<str.length(); i++) {
			// '-'가 아닌 경우, '0'~'9' => 문자열을 추가
			char c = str.charAt(i);
			if(c>='0'&&c<='9') {
				sb.append(c);
			}
		}
		System.out.println(sb);
		
		System.out.println("\n문제 2-replace:========================");

		//String replace()
		String result = str.replace("-", "");
		System.out.println(result);
		
		
		
		
		

	}

}
