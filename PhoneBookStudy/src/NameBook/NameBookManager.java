package NameBook;

import java.util.ArrayList;
import java.util.List;

public class NameBookManager implements Util {
	// 사용자로부터 입력받는 변수 정의하기
	String input;

	// 싱글톤으로 정의해보기
	// 인스턴스 생성
	private static NameBookManager manager = new NameBookManager();

	// private생성자
	private NameBookManager() {
	}

	// getInstance 메서드 정의
	public static NameBookManager getInstance() {
		return manager;
	}

	// NameBookInfo타입의 ArrayList 선언 - 저장 개수 100
	List<NameBookInfo> list = new ArrayList<NameBookInfo>(100);

	// 어레이리스트에 정보 저장
	public NameBookManager(List<NameBookInfo> list) {

	}

}
