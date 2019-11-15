package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetCookieTest")
public class SetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetCookieTest() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 쿠키 생성
		Cookie c1 = new Cookie("id", "ssafy");
		Cookie c2 = new Cookie("today", "0919");
		
		//2. 쿠키 유효시간 설정
		c1.setMaxAge(24*60*60); //하루로 지정...
		
		//3. 브라우저로 전송
		
		response.addCookie(c1);
		response.addCookie(c2);
		
		PrintWriter out = response.getWriter();
		out.println("<a href=GetCookieTest>GetCookieTest.....Click!!!");
		
	}

}
