package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 폼값 받아서...id, password
		 * 2. 비지니스 로직 호출... 리턴값 받아서
		 * 3. 세션을 하나 받아온다
		 * 4. 바인딩... 세션에
		 * 5. 페이지 이동..
		 */
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		try {
			MemberVO rvo = MemberDAO.getInstance().login(id, password);
			
			//중요!!
			//클라이언트가 요청하면 그 때 서버상에서 자동적으로 생성... 우리는 그냥 받아쓰면 된다.
			HttpSession session = request.getSession();
			
			System.out.println("JSESSIONID :: " + session.getId());
			
			session.setAttribute("vo", rvo);
			request.getRequestDispatcher("result_login.jsp").forward(request, response);
		}catch (Exception e) {

		}
		
	}

}
