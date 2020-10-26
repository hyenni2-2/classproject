package pbPjtVer07;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class pInfoSerializable  {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException,EOFException {
//		직렬화를 이용해서 데이터를 저장하고, 프로그램 재 실행시 저장된 데이터를 로드해서 사용하도록 처리하자.

		// 인스턴스를 저장할 스트림 생성
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("PhoneInfo07.txt"));
		
		// 인스턴스를 저장
		out.writeObject(new PhoneInfo07("최혜인","010-1111-2222","서울","iii@gmail.com"));
		// 추상클래스여서 인스턴스화 불가. 추상클래스 해제
		out.writeObject(new PhoneInfo07("진효선","010-2222-3333","서울","ddd@gmail.com"));
		out.writeObject(new PhoneInfo07("김수한무","010-3333-2222","대전","aaa@gmail.com"));
		out.writeObject(new String("전화번호를 저장하는 새로운 방법"));
		out.writeObject(new PhoneInfo07("삼천갑자","010-2133-4422","부산","dsa@gmail.com"));

		System.out.println("저장 완료!");
		out.close();
		
		//인스턴스 복원하기
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("PhoneInfo07.txt"));
		
		// 입력된 정보를 차례대로 읽어내려가기
		PhoneInfo07 p1=(PhoneInfo07) in.readObject();
		Object o2=in.readObject();
		PhoneInfo07 p2=null;
		
		if(o2 instanceof PhoneInfo07) {
			p2 = (PhoneInfo07) in.readObject();
		}
		
//		PhoneInfo07 p3 = (PhoneInfo07)in.readObject();
		String str = (String) in.readObject();
	    // 스트링은 이 안에서 만들어졌으므로 앞의 타입이 String임
		
	    Object o4 = in.readObject();
	    PhoneInfo07 p4=null;
	    
	    if(o4 instanceof PhoneInfo07) {
	    	p4=(PhoneInfo07)in.readObject();
	    }
	    System.out.println("출력 완료");
	    in.close();
	    
	    p1.showInfo();
	    p2.showInfo();
//	    p3.showInfo();
	    System.out.println(str);
	    p4.showInfo();

		

		


	}

}
