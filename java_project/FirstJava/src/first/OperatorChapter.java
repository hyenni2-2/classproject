package first;

public class OperatorChapter {

	public static void main(String[] args) {
		// 문제4.
		// a= {{(25+5)+(36/4)}-72}*5, b= {{(25x5)+(36-4)}-71}/4, c=(128/4)*2 일 때
		// a>b>c 가 참이면 true 아니면 false를 출력하는 프로그램 작성
	
		int a = (((25+5)+(36/4))-72)*5; //-165
		int b = (((25*5)+(36-4))-71)/4; //21
        int c = (128/4)*2;	     //64
        
       boolean result = true;
       
       if(a>b && b>c) {
    	   System.out.println(result);
       }
       System.out.println(!result);
	    
	    
	}

}
