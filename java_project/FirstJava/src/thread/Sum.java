package thread;

public class Sum {
	
	int num;
	
	Sum(){
		num=0;
	}
	
	synchronized void addNum(int n) {  // 동기화 생성
		num+=n;
	}
	
	int getNum() {
		return num;
	}

}
