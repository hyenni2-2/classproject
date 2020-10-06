package Method;

public class TriangleMain {

	public static void main(String[] args) {
		// Triangle 타입의 참조 변수 선언
		Triangle tri = null;
		
		tri = new Triangle();
		tri.changeSpec(3, 2);
		
		float result = tri.area();
		System.out.println(result);
		

	}

}
