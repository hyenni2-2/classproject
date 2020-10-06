package fruit;

public class FruitSeller {
	
	// 클래스에는 변수와 메서드를 정의
	// 성격이 비슷한 변수와 메서드를 정의한다. 
	
	//변수 : 인스턴스 변수라고도 표현, 멤버 변수라고도 함.
	// int applePrice = 1000;      // 사과의 가격
	final int APPLE_PRICE = 1000; //사과의 가격, 변경 불가하도록 상수 선언
	int numOfApple = 20;         // 사과의 보유 갯수
	int myMoney = 0;            //  수익 금액
	
	// 기능 : 판매, 정산 결과를 출력하는 기능.
	// 판매 메서드 : 돈을 받고 -> 
	//           반환하는 사과의 개수(리턴), 
	//           수익금은 증가, 
	//           보유한 사과의 개수가 감소 ->
	//           사과의 개수를 반환
	
	int saleApple(int money) { // 받는 돈이 매개변수가 됨, 호출할 때 들어가는 값이기 때문에 초기화x
		int num = 0;          // 반환할 사과의 개수, 지역 변수는 반드시 초기화해야함
		
		//반환할 사과의 개수를 구한다. 
		num = (money/APPLE_PRICE);             // (받은돈/사과의 가격)
		//수익금 증가
		myMoney = myMoney + money; 
		//보유한 사과의 개수가 감소
		numOfApple = numOfApple - num;
		
		return num;
		
	}
	
	// 수익에 대한 정산 출력(메서드)
	// 정산 출력 : 보유한 사과의 개수를 출력, 보유한 금액 출력
	// 반환 타입이 없기 때문에 void 사용, 
	// 받는 데이터가 없으므로 매개변수는 정의하지 않음.
	void showSaleResult() {
		System.out.println("현재 보유한 사과의 개수 : " + numOfApple);
		System.out.println("판매 수익 금액 : " + myMoney);
	}


}
