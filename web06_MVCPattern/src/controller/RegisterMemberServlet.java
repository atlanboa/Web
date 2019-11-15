package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;


@WebServlet("/RegisterMemberServlet")
public class RegisterMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterMemberServlet() {

    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.폼 값 입력
		
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		//2. vo ?
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO pvo = new MemberVO(id, password, name, address); 
		try {
			dao.registerMember(pvo);
		}catch (Exception e) {
			System.out.println(e);
		}
			
		//response.sendRedirect("ShowAllServlet");
		request.getRequestDispatcher("ShowAllServlet?name=" + name).forward(request, response);
		
	}

}
