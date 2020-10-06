package Method;


public class Triangle {
    // 밑변과 높이 정보를 지정. -> 변수 선언
	float low;
	float height;

	
	// 밑변과 높이 정보를 변경, 넓이를 구하는 메서드
	void changeSpec(int changeLow, int changeHeight) { //새롭게 넣는 값이 매개 변수가 됨
		 // 새로운 밑변을 정의
		
		
		// 밑변, 높이의 값은 새롭게 넣은 값
		low = changeLow;
		height = changeHeight;
	}
		
		// 삼각형의 넓이를 계산
	float area() {
        float result = 0.0f;
		result = (low*height)/2;
		return result;	
	}
	


		
	}



	
	
	
	
	
	

