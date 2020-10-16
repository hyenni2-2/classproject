package first;

public class OverridingMain {

	public static void main(String[] args) {
		
		// BaseEnSpeaker bs = new BaseEnSpeaker();
		// bs.showCurrentState();

		// 다형성
		// 조상클래스 타입의 참조변수에 자손 클래스 타입의 인스턴스를 참조할 수 있는 것
		// 참조변수는 해당 타입의 멤버만 사용하겠다라고 선언하는 것과 같음
		Speaker s = new BaseEnSpeaker();
		// 참조변수 s는 volumeRate 변수와 showCurrentState(), setVolume()만 사용하겠다.
		
		//setVolume-Speaker클래스의 멤버.
		s.setVolume(10);
		
		//SetBaseRate-BaseEnSpeaker클래스의 멤버
		// s.setBaseRate(20); //s는 speaker의 참조변수이기 때문에 에러남
		
		//BaseEnSpeaker에서 오버라이딩한 메서드가 호출된다.
		s.showCurrentState();
	}

}
