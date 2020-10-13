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
		
		
		// 문제 2. 다음 형태로 주민번호를 담고 있는 String 인스턴스를 하나 생성
        // String str = “990929-1010123”
		//이 문자열을 이용하여 중간에 삽입된 – 를 뺀 String 인스턴스를 생성.
	
		str = "990929-1010123";
		StringBuilder sb1 = new StringBuilder("990929");
		sb1.append(1010123);
		System.out.println(sb1);
		
		

	}

}
