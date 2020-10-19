package friend;

public class HighFriend extends Friend {
	
	private String work;      // 고교 동창의 직업

	// 생성자를 통해 인스턴스 변수 초기화
	public HighFriend(String name, String pNum, String addr, String work) {
		super(name, pNum, addr);
		this.work=work;
	}

	@Override
	public void showData() { // Friend f = new HighFriend() -> f.showData() 호출 
		super.showData();    // 원래 조상클래스의 정보 출력
		System.out.println("직업 : " + work);     // 오버라이딩을 통해서 work 추가해서 정보 구현
	}

	@Override
	public void showBasicInfo() {
		System.out.println("이름 : " + getName());  // private을 가지고 올 수 있도록 set get 사용
		System.out.println("전화 : " + getPhoneNumber());
	}

	
	
	
	
	
}
