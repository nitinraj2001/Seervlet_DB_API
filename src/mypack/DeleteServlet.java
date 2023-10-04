package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int status=0;

		response.setContentType("text/html");
		
		PrintWriter out =response.getWriter();
		
		out.println("Hello here you can delete your informations");
		
		String ename=request.getParameter("ename");
		
		try {
			 status=MysqlDao.deleteinfo(ename);
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		if(status>0)
		{
			out.println("Your record is deleted successfully");
			
			response.sendRedirect("ViewServlet");
		}
		
		else
		{
			out.println("Sorry we are not able to delete your record..oops!");
		}
		
		out.close();
		
	}

}
