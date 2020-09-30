package first;

public class OperatorExample {

	public static void main(String[] args) {
		// 예제1
		/*
		int i = 5;
		i++;           //이 시점에서의 i의 값은 5.
		System.out.println(i); // 여기에서는 이미 +1이 된 값이 출력이 됨.

		i=5;
		++i; // 전위에 +가 있기 때문에 i가 (+1)된 값임.
		System.out.println(i); // 결과는 6
		*/
		
		
		/*
		//예제2
		int i = 5;
		int j = 0;
		j = i++;
		System.out.println("j=i++; 실행 후, i = " + i + ", j = " + j);
		// 증가 연산자가 후위에 있기 때문에, i값은 6이 됨(이미 ++가 실행되었음. 그러나, j는 i++의 값을 대입해서 받기 때문에, 5가 됨.
		
		i = 5;
		j = 0;
		j = ++i;
		System.out.println("j=++i; 실행 후, i = " + i + ", j = " + j);
		// 증가 연산자가 전위에 있기 때문에, i값은 j=++i의 단계에서 6이고, j는 그 값을 받기 때문에 6이 됨.
		*/
		
		
		/*
		//예제3
		int i = 5, j = 5;
		System.out.println(i++); // 5임. 후위에 있으니까 아직 실행 안된 거. 이 다음에 실행이됨!!!! 잊지말기.
		System.out.println(++j); // 6. 전위에 있으므로
		System.out.println("i = " + i + ", j = " +j);
		*/
		
		/*
		//예제 4
		int i = -10;
		i = +i;
		System.out.println(i); // *1한 값
		i=-10;
		i=-i;
		System.out.println(i); // *-1한 값
		*/
		
		
		/*
		//예제7
		boolean power = false;
		System.out.println(power); // false값이 출력됨
		power = !power;   // power의 값을 재선언함. power = true가 됨
		System.out.println(power);
		power = !power;   // true값을 부정했으므로 false가 됨
		System.out.println(power);
		*/
		
		/*
		//예제 8
		byte a = 10;
		byte b = 20;
		// byte c = a + b; //byte여도 연산할 때는 자동으로 int로 변환해서 하기 때문에 변수값 byte는 옳지 않음.
		byte c = (byte)(a + b); // 형변환 시켜주기. ()안에 형변환 값 byte를 넣으면 앞의 변수 선언한 byte와 형이 맞아지므로 byte로 계산됨.
		System.out.println(c);
		*/
		
		/*
		//예제 9
		byte a = 10;
		byte b = 20;
		// byte c = (byte)(a * b); // byte 수의 범위가 127까지이기 때문에 -값 출력
		int c = (a * b); // 변수 선언을 int로 변경하면 문제 없음.
		System.out.println(c);
		*/
		
		/*
		//예제 10
		int a = 1000000;
		int b = 2000000;
		long c = (a*b); // 21억을 넘었기 때문에 int값에서 에러 발생
		System.out.println(c);
		*/
		
		/*
		//예제 11
		long a = 1000000 * 1000000L;
		long b = 2000000 * 1000000L;
		System.out.println(a);
		System.out.println(b);
        */
		
		/*
		//예제 13
		//유니코드 이해하기
	    char c1 = 'a';
	    char c2 = c1;   //이시점에서 c2는 c1값인 a를 가지게 됨
	    char c3 = ' ';
	    int i = c1 + 1; // 'a' + 1이니까, a의 유니코드 값인 97 +1 이 되어서 98
	    c3 = (char)(c1 + 1); // 앞에 형변환이 붙었으니까 b가 나올까? 
	    // System.out.println(c3); b출력되네
	    c2++; //후위에 있으니까 이 상태에서는 a값이고 그 다음 단계에서 b가 
	    c2++; //b에서 c가 되었을듯?
	    // System.out.println(c2); // c 맞음
	    System.out.println("i = " + i); 
	    System.out.println("c2 = " + c2);
	    System.out.println("c3 = " + c3);
	    */
		
		/*
		//예제 14
		char c1 = 'a';
		// char c2 = c1 + 1; // 98 출력? 아니네..데이타입이 문자인데 뒤에 위에서 선언한 변라 출력이 안됨. 출력되게 하려면 앞에 형변환을 해야함.
		char c2 = 'a' + 1; //이 때는 앞의 데이터 타입과 일치하기 때문에 계산 가능
		System.out.println(c2);
		*/
		
		
		/*
		//예제 15
		char c = 'a';
		for(int i = 0; i<26; i++) {
			System.out.println(c++); //c만 적을 경우에는 늘어나지 않기 때문에, 그냥c만 26번 출력됨
		}
	    System.out.println();
	    
	    c = 'A';
	    for(int i = 0; i<26; i++) {
	    	System.out.println(c++);
	    }
	    System.out.println();

	    c = '0';
		for(int i = 0; i<10; i++) {
			System.out.println(c++);
		}
		*/
		
		/*
		// 예제 17
	    float pi = 3.141592f;
	    float shortPi = (int)(pi * 1000) / 1000f; //int값으로 바뀌어서 3141이 되었으나 나누는 부분이 실수float형이여서 자동으로 int -> float으로 바뀜. 이유는 실수가 정수형보다 크기 때문이다.
	    System.out.println(shortPi);
		*/
		
		/*
		//예제 18
		float pi = 3.141592f;
        float shortPi = Math.round(pi * 1000) / 1000f; //math.round 메소드는 소숫점 첫째자리에서 반올림하여 int로 변환.
        System.out.println(shortPi);
		*/
		
	   float f = 0.1f;
	   double d = 0.1;
	   double d2 = (double)f;
	   
	   System.out.println("10.0==10.0f ? "+(10.0==10.0f)); //출력됨 
	   System.out.println("0.1==0.1f ? "+(0.1==0.1f)); //출력이 false가 되는 이유는 double 0.1과 float 0.1이 같지 않다.!!! 잊지말기
	   System.out.println("f="+f); //0.1
	   System.out.println("d="+d);
	   System.out.println("d2="+d2); //double형으로 바뀌었기 때문에 소숫점 17번째 자리까지 다 출력됨
	   System.out.println("d==f ? "+(d==f)); //double형과 float형은 다르기 때문에 false
	   System.out.println("d==d2 ? "+(d==d2)); //둘 다 double형이긴한데...선언을 0.1로 해놨기 때문에 d를, false가 아닐까?
	   System.out.println("d2==f ? "+(d2==f)); //소숫점 자리수가 다르기때문에 false (x)
	   // float형을 double형으로으로 바꾸어도 안의 내용물은 똑같음...ㅠㅠ 잊지말자. 값이 다르다는 걸.
	   
	   
	   
	   
	   
		
		
		
	    
	}

}
