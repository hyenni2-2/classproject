package collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		
		// List<E> : 저장 순서 유지(반복문 이용 용이), 중복 저장 허용
		// set은 중복 저장을 허용하지 않음. 때문에 저장할 땐 set, 참조할 때는 list로 for문 쓰는 것도 방법임
		// 인스턴스 저장을 목적으로 하는 클래스
		// List 인스턴스 생성
		// List<Integer> list = new ArrayList();
		List<Integer> list = new ArrayList<Integer>();
		
		// 데이터 저장 : 참조값을 저장
		// add(<T>)
		list.add(new Integer(11));
		list.add(new Integer(22));
		list.add(new Integer(33));
		list.add(55);   // Auto Boxing
		list.add(44);  

		// List의 요소 참조
		// <T> get()
		System.out.println("list의 첫 번째 요소의 값 : " + list.get(0));
	
	   // List 요소의 개수
	   // size() 메서드 사용
		System.out.println("list 요소의 개수 : " + list.size());
		
		// 반복문을 이용한 모든 요소 참조
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("------------------");
		
		for(Integer i : list) {     // for each문
			System.out.println(i);
		}
		
		System.out.println("------------------");

		
		// list 요소의 삭제
		// remove(index)
		// 첫 번째 요소를 삭제
		list.remove(2);
		
		for(int i: list) {
			System.out.println(i);
		}
		
	}

}
