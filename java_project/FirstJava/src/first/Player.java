package first;

public abstract class Player {
	
	// 추상클래스 : 클래스의 멤버 메서드 중 하나라도 추상 메서드를 가지면 추상 클래스가 된다.
	// 추상 메서드 : 
	// 구현하는{} 구현부가 없는 메서드, 
	// 메서드 정의부에  abstract 키워드를 써준다. 
	// 문자 마지막에는 ;으로 종료
	abstract void play(int num);
	abstract void stop();
}


abstract class VideoPlayer extends Player{
	 // 추상클래스를 상속해서 추상메터 ㅡplay,stop
	 // ViedoPlayer 클래스도 추상클래스이다.
	
	// 추상클래스(상위 클래스)의 vold play(int num) 메소드를 오버라이티 : 구현하다
//class AudioPlayer extends Player{
//	
//	void play(int num) {
//		
//	}
//}   void stop(){
//	
//}
}
