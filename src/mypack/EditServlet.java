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
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Simple s = null;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		response.setContentType("text/html");
		
		PrintWriter out =response.getWriter();
		
		out.println("Hello here you can edit your informations");
		
		String ename=request.getParameter("ename");
		
		try {
			
			s=MysqlDao.getoneSimple(ename);
			
			out.println(s.getEmail());
			
		} catch (ClassNotFoundException | SQLException e) {
			
			
			e.printStackTrace();
		}
		
		out.println("<html><body>");
		
		out.println("<form method='get' action='EditSave'>");
		
		out.println("<table>");
		
		out.println("<tr><td><input type='hidden' name='ename' value='"+s.getEname()+"'/></td></tr> ");
		
		out.println("<tr><td><br><input type='text' name='email' value='"+s.getEmail()+"'/></td></tr> ");
		
	out.println("<tr><td><br><input type'text' name='country' value='"+s.getEmp_country()+"'/>");
	
	out.println("<br><br><button>EDIT AND SAVE</button>");
		out.println("</select></table></form>");
		
		out.println("</body></html>");
		
	

		
		
		
		
		
		
		
		
		
		
		out.close();
	}

}
