package first;

public class OperatorChapter2 {

	public static void main(String[] args) {
		/*
		int x = 2;
		int y = 5;
		char c = 'A'; //'A'의 문자 코드는 65
		System.out.println(y += 10 - x++); // 15 - 2 = 13
        System.out.println(x+=2); // 3 + 2 = 5
        System.out.println(!('A'<=c && c<='Z')); // ('A'>c || c>'Z') = false
        System.out.println('C'-c); // 'C' - 'A' 이므로 67-65가 되어서 2
        System.out.println('5'-'0'); //int로 변환되어 계산되므로 5-0이라 5
        System.out.println(c+1); //'A'+1 이므로 66
        System.out.println(++c); // 전위이므로 66=B
        System.out.println(c++); // 후위이므로 그 다음 참조할 때 값이 +되지만, 위에서 c가 B가 되었으므로 B
        System.out.println(c); // 위에서 후위를 썼기 때문에 +1해서 C
        */
		
		/*
		//2번
		int numOfApples = 145; //사과의 개수
		int sizeOfBucket = 10; // 바구니의 크기(바구니에 담을 수 있는 사과 갯수
		int numOfBucket = (numOfApples%sizeOfBucket==0)?(numOfApples/sizeOfBucket):((numOfApples/sizeOfBucket)+1);     // 모든 사과를 담는데 필요한 바구니의 수
		System.out.println("필요한 바구니의 수 : " + numOfBucket);
		*/
		
		
		/*
		//3번
		int num = 0;
		String result = (num>0?"양수":(num==0)?"0":"양수");
		System.out.println(result);
		
		﻿
		int num = 0;
		String result = (num>0?"양수":"음수");
		result = (num==0?"0":"양수");
		System.out.println(result);
        */
		
		
		/*
		// 4번
		// 백의 자리 이하를 버리는 코드
		int num = 456;
		int divNum = Math.round(num/100)*100;
		System.out.println(divNum);
		*/
		
		/*
		//5번
		int num = 53;
		int plusNum = Math.round((num/10)*10)+1;
		System.out.println(plusNum);
		*/
		
		
		/*
		//6번
		int num = 24;
		int num2 = num%10;
		int result = 10-num2;
		System.out.println(result);
		*/
		
		//7번
		// 'C = 5/9 * (F-32)'
		/*
		int fahrenheit = 100;
		float celcius = ((float)(fahrenheit - 32)*5/9);// 37.7778f
		celcius = (int)(celcius * 1000) / 1000f;
		if(celcius>=0.005f) {
			System.out.println("Fahrenheit:"+fahrenheit);
			System.out.println("Celcius:"+(int)((celcius+0.01f)*100)/100f);
		}
		*/
		
		
		/*
		//8번
		byte a = 10;
		byte b = 20;
		int c = a + b;
		System.out.println("c="+c);
		
		char ch = 'A';
        ch = (char)(ch + 2);
        System.out.println("ch = " + ch);
        
        float f = 3/2f;
        System.out.println("f = " + f);
        
        long l = 3000*3000*3000L;
        System.out.println("l = " + l);
        
        float f2 = 0.1f;
        double d = 0.1;
        boolean result = (float)d==f2;
        System.out.println("result = " + result);
		
		*/
		
		/*
		//9번
		char ch = 'z';
		boolean b = (ch >= 'a' && ch <= 'z') || (ch >= 0 && ch <= 9);
		System.out.println(b);
		*/
		
		
		
		// 10번
		char ch = 'A';
		char lowerCase = (char)((ch<ch+32)?(ch+32):ch);
		//lowerCase = (char)((ch<ch+32)?ch:(ch+32));
		System.out.println("ch:" + ch);
		System.out.println("chto lowerCase:"+lowerCase);
		
		
		
		
		
				
		
		
		
		
		
		
	
	
	
	
	}

}
