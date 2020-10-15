package first;

public class Singleton {
	
	// 싱글톤 패턴 : 인스턴스의 생성을 한번만 하도록 처리하는 코드 작성 스타일
	// 싱글톤이 필요한 클래스 : 기능만 가지고 있는 클래스의 경우, 
	// 여러 개의 인스턴스를 생성할 필요가 X
	// 기능만 가진 클래스의 싱글톤 패턴 사용함.
	
	// 1. 외부 인스턴스에서 인스턴스를 생성하지 못하도록 처리 : 생성자에 private 접근제어자 사용
	private Singleton() {  // 생성자 생성
	}
	
	// 2. 사용할 인스턴스를 클래스 내부에서 생성
	private static Singleton s = new Singleton();  // 인스턴스 변수 s / Singleton.s=null;;
	// static을 붙이면 생성자가 private이여도 쓸 수 있음. 

	// 3. 외부에서 만들어진 참조값을 사용할 수 있도록 참조값을 제공하는 메서드
	public static Singleton getInstance() {
		
		if(s==null) {
			s = new Singleton();	
		}
		
		return s;
	}
	
	
	
	
	
}
