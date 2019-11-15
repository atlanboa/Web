package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;


@WebServlet("/ShowAllServlet")
public class ShowAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowAllServlet() {

    }

    ArrayList<MemberVO> list = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			list = MemberDAO.getInstance().showAllMember();
		}catch (Exception e) {
			System.out.println(e);
		}
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("showAllMember.jsp").forward(request, response);
	}

}
