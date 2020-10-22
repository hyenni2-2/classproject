package generic;

public class Apple {

	private int weight;   // 사과의 무게
	
	// 생성자
	Apple(int weight){
		this.weight=weight;
	}
	
	public void showWeight() {
		System.out.println("사과의 무게 : " + weight);
	}
	
}
