package generic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericServletTest2 extends GenericServlet{
	public GenericServletTest2(){
		System.out.println("1. 서블릿 생성자 호출....서블릿 생성...");
	}
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("2. service() 호출....클라이언트가 요청할 때...쓰레드 생성");
	
		PrintWriter out = response.getWriter();

		//html 화면에 데이터를 출력하는 기능
		out.println("<html><body><h1>Hello Servlet!!!!!</h1></body></html>");

		out.close();
	}

}
