package filter;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {



	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("LoginCheckFilter 실행");
		
		
		// 로그인 여부 확인하는 filter
	    HttpServletRequest httpRequest = (HttpServletRequest) request;
	    HttpSession session = httpRequest.getSession();
	    
	    // boolean loginCheck = false;
	    
	    if(session!=null && session.getAttribute("loginInfo")!=null) {
	    	// loginCheck = true;
	    	chain.doFilter(request, response);
	    } else {
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/member/loginForm.jsp");
	    	dispatcher.forward(request, response);
	    }
	    
		
	}
	
	
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	
}
