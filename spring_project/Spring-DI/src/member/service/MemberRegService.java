package member.service;

import member.dao.Dao;

public class MemberRegService implements MemberService {

	// Dao dao = new MemberDao(); // 의존성이 높은 코드
	
	private Dao dao; // 주입받아야하는 참조변수
	
	// 생성자를 통해서 Dao타입의 인스턴스를 주입받는다.
	// Dao dao = new MemberDao(); -> 다형성.
	public MemberRegService(Dao dao) {
		this.dao = dao;
	}
	
	@Override
	public Object process() {
		System.out.println("MemberRegService 실행");
		
		dao.insert();
		
		return null;
	}
	
	

}
