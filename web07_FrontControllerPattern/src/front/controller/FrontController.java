package front.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;


@WebServlet(urlPatterns = {"/front.do"}, loadOnStartup = 1)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontController() {
       System.out.println("1....서블릿 인스턴스 생성....");
    }

	@Override
	public void init() throws ServletException {
		 System.out.println("2....init 메소드 호출....");
	}
	
	@Override
	public void destroy() {
		System.out.println("4...서버가 종료되기 직전에 호출....");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		 System.out.println("3....service()---> doGet() 혹은 doPost() 호출....");
		
		
		//로직은 여기다 작성... 한글처리 할 필요없다.
		//1. command 값 받아온다.
		//MVC Pattern에서 요청 하나당 서블릿 하나로 대응했다면
		//FrontController에서는 서블릿 하나의 메소드로 요청에 응대한다
		String command = request.getParameter("command"); //register, find, findaddr
		String path = "index.html";
		if(command.equals("register")) {
			path = register(request,response);
		}else if(command.equals("find")) {
			path = find(request,response);
		}else if(command.equals("findaddr")) {
			path = findaddr(request,response);
		}else if(command.equals("showAll")){
			path = showAll(request,response);
		}
		
		request.getRequestDispatcher(path).forward(request, response);

	}


	private String showAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String name = request.getParameter("name");
		ArrayList<MemberVO> list = MemberDAO.getInstance().showAllMember();
		request.setAttribute("list", list);
		
		return "showAllMember.jsp";
	}


	private String findaddr(HttpServletRequest request, HttpServletResponse response) {

		return "index.html";
	}


	private String find(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		String id = request.getParameter("id");
		MemberDAO dao = MemberDAO.getInstance();	

		MemberVO rvo = dao.findByIdMember(id);
		if(rvo != null) { //회원 검색 성공
			request.setAttribute("vo", rvo);
			return "find_result.jsp";				
		}else {
			return "find_fail.jsp";
		}

	}


	private String register(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO pvo = new MemberVO(id, password, name, address); 
		dao.registerMember(pvo);
		return "front.do?command=showAll&&name="+name;
	}

}
