<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>

<%@page import="member.dao.MemberDao"%>
<%@page import="jdbc.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.Member"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
   int result = 0;

// DAO 객체의 insert 메소드로 member참조변수 전달, Connection 객체의 참조변수 전달
Connection conn = ConnectionProvider.getConnection();

// MemberDao dao = new MemberDao();
MemberDao dao = MemberDao.getInstance();

if (conn != null) {

   System.out.println("OK1");

   // 폼의 입력한 사용자 입력 데이터의 한글 처리
   //request.setCharacterEncoding("utf-8");

   String userId = null;
   String pw = null;
   String userName = null;
   String userPhoto = null;
   String dir = request.getSession().getServletContext().getRealPath("/upload/member");

   
   // fileUpload 라이브러리를 이용해서 DB에 입력할 데이터를 받아와야 한다.   
   System.out.println(request);

   boolean isMultipart = ServletFileUpload.isMultipartContent(request);
   
   System.out.println(isMultipart);
   
   if (isMultipart){

      System.out.println("OK2");

      DiskFileItemFactory factory = new DiskFileItemFactory();
      ServletFileUpload upload = new ServletFileUpload(factory);

      List<FileItem> items = upload.parseRequest(request);
      Iterator<FileItem> itr = items.iterator();

      while (itr.hasNext()) {

   System.out.println("OK3");

   FileItem item = itr.next();

   // type=file일때와 아닐때 구별 > 각각 필드의 값을 추출
   if (item.isFormField()) { // 일반
      String fName = item.getFieldName();
      if (fName.equals("userid")) {
         userId = item.getString("UTF-8");
      }
      if (fName.equals("pw")) {
         pw = item.getString("UTF-8");
      }
      if (fName.equals("username")) {
         userName = item.getString("UTF-8");
      }
   } else { // 파일 
      if (item.getFieldName().equals("userPhoto") && !item.getName().isEmpty() && item.getSize() > 0) {

         // 경로 저장하는 File 객체 생성
         File saveFilePath = new File(dir);
         // 폴더가 존재하는지 여부
         if (saveFilePath.exists() || saveFilePath.isDirectory()) {
            saveFilePath.mkdir();
         }
         // 새로운 파일 이름 : 중복하는 파일 이름이 있으면 덮어쓴다.
         String newFileName = System.nanoTime() + ".";// + item.getName().split(".")[1];

         item.write(new File(saveFilePath, newFileName));

         userPhoto = newFileName;
      }
   }
      }

      Member member = new Member();
      member.setUserId(userId);
      member.setPassword(pw);
      member.setUserName(userName);
      member.setUserPhoto(userPhoto);

      System.out.println(member);

      try {
   // DB에 데이터 저장
   result = dao.insertMember(conn, member);

      } catch (Exception e) {
   File delFile = new File(dir, userPhoto);
   if (delFile.exists()) {
      delFile.delete();
   }

      }
   } else{
      System.out.println("NO");
   }

}

request.setAttribute("result", result);
%>
<jsp:forward page="memberRegView.jsp" />










