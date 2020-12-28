
<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="join.Join"%>
<%@page import="join.dao.JoinDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="jdbc.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
 // 폼에서 받은 데이터를 처리하는 jsp
 int result = 0;
 // DAO 객체의 insert메서드 이용해서 정보 받기
 Connection conn = ConnectionProvider.getConneciton();
 JoinDao dao = JoinDao.getInstance();
 
 // conn이 null이 아닐 때 객체 저장 -> fileUpload 라이브러리 이용해서 DB에 저장해보기
 if(conn!=null){
	 String joinId = null;
	 String pw = null;
	 String joinName = null;
	 String joinPhoto = null;
	 
	 //fileUpload 이용
	 if(ServletFileUpload.isMultipartContent(request)){
		 
		 DiskFileItemFactory factory = new DiskFileItemFactory();
		 // factory 파일 임시 저장소
		 ServletFileUpload upload = new ServletFileUpload(factory);
		 // 업로드한 파일을 리스트 형식으로 저장
		 List<FileItem> items = upload.parseRequest(request);
		 Iterator<FileItem> itr = items.iterator();
		 
		 while(itr.hasNext()){
			 FileItem item = itr.next();
			 
			 // type=file인지 확인 -> 각 필드의 값을 찾기
			 if(item.isFormField()){ // 일반 필드
				 String fName = item.getFieldName(); // 필드 이름 가져오기
			   
			  // 각 필드 값 가져오기	 
			  if(fName.equals("joinId")){
				 joinId = item.getString("utf-8");
			  }
			  if(fName.equals("pw")){
					 joinId = item.getString("utf-8");
				  }
			  if(fName.equals("joinName")){
					 joinId = item.getString("utf-8");
				  }   
			 
			 } else { // file 필드
				 if(item.getFieldName().equals("joinPhoto") && !item.getName().isEmpty() && item.getSize()>0){
					 // 실제경로 지정
					 String dir = request.getSession().getServletContext().getRealPath("/up/join");
					 
					 // 경로 저장하는 File객체 만들기
					 File saveFilePath = new File(dir);
					 
					 // 폴더 존재여부
					 if(!saveFilePath.exists() || !saveFilePath.isDirectory()){
						 saveFilePath.mkdir(); // dir 만들어주기
					 }
					 // 새파일 이름 : 중복하는 파일명이 있으면 덮어쓰기.
					 String newFileName = System.nanoTime()+"."+item.getName().split("\\.")[1];
					 // 파일을 저장
					 item.write(new File(saveFilePath,newFileName));
					 joinPhoto = newFileName; 
				 }
			 }
		 }
		 
		 // 받은 데이터를 join 클래스에 저장하기
		 Join join = new Join();
		 join.setJoinId(joinId);
		 join.setPw(pw);
		 join.setJoinName(joinName);
		 join.setJoinPhoto(joinPhoto);
		 
		 System.out.println(join);
		 
		 // DB에 데이터 저장하기 : dao.insertJoin(conn, join)의 return값이 int이므로 result에 저장 가능
		 result = dao.insertJoin(conn, join); 
	 }
	 	
 }
 request.setAttribute("result", result);
%>
<!--  view로 페이지 이동 -->
<jsp:forward page="joinView.jsp" />