package thread;

public class threadMain {

	public static void main(String[] args) {
		
		// Thread 생성
		ShowThread st1 = new ShowThread("1번 스레드");
		ShowThread st2 = new ShowThread("2번 스레드");
		
		// Runnable 인터페이스 이용한 스레드
		Runnable target = new ShowRunnable();
		Thread st3 = new Thread(target);
		
		// 우선순위 설정 1~10: 기본 5 (무조건 되는 건 아니고 확률을 높여줌)
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		st1.setPriority(Thread.MAX_PRIORITY);
		st2.setPriority(Thread.MIN_PRIORITY);

		
		st1.start();
		st2.start();
		st3.start();
		
//		for(int i=0; i<100; i++) {
//			System.out.println("안녕하세요 메인스레드입니다.");
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} // 100/1000초
//		}
//		System.out.println("메인 스레드가 종료되었습니다.");
	}

}
