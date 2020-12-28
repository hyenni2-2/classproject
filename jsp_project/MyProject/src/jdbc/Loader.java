package jdbc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


public class Loader extends HttpServlet {

	// 서블릿 객체 실행 시 한 번만 실행하게 해주는 메소드 -> 사용자의 요청과는 상관없이 무조건 실행되어야 하기 때문에 클래스화 시킨다.
	// 서블릿은 web.xml에 등록하고, 컨테이너가 실행할 때 한 번 서블릿이 실행하도록 설정해준다.
	@Override
	public void init() throws ServletException {
		
		// Mysql의 드라이버를 로드
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버가 로드되었습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드에 실패했습니다.");
			e.printStackTrace();
		}

	}

}
