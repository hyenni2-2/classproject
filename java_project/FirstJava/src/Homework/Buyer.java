package Homework;

public class Buyer {
    int money;
    int myPoint;
    int cnt;       // 
	
    // 생성자로 초기화하기
	public Buyer(int money) {  // 돈을 입력하면 이렇게 처리하기
		this.money = money;
		this.myPoint=0;
	}

	// 구매하는 기능정의
	void Buyer(ProductStudy ps) { // ProductStudy가 각 클래스들의 조상이기 때문에
		
		if(money<0) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		
		money -= ps.price;    //ps 클래스의 가격을 호출하는거니까 앞에 잊지말고 ps. 붙이기
		myPoint += ps.savePoint;
		System.out.println("남은 금액 : " + money);
		System.out.println("적립된 포인트 : " + myPoint);
		
	
	}
	
	// 결과 출력하기
	
	
	
}
