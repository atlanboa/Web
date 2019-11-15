package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RedirectServlet2")
public class RedirectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RedirectServlet2() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 체크박스를 선택하면 해당페이지는 RedirectServlet2페이지 입니다...를 웹 브라우저로 출력
		 * 체크박스를 선택하지 않으면 에러페이지로 이동....redirect...error/error.html
		 */
		String choose = request.getParameter("choose");
		if(choose == null) {
			response.sendRedirect("./error/error.html");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<h2>RedirectServlet2 page...<h2>");
		}
		
	}

}
