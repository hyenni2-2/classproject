package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetingCommand extends Command {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		// 사용자의 요청을 처리, 응답에 필요한 데이터를 request 속성에 저장, 응답에 필요한 설정(response처리) 
		// 이 요청의 응답 처리를 하기 위한 view 페이지 경로를 반환
		// String viewPage = null;
		
		// 사용자 요청 처리
	    String result = "웰컴. 요청한 경로는 " + request.getRequestURI();
	    
	    // request 속성에 결과를 저장
	    request.setAttribute("result", result);
	    
		
		return "/view/greeting.jsp";
	}



}
