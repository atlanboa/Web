package servlet.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HttpHelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int count;
    
    public HttpHelloServlet() {
    	System.out.println("1. 생성자 호출... 서블릿 생성...");
    }
    @Override
    public void init() throws ServletException {
    	System.out.println("2. init() ... call...");
    }
    @Override
    public void destroy() {
    	System.out.println("destroy...");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기다 작성한다..
		/*
		 * 1.PrintWriter 객체 반환
		 * 2.폼에 입력된 값 받아와서
		 * 3.웹 브라우저로 출력
		 */
		System.out.println("3. service()... call ...");
		
		count++;//
		
		//위치가 중요하다
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("userId");
		out.println("<html><body bgcolor='orange'>");
		out.println("<h2>당신의 이름은" + id + "입니다<br></h2>");
		out.println("<h3><b>Counting :: " + count + "</b></h3>");
		out.println("</body></html>");
	}
}
