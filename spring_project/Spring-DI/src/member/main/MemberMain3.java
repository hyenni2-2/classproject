package member.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import member.service.MemberInfoService3;
import member.service.MemberRegService3;

public class MemberMain3 {

	public static void main(String[] args) {
		
		// 1. Spring 컨테이너 생성 -> bean 정의한 xml 경로 넣기
		// GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx6.xml");
		// GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx7.xml");
		// GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx8.xml");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx9.xml");
		
		// 2. MemberRegSerivce 객체가 필요
		MemberRegService3 regServie = ctx.getBean("memberRegService", MemberRegService3.class);
		
		// 3. MemberRegService -> process() 실행
		regServie.process();
		
		// 4. MemberInfoService 객체
		MemberInfoService3 infoService = ctx.getBean("memberInfoService", MemberInfoService3.class);
		
		// 5. MemberInfoServie -> process() 실행
		infoService.process();

	}

}
