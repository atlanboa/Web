package generic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class GenericServletTest1
 */
@WebServlet("/GenericServletTest1")
public class GenericServletTest1 extends GenericServlet {
	private static final long serialVersionUID = 1L;
      
    public GenericServletTest1() {  }

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		//클라이언트가 요청하면 요청을 처리해서 결과값을 다시 돌려주는 로직을 작성
		PrintWriter out = response.getWriter();
		
		//html 화면에 데이터를 출력하는 기능
		out.println("<html><body><h1>Hello Servlet!!!!!</h1></body></html>");
		
		out.close();
		
		
	}

}

/*
 * 서블릿 실행순서
 * 
 * 1. 서블릿 작성
 * 2. 코드 컴파일....~class(실행파일)
 * 3. 서블릿 실행파일을 서버에 배포
 * 	  wepapps>ContextPath>WEB-INF>classes>generic>servlet>GenericServletTest1.class
 * 
 * 
 
*/