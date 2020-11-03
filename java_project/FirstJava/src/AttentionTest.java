import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class AttentionTest {
	
	// 날짜 받기
	Date today=new Date();
	SimpleDateFormat now = new SimpleDateFormat("dd");
	int day = Integer.parseInt(now.format(today));

	// 해시셋 생성
	Set<Integer> set = new HashSet<Integer>();
	
	Scanner sc = new Scanner(System.in);
	
	
	void att() {
		while(true) {
			int choice;
			System.out.println("++++++++++++++++++++++++++++++++");
			System.out.println("매일매일 CHUL-SEOK 체크 이벤트!");
			System.out.println("일주일간 매일 출석을 하시면, ");
			System.out.println("500포인트를 드립니다. ");
			System.out.println("출석하시려면 번호를 눌러주세요.");
			System.out.println("1.출석  2.홈으로 돌아가기");
			System.out.println("++++++++++++++++++++++++++++++++");
			choice=sc.nextInt();
			
			

			
		}
		
	}
	
	
	
	
	
}
