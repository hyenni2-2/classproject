package com.aia.op.member.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aia.op.member.dao.MemberDao;
import com.aia.op.member.domain.Member;
import com.aia.op.member.domain.MemberRegRequest;

import net.coobird.thumbnailator.Thumbnailator;

@Service
public class MemberRegService {

	private MemberDao dao;

	@Autowired
	private SqlSessionTemplate template;
	
	@Autowired
	private MailSenderService mailSenderService;

	// 파일을 업로드, db 저장
	@Transactional
	public int memberReg(MemberRegRequest regRequest, HttpServletRequest request) {

		int result = 0;

		File newFile = null;
		String newFileName = null;

		if (regRequest.getUserPhoto()!=null && !regRequest.getUserPhoto().isEmpty()) {
			// 웹 경로
			String uploadPath = "/fileupload/member";
			// 시스템의 실제 경로
			String saveDirPath = request.getSession().getServletContext().getRealPath(uploadPath);
			// 새로운 파일 이름
			newFileName = regRequest.getUserid() + System.currentTimeMillis();
			// 파일 객체 생성
			newFile = new File(saveDirPath, newFileName);
			// 파일 저장
			try {
				regRequest.getUserPhoto().transferTo(newFile);
				
				FileOutputStream thumbnail = new FileOutputStream(new File(saveDirPath, "s_"+newFileName));
				// 썸네일 저장 100x100
				Thumbnailator.createThumbnail(regRequest.getUserPhoto().getInputStream(), thumbnail, 100, 100);
				
				thumbnail.close();
				
				
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Member member = regRequest.toMember();
		
		if(newFileName != null) {
			member.setMemberphoto(newFileName);
		}
		

		try {

			// DB 입력
			dao = template.getMapper(MemberDao.class);
			
			// member_count > memberCount + 1 
			dao.memberCountUpdate();
			
			// 회원 db insert
			result = dao.insertMember(member);
			
			// 메일 발송 : 인증 처리를 하는 페이지 /op/member/verify?id=49&code=난수
			int mailSendCnt = mailSenderService.send(member);
			System.out.println("메일 발송 처리 횟수 : " + mailSendCnt);
			

		} catch (Exception e) {
			e.printStackTrace();
			// 현재 저장한 파일이 있다면? -> 삭제
			if (newFile!=null && newFile.exists()) {
				newFile.delete();
			}
		}
		return result;
	}

	
}
