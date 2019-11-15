package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		String path = "index.jsp";
		if(command.equalsIgnoreCase("register")) {
			path = register(request, response);
		}else if(command.equalsIgnoreCase("login")) {
			path = login(request,response);
		}else if(command.equalsIgnoreCase("find")) {
			path = find(request,response);
		}else if(command.equalsIgnoreCase("idCheck")) {
			path = idCheck(request,response);
		}else if(command.equalsIgnoreCase("logout")) {
			path = logout(request,response);
		}else if(command.equalsIgnoreCase("showAll")) {
			path = showAll(request,response);
		}else if(command.equalsIgnoreCase("update")) {
			path = update(request,response);
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}


	private String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO vo = new MemberVO(id, password, name, address);
		
		try {
			MemberDAO.getInstance().updateMember(vo);//
			
			HttpSession session = request.getSession();
			if(session.getAttribute("vo") != null) { //�α��� ���°� ...
				session.setAttribute("vo", vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "update_result.jsp";
	}


	private String showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			ArrayList<MemberVO> list=MemberDAO.getInstance().getAllMember();
			request.setAttribute("list", list);
			return "allView.jsp";
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	private String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		if(session.getAttribute("vo") !=null) {
			session.invalidate(); 
		}
		return "logout.jsp";
	}


	private String idCheck(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		try {
			boolean flag=MemberDAO.getInstance().isExist(id); //true,false
			request.setAttribute("flag", flag);//�� �κ��� �ʿ���.
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return "idcheck.jsp";
	}


	private String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		try {
			MemberVO rvo=MemberDAO.getInstance().findMemberById(id);
			request.setAttribute("vo", rvo);
			
			if(rvo!=null) path = "find_ok.jsp";
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return path;
	}


	private String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		try{
			MemberVO vo=MemberDAO.getInstance().login(id, password);
			if(vo !=null){ //�α��� ����
				HttpSession session = request.getSession();
				session.setAttribute("vo", vo);
				return "login_ok.jsp";
			}else{
				return "login_fail.jsp";
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}


	private String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO vo = new MemberVO(id, password, name, address);
		
		try {
			MemberDAO.getInstance().registerMember(vo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "register_result.jsp";
		
	}

}
