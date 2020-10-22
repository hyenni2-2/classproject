package basic;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {

		String strData = "fun|인|fun@gmail.com|서울|?";
        StringTokenizer st = new StringTokenizer(strData, "|", false);
        
        while(st.hasMoreTokens()) {
        	System.out.println(st.nextToken());
        }
        
        System.out.println("--------------------------");
        String pNum = "Tel 82-10-9999-7777 son";
        StringTokenizer st1 = new StringTokenizer(pNum);  // 이렇게만 해놓으면 엔터 들어간 부분이 개행됨
        
        while(st1.hasMoreTokens()) {
        	System.out.println(st1.nextToken());
        }
        
        System.out.println("--------------------------");

        
        StringTokenizer st2 = new StringTokenizer(pNum, " -");    // 구분자 "-" " "
        
        while(st2.hasMoreTokens()) {
        	System.out.println(st2.nextToken());
        }
        
        System.out.println("--------------------------");

        StringTokenizer st3 = new StringTokenizer(pNum, "- ", false);
        
        while(st3.hasMoreTokens()) {
        	System.out.println(st3.nextToken());
        }
        
	}

}
