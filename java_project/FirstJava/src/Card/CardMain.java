package Card;

public class CardMain {
	
	static int weight = 5;

	public static void main(String[] args) {
		
		
		System.out.println(Math.PI);
		
	    System.out.println(Math.random());

		// 카드 클래스를 이용한 출력
		
		System.out.println(CardMain.weight); // 5행에서 선언한 변수값 참조
		
		System.out.println("카드의 폭 사이즈 : " + Card.width);

		Card.play();  // 클래스 메서드 호출
		
		Card c1 = new Card("heart",10);  // Card 클래스 참조선언
		Card c2 = new Card();
		
		
		System.out.println("============================");
		System.out.println("카드 1의 정보");
		System.out.println("모양 : " + c1.kind + ", 숫자는 " + c1.number);
		
	
		System.out.println("============================");
		System.out.println("카드 2의 정보");
		System.out.println("모양 : " + c2.kind + ", 숫자는 " + c2.number);
		System.out.println("============================");

		c1.play();   //void play 호출 -> 카드놀이를 합니다가 호출됨(인스턴스 메서드)
		
		
		System.out.println("카드의 폭 사이즈 : " + c1.width); // 이 방식으로도 static 변수 참조가 가능
		System.out.println("카드의 폭 사이즈 : " + c2.width);

		Card.width = 120;
		System.out.println("카드의 폭 사이즈 변경");
		
		System.out.println("카드의 폭 사이즈 : " + c1.width); // 이 방식으로도 static 변수 참조가 가능
		System.out.println("카드의 폭 사이즈 : " + c2.width);
        // 한 번 바꿔버리면 위 둘 다 적용되어 바뀜
		
		
		
		
		
		

	}

}
