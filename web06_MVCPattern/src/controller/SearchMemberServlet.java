package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

@WebServlet("/SearchMemberServlet")
public class SearchMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchMemberServlet() {
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 폼 값 받기
		 * 2. DAO 리턴
		 * 3. 비지니스 로직 호출...리턴값 받고 try~catch
		 * 4. 바인딩...request
		 * 5. 페이지 이동..forward..find_result.jsp
		 */
		
		String id = request.getParameter("id");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		try {
			MemberVO rvo = dao.findByIdMember(id);
			request.setAttribute("vo", rvo);
			request.getRequestDispatcher("find_result.jsp").forward(request, response);
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
