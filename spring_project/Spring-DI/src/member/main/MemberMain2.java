package member.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import member.dao.Dao;
import member.service.MemberInfoService;
import member.service.MemberRegService;

public class MemberMain2 {

	public static void main(String[] args) {
		
		// 1. Spring 컨테이너 생성 -> bean 정의한 xml 경로 넣기
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx5.xml");
		
	    Dao dao1 = ctx.getBean("memberDao", Dao.class);
	    Dao dao2 = ctx.getBean("memberDao", Dao.class);
	    
	    System.out.println("dao1==dao2 -> " + (dao1==dao2)); // true
		
		// 2. MemberRegSerivce 객체가 필요 -> prototype이라 매번 새로운 객체를 반환하기 때문에 false가 나옴
		MemberRegService regService1 = ctx.getBean("memberRegService", MemberRegService.class);
		MemberRegService regService2 = ctx.getBean("memberRegService", MemberRegService.class);
		
		System.out.println("regService1==regService2 -> "+(regService1==regService2));
		
		// 4. MemberInfoService 객체 -> singleton으로 등록함
		MemberInfoService infoService1 = ctx.getBean("memberInfoService", MemberInfoService.class);
		MemberInfoService infoService2 = ctx.getBean("memberInfoService", MemberInfoService.class);

	    System.out.println("infoService1==infoService2 -> "+(infoService1==infoService2));
		
		
	}

}
