package mypack;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MysqlDao {
	
	

	
	private static Connection con;
	
	static List<Simple> list;

	public static int gc(Simple s)
	{
	int gc=0;
		
	try
	{
		Class.forName("com.mysql.jdbc.Driver");  
		
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/nitinraj","root","root");  
		
		PreparedStatement st = con.prepareStatement("insert into employee values(?,?,?)");
		
	
	
	st.setString(1,s.getEname());
	
	st.setString(2,s.getEmail());
	
	st.setString(3,s.getEmp_country());
	
	gc=st.executeUpdate();
	
	
	con.close();
	}
	
	catch(ClassNotFoundException e)
	{
		System.out.println(e);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return gc;
	
	
		
		
	}
	
	
	public static List<Simple> getAllSimple()throws ClassNotFoundException, SQLException
	{
		
		list=new ArrayList<Simple>();
		
Class.forName("com.mysql.jdbc.Driver");  
		
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/nitinraj","root","root");  
		
		PreparedStatement st = con.prepareStatement("select * from employee");
		
		ResultSet rs=st.executeQuery();
		
		while(rs.next())
		{
			Simple s1=new Simple();
			
			s1.setEname(rs.getString(1));
			
			s1.setEmail(rs.getString(2));
			
			s1.setEmp_country(rs.getNString(3));
			
		list.add(s1);
			
			
		}
		
		
		
	
		
		
		
		
		
		return list;
		
		
	}
	
	public static Simple getoneSimple(String ename) throws ClassNotFoundException, SQLException
	{
		
		
Class.forName("com.mysql.jdbc.Driver");  
		
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/nitinraj","root","root");  
		
		PreparedStatement st1 = con.prepareStatement("select * from employee where ename= ?");
		
		st1.setString(1, ename);
		
		Simple s2=new Simple();
		
		ResultSet rs1=st1.executeQuery();
		
		while(rs1.next())
		{
			
			s2.setEname(rs1.getString(1));
			
			s2.setEmail(rs1.getString(2));
			
			s2.setEmp_country(rs1.getString(3));
		}
		
		
		return s2;
		
	}
	
	public static  int emp(Simple s4) throws ClassNotFoundException, SQLException
	{
		int status=0;
		
		
		
Class.forName("com.mysql.jdbc.Driver");  
		
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/nitinraj","root","root");  
		
		PreparedStatement st2 = con.prepareStatement("update employee set email=?,emp_country=? where ename=?");
		
		
		
		st2.setString(1,s4.getEmail());
		
		st2.setString(2,s4.getEmp_country());
		
		st2.setString(3,s4.getEname());
		
		status=st2.executeUpdate();
		
		System.out.println(status);
		
		return status;
		
	}
	
	public static int deleteinfo(String ename)throws ClassNotFoundException, SQLException {
		
		int status=0;
		
Class.forName("com.mysql.jdbc.Driver");  
		
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/nitinraj","root","root");  
		
		PreparedStatement st3=con.prepareStatement("delete from employee where ename=?");
		
		st3.setString(1,ename);
		
		status=st3.executeUpdate();
		

		
		
		
		
		return status;
		
		
	}
	
	}
	





