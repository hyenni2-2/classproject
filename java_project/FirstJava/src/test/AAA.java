package test;

public class AAA {

	// public AAA(){}   디폴트 생성자
	
	public int num;            // 아무것도 없을 경우 default가 되는데, 다른 패키지에서는 동작하지 않음.
	
	public static int n = 100;
	
	// static AAA a = new AAA();
	
	public AAA(){     // default로 정의했기 때문에 다른 패키지에서는 보이지 않음
		
	}
	
	// setter 
	public void setNum(int num) {
		this.num=num;
	}
	
	// getter
	public int getNum() {
		return num;
	}
	
	
	
	
	
}
