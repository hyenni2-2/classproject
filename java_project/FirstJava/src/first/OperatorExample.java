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
		
		//예제 11
		long a = 1000000 * 1000000L;
		long b = 2000000 * 1000000L;
		System.out.println(a);
		System.out.println(b);

		
		
	}

}
