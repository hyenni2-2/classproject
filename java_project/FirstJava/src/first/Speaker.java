package first;

public class Speaker {

	private int volumeRate; // 볼륨 크기
	
	// 현재 볼륨의 크기를 출력
	void showCurrentState() {  // 다른 패키지에서 호출할 수 있게 public으로
		System.out.println("볼륨의 크기 : " + volumeRate);
	}
	
	public void setVolume(int vol) {             // private멤버를 불러오기 위해 set을 붙임
         volumeRate=vol;
	}
	
	
}
