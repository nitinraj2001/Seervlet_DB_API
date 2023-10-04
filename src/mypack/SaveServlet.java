package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		out.println("Welcome from SaveServlet");
		
	String name=request.getParameter("ename");
		
		String email=request.getParameter("email");
		
		
		
		String country=request.getParameter("emp_country");
		
		Simple s = new Simple();
		
		s.setEname(name);
		
		s.setEmail(email);
		
		s.setEmp_country(country);
		
		
		
		
		
		
		int gc=MysqlDao.gc(s);
		
	
		
		if(gc>0)
		{
			
			
			out.println("<br><br>Your record is inserted successfully");
			
			RequestDispatcher res=request.getRequestDispatcher("index.html");
			
			res.include(request, response);
			
		
			
		}
		
		else
		{
			out.println("<br><br>Sorry your record is not inserted....oops");
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		out.close();
		
		
	}

}
