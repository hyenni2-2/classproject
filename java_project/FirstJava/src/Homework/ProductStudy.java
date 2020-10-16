package Homework;

public class ProductStudy {
	// 영수증 기능으로 만들어 보기. 
	// 물건의 종류 : 과자, 콜라, 젤리
	// 출력해야 하는 것 : 쓴 금액 , 적립된 포인트, 얼마가 남았는지, 몇 개를 샀는지? 
	// 기본 개념 : 조상 클래스인 ProductStudy부터 만든 후, 후손 클래스들 만들어스 기능 정의하기. 
	// 조상 클래스인 ProductStudy에서는 간단하게 생성자들만 넣어놔도 됨.
	
	int price;         // 금액
	int savePoint;     // 적립 포인트
	
	// 생성자
	public ProductStudy(int price) { //가격 넣기
		this.price=price;
		this.savePoint=price/10;
	}
	
	

}
