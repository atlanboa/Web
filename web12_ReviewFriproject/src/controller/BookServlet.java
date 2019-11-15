package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import model.BookDAOImpl;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/book.do")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		
		if(command.equalsIgnoreCase("registerBook")) {
			registerBook(request, response);
		}else if(command.equalsIgnoreCase("search")) {
			search(request,response);
		}else if(command.equalsIgnoreCase("view")) {
			view(request, response);
		}else if(command.equalsIgnoreCase("delete")) {
			delete(request, response);
		}else if(command.equalsIgnoreCase("addToBook")) {
			response.sendRedirect("book/book.jsp");
		}else if(command.equalsIgnoreCase("updateForm")) {
			updateForm(request, response); 
		}else if(command.equalsIgnoreCase("updateBook")) {
			updateBook(request, response); 
		}else if(command.equalsIgnoreCase("desc")) {
			desc(request, response); 
		}else if(command.equalsIgnoreCase("desc2")) {
			desc2(request, response); 
		}
	}

	private void desc2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		System.out.println(isbn);
		String path="Error.jsp";
		Book b;
		try {
			b = BookDAOImpl.getInstance().search(isbn);
			request.setAttribute("result", b);
			path="book/descResult.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg","오류 발생,  다시 시도해 주세요.");
		
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "Error.jsp";
		String field = request.getParameter("searchField");
		if(field==null) field="";
		
		String text = request.getParameter("searchText");
		if(text == null) text="";
		
		field = field.trim();
		text = text.trim();
		
		List<Book> result = null;

		try {
			switch(field) {
			case "TITLE":
				result = BookDAOImpl.getInstance().searchByTitle(text);
				break;
			case "PUBLISHER":
				result = BookDAOImpl.getInstance().searchByPublisher(text);
				break;
			case "PRICE":
				result = BookDAOImpl.getInstance().searchByPrice(Integer.parseInt(text));
				break;
			default:
				result=BookDAOImpl.getInstance().search();
			}
			
			request.setAttribute("books", result);
			request.setAttribute("field", field);
			request.setAttribute("text", text);
			path = "book/bookList.jsp";
			
		}catch (Exception e) {
			System.out.println(e);
			request.setAttribute("msg", "검색 중 오류가 발생했습니다.");
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void registerBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn1 = request.getParameter("isbn1").trim();
		String isbn2 = request.getParameter("isbn2").trim();
		String isbn3 = request.getParameter("isbn3").trim();
		String isbn = isbn1+"-"+isbn2+"-"+isbn3;
		String title = request.getParameter("title").trim();
		String catalogue = request.getParameter("catalogue").trim();
		String nation = request.getParameter("nation").trim();
		String publishDate = request.getParameter("publishDate").trim();
		String publisher = request.getParameter("publisher").trim();
		String author = request.getParameter("author").trim();
		String p = request.getParameter("price").trim();
		int price = Integer.parseInt(p);
		String currency = request.getParameter("currency").trim();
		String description = request.getParameter("description").trim();
		
		String path = "Error.jsp";
		
		Book pBook = new Book(isbn, title, catalogue, nation, publishDate, publisher, author, price, currency, description);
		
		try {
			BookDAOImpl.getInstance().insertBook(pBook);
			request.setAttribute("bvo", pBook);
			request.setAttribute("msg", "책 정보가 정상적으로 등록되었습니다..");
			path = "result.jsp";
		}catch (Exception e) {
			System.out.println(e);
			request.setAttribute("msg", "책 정보 저장 중 오류 발생..");
		}
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String path="Error.jsp";
		String isbn = request.getParameter("isbn").trim();
		try {
			Book book=BookDAOImpl.getInstance().search(isbn);
			request.setAttribute("b",book );
			path="book/bookView.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg","검색 중 오류가 발생했습니다." );
		}
		request.getRequestDispatcher(path).forward(request, response);
	}//view

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String isbn = request.getParameter("isbn");
		String path="Error.jsp";
		try {
			request.setAttribute("msg", "삭제가 정상적으로 진행되었습니다.");
			BookDAOImpl.getInstance().delete(isbn);
			path = "result.jsp";
		}catch(Exception e) {
			System.out.println(e);
			request.setAttribute("msg", "삭제시 문제가 발생했습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	
	private void desc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String isbn = request.getParameter("isbn");
		System.out.println(isbn);
		String path="Error.jsp";
		Book b;
		try {
			b = BookDAOImpl.getInstance().search(isbn);
			request.setAttribute("result", b);
			
			out.println(b);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg","오류 발생,  다시 시도해 주세요.");
		}
		
	}//
	
		
	private void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String isbn = request.getParameter("isbn");
		String path="Error.jsp";
		Book book;
		try {
			book = BookDAOImpl.getInstance().search(isbn);
			request.setAttribute("b", book);
			path = "book/update.jsp";
		}catch(Exception e) {
			System.out.println(e);
			
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String path = "Error.jsp";
		String isbn = request.getParameter("isbn").trim();
		String title = request.getParameter("title").trim();
		String catalogue = request.getParameter("catalogue").trim();
		String nation = request.getParameter("nation").trim();
		String publishDate = request.getParameter("publishDate").trim();
		String publisher = request.getParameter("publisher").trim();
		String author = request.getParameter("author").trim();
		String price = request.getParameter("price").trim();
		int p = Integer.parseInt(price);		
		String description = request.getParameter("description").trim();
		Book book = new Book(isbn, title, catalogue, nation, publishDate,
		publisher, author, p,  description);
		System.out.println("updateBook..."+book);
		try {
			BookDAOImpl.getInstance().update(book);
			
			HttpSession session=request.getSession();
			if(session.getAttribute("user")!=null)
				session.setAttribute("b", book);
			
			path="book/bookView.jsp";			
		}catch(Exception e) {
			System.out.println(e);
		}
		request.getRequestDispatcher(path).forward(request, response);		
	}
}
