package mypack;

public class Simple {
	
	
	private  String ename;
	
	private  String email;
	
	private  String emp_country;
	
	public Simple() {
		super();
	}
	

	public Simple( String ename, String email, String emp_country) {
		super();
	
		this.ename = ename;
		this.email = email;
		this.emp_country = emp_country;
	}


	




	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEmp_country() {
		return emp_country;
	}


	public void setEmp_country(String emp_country) {
		this.emp_country = emp_country;
	}
	
	


}
