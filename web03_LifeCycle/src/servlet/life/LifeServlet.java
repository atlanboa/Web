package servlet.life;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet과 WAS 실행되는 메카니즘 순서
 * 1. 서버가동하자마자
 * 	  web.xml을 읽어들인다.
 * 2. servlet.name에 등록된 이름으로 서블릿 객체를 하나 생성...
 *    생성자 호출.. by container
 * 3. ServletConfig가 생성
 * 4. init() 호출
 * -------------------Ready-On 상태(단 1번만 수행)-------------------
 * 5. 클라이언트가 요청하면
 *    Thread, HttpServletRequest, HttpServletResponse가 생성
 * 6. service() ---> doGet() 혹은 doPost()가 재호출 --> Request, Response 인자값
 * 7. doGet() 혹은 doPost()수행... 응답이 완료
 * -------------------5,6,7 반응 요청시 매번 반복---------------------
 * 8. destroy() 호출
 * 9. 서블릿 인스턴스가 Death
 * 
 */
public class LifeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	private String path = "c:\\filestore\\life\\cycle.txt";
	public LifeServlet() {
		System.out.println("1. 서블릿 인스턴스 생성.....");
	}
	
	//파일에 저장된 카운트 값을 다시 서블릿이 가동될 때 읽어온다
	@Override
	public void init() throws ServletException {
		System.out.println("1. init 호출......");
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str = br.readLine();
			count = Integer.parseInt(str);//읽어들인 카운트 값을 필드에 저장..
			System.out.println("init() 에서 읽어들인 카운트 값:: " + count);
			br.close();
		}catch (Exception e) {
		}
	}
	@Override
	public void destroy() {
		System.out.println("1. destroy 호출.......");
		File f = new File(path);
		f.getParentFile().mkdirs();
		try {
			PrintWriter pw = new PrintWriter(f);
			pw.println(count);
			pw.close();
			System.out.println(path+" COUNT값:: "+ count +" 파일에 저장됨..");
		}catch (Exception e) {
						
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		System.out.println("doGet()...Call....");
		
		out.println("<html><body bgcolor='orange'>");
		out.println("<h2>Count :: </h2>" + ++count);
		out.println("</body></html>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
