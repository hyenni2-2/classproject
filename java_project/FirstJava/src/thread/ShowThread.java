package thread;

// 스레드 클래스 정의는 Thread 클래스를 상속해서 정의
public class ShowThread extends Thread {

	String threadName;
	
	public ShowThread(String name) {
		threadName = name;
	}
	
	@Override
	public void run() {
		// 새로운 실행 환경에서 처리할 코드를 작성
		for(int i=0; i<100; i++) {
			System.out.println("안녕하세요. " + threadName + "입니다.");
			try {// Object 클래스의 sleep(ms)메서드 : 현재 스레드를 1/1000초 간격으로 멈춤
	             // 100/1000초 
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
		System.out.println(threadName+"가 종료되었습니다.");
	}
	
	
}
