package first;

public class BaseEnSpeaker extends Speaker {
	
	private int baseRate;
	
	public void setBaseRate(int base) {
		baseRate = base;
	}

	// 오버라이딩 : 
	// 상속관계에서 상속받은 메서드를 선언부는 동일하게, 처리부는 재구성하는 것
	@Override // 어노테이션 : 자바의 키워드는 아니다. 주석도 아니다. 추가적인 의미를 부여한다.
	void showCurrentState() {    // 접근 제어자를 부모클래스보다 좁은 범위로 설정하게 되면 오류가 생긴다. 
		super.showCurrentState();
		System.out.println("베이스의 크기 : " + baseRate);
	}
	
	
	
}
