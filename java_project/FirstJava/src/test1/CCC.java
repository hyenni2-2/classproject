package test1;

import test.AAA;

public class CCC {

	public static void main(String[] args) {
		
		AAA.n = 0;
		
		AAA a = new AAA(); // 다른 패키지에 있기 때문에 import 필요
		
		a.num = 10;      //   다른 패키지에 있어서 default로는 동작X
		

	}

}
