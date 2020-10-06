package Method;

public class PlayMain {
	
	public static void main(String[] args) {
		
		// 1차 게임에서 어린이 1은 어린이 2의 구슬 2개를 획득
		  // 2차 게임에서 어린이 2는 어린이 1의 구슬 7개를 획득
		  // 각각 어린이의 보유 구슬 개수 출력하고 프로그램 종료
		Play p = null; // Play의 객체 생성
		p = new Play(); // 객체 생성한 후 객체 주소값 반환
		
		p.takeStone(2);
		
		System.out.println("어린이 1의 구슬 개수는 : ");
		p.showKid1Result();
		
		System.out.println();
		

		
		
		
		
		
		

	}

}
