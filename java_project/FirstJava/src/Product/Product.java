package Product;

public class Product {

	int price;
	int bonusPoint;
	
	// 생성자 만들기 (shift+alt+s하고 generate Constructor using field 선택)
	public Product(int price) {
		// super(); object 클래스의 Product이기 때문에 슈퍼 필요없음. 
		this.price = price;
		this.bonusPoint = (int)(price*0.1f);
	}

	@Override  // toString을 오버라이딩 하는 목적 : 제대로 값이 나오는지 확인하기 위해. 꼭 이렇게 쓰지 않아도 되지만, 일일이 다 쳐서 출력하는 번거로움을 줄일 수 있다. 
	public String toString() {
		return "Product [price=" + price + ", bonusPoint=" + bonusPoint + "]";
	}

	

	
	
	
	
	
}
