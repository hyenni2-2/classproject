package Method;

public class Play { 
       // 아이가 소유하고 있는 구슬의 개수 정보 -> 변수
       // 어린이1 구슬 15개 / 2 구슬 9개
	   int kid1=15;  // 어린이1이 가진 구슬
	   int kid2=9;     // 어린이2가 가진 구슬
	  // 놀이를 통해 구슬을 주고받는 걸 표현 -> 메서드(첫번째)
	  // 어린이 1) 구슬을 받고 ->
	   //        구슬이 증가
	  int takeStone(int giveStone) { //주는 구슬이 매개
	      int num = 0;             // 받은 구슬의 개수
	
	     // 받은 구슬의 개수를 구한다
	     num = kid2-giveStone;  // 어린이2에게서 받을 구슬(어린이2-주는 구슬)
	     // 어린이1 구슬 증가
	     kid1 = kid1 + num;
	     // 어린이2 구슬 감소
	     kid2 = num;
	     
	     return num; // 어린이2의 구슬 개수 반환
	     
	  }

	  void showKid1Result() {
		  System.out.println("어린이 2의 구슬 개수는 :  " + kid1);
	  }
	  
	  void kid2Stone(Play play, int takeStone2) { //어린이 2의 경우, 
		  // 받을 구슬의 갯수를 구한다. 
		  int num = play.takeStone(takeStone2);
		  // 내 구슬 개수를 증가
		  kid2 += num;
		  // 어린이1 구슬 개수를 감소
		  kid1 -= num;
		  
	  }
	  // 현재 상태를 출력
	  void showKid2Result() {
		  System.out.println("어린이 2의 구슬 개수는 : " + kid2);
	  }
	  
	  
	  
	  

	
	
	


		//  구슬치기를 하는 과정에서 구슬을 잃고 얻는다 -> 메서드 (두번째)
		  
		  
		  
	  
	  
	  
	  
	  
}
	     
	     
	      
	   
	
