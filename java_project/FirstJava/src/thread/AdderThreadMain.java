package thread;

public class AdderThreadMain {

	public static void main(String[] args) {

		AdderThread at1 = new AdderThread(1, 51);
		AdderThread at2 = new AdderThread(51, 101);
		
		// 스레드 생성
		Thread t1 = new Thread(at1);
		Thread t2 = new Thread(at2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();    // t1 스레드가 종료될 때까지  다른 스레드는 멈춘 상태
			t2.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
//		try {
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("1부터 10000까지의 합은 : " + (at1.getNum()+at2.getNum()));
		
	}

}
