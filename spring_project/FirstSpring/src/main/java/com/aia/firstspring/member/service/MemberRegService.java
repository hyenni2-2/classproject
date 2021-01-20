package com.aia.firstspring.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.firstspring.member.dao.MemberDao;
import com.aia.firstspring.member.dao.MemberInterfaceDao;
import com.aia.firstspring.member.dao.MyBatisMemberDao;
import com.aia.firstspring.member.domain.Member;

@Service
public class MemberRegService {

//	@Autowired
//	private MemberDao dao;
	
//	@Autowired
//	private MyBatisMemberDao dao;
	
	private MemberInterfaceDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int insertMember(Member member) {
		
		int result = 0;
		try {
			dao = template.getMapper(MemberInterfaceDao.class); // dao는 매핑 뿐만이 아니라 DB 연결도 해줌.(SqlSessionTemplate이)
		    result = dao.insertMember(member);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
