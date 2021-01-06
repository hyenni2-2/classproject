package member.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import member.service.MemberInfoService;
import member.service.MemberRegService;

public class MemberMain {

	public static void main(String[] args) {
		
		// 1. Spring 컨테이너 생성 -> bean 정의한 xml 경로 넣기
		// GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		// GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx2.xml");
		// GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx3.xml");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx4.xml");
		
		// 2. MemberRegSerivce 객체가 필요
		MemberRegService regServie = ctx.getBean("memberRegService", MemberRegService.class);
		
		// 3. MemberRegService -> process() 실행
		regServie.process();
		
		// 4. MemberInfoService 객체
		MemberInfoService infoService = ctx.getBean("memberInfoService", MemberInfoService.class);
		
		// 5. MemberInfoServie -> process() 실행
		infoService.process();

	}

}
