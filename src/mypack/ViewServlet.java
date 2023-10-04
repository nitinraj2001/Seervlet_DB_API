package mypack;

import java.io.IOException;

import mypack.Simple;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Simple> list = null;
		
response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		out.println("Welcome from ViewServlet<br><br>");
		
		try {
			
			list=MysqlDao.getAllSimple();
			
		} catch (ClassNotFoundException s1) {
		
			s1.printStackTrace();
			
		} catch (SQLException s1) {
			
			s1.printStackTrace();
		}
		
		out.println("<html><body style='background-color:lightblue;'>");
		
		out.println("<table border=1>");
		
		out.println("<tr><td>EmpName</td><td>Email</td><td>EMP_country</td><td>Edit_option</td><td>Delete Your Record here</td><tr>");
		
		for(Simple s1:list)
		{
		out.println("<tr><td>"+s1.getEname()+"</td><td>"+s1.getEmail()+"</td><td>"+s1.getEmp_country()+"</td><td><a href='EditServlet?ename="+s1.getEname()+"'>Edit your details here</a></td><td><a href='DeleteServlet?ename="+s1.getEname()+"'>Delete </a></td></tr>");
		
		}
		out.println("</table></body></html>");
		
		
		out.close();
		
	
		
	}

	
}
