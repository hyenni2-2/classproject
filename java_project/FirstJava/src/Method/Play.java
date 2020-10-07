package Method;

public class Play { 
       // 아이가 소유하고 있는 구슬의 개수 정보 -> 변수
       // 어린이1 / 2 구슬 
	   int kid1;  // 어린이1이 가진 구슬
	   int kid2; // 어린이2가 가진 구슬
	   int left1; // 어린이 1이 주고 남은 구슬
	    int left2;// 어린이 2가 주고 남은 구슬
	   
	  // 놀이를 통해 구슬을 주고받는 걸 표현 -> 메서드(첫번째)
	  int Stone(int give) { //어린이 1이 주는 구슬과 주고 나서 남은 구슬을 매개변수로 정의
	      int num = 0;             // 주는 구슬의 개수를 num으로 선언하고 정의함
	      // 준 구슬의 개수를 구한다
	     num = give; // num에 give를 대입
	     left1 = (kid1-num); // 어린이1이 num의 구슬을 주고 남은 구슬의 값
	     return left1;
	  }

	  
	  
	  
	  void kid2Stone(Play p, int kid2) { //어린이 2의 경우, 
		  // 받을 구슬의 갯수를 구한다. 
		  int num = p.Stone(kid2);
		  left2 = num;
		  
	  }
	  // 현재 상태를 출력
	  void showKid2Result() {
		  System.out.println("어린이 2의 구슬 개수는 : " + kid2);
	  }



	  
	  
	  
	  

	
	
	


		//  구슬치기를 하는 과정에서 구슬을 잃고 얻는다 -> 메서드 (두번째)
		  
		  
		  
	  
	  
	  
	  
	  
}
	     
	     
	      
	   
	
