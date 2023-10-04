package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditSave
 */
@WebServlet("/EditSave")
public class EditSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  static int gc;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	Simple s4=new Simple();
	
	
		
		response.setContentType("text/html");
		
		PrintWriter out =response.getWriter();
		
		out.println("Hello here you can edit your informations");
		
String ename=request.getParameter("ename");
		
		String email=request.getParameter("email");
		
		String country=request.getParameter("country");
		
		s4.setEname(ename);
		
		s4.setEmail(email);
		
		s4.setEmp_country(country);

int status=0;
try {
	status = MysqlDao.emp(s4);
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
int result=status;

System.out.println(result);
       
if(result>0)
       {
			out.println("Your record is successfully updated");
			
			RequestDispatcher res=request.getRequestDispatcher("ViewServlet");
			
			res.include(request, response);
			
			
		}
		
		
		
		else
		{
			
			
			
			out.println("Sorry your record is not updated...oops!");
		}
	
	
	}

}
