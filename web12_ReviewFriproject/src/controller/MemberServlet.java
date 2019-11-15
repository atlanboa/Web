package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.MemberDAOImpl;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기에 작성...
		String command = request.getParameter("command");
		if(command.equalsIgnoreCase("addMember")) {
			addMember(request, response);
		}else if(command.equalsIgnoreCase("login")) {
			login(request, response);
		}else if(command.equalsIgnoreCase("logout")) {
			logout(request, response);
		}
	}


	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null) {
			session.invalidate();
		}
		response.sendRedirect("index.jsp");
	}


	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String path = "Error.jsp";
		try {
			if(MemberDAOImpl.getInstance().loginCheck(user, pass)) { //로그인 성공
				HttpSession session = request.getSession();
				
				session.setAttribute("user", user);
				session.setAttribute("msg", "정상적으로 로그인 되었습니다.");
			}else { //로그인 실패
				request.setAttribute("msg", "아이디 또는 비밀번호가 잘못되었습니다.");
			}
			path="index.jsp";
		}catch (Exception e) {
			System.out.println(e);
			request.setAttribute("msg", "로그인 실패~~~!");
		}
		request.getRequestDispatcher(path).forward(request, response);
		
	}


	private void addMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");
		String name = request.getParameter("NAME");
		String nickName = request.getParameter("NICKNAME");
		String email = request.getParameter("EMAIL");
		String homePage = request.getParameter("HOMEPAGE");
		String address = request.getParameter("ADDRESS");
		String[] hobby = request.getParameterValues("HOBBY");
		
		String path = "Error.jsp";
		Member pvo = new Member(id, pw, name, nickName, email, homePage, address, hobby);
	
		try {
			MemberDAOImpl.getInstance().add(pvo);
			request.setAttribute("mvo", pvo);
			path = "member/member_result.jsp";
		}catch (Exception e) {
			System.out.println(e);	
			request.setAttribute("msg", "회원 저장에 실패하였습니다");
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
}
