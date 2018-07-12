package com.nit.servlets;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/signup")
public class SignupServlet extends GenericServlet 
  {
	private Connection cn;
	public void init(ServletConfig config)throws ServletException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection ("JDBC:mysql://mysql156106-ankitp.j.layershift.co.uk.j.layershift.co.uk:ankit","root","CXQydp62177");
			 
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
	int eno=Integer.parseInt(req.getParameter("t1"));
	String ename=req.getParameter("t2");
	String pwd=req.getParameter("t3");
	Float salary=Float.parseFloat(req.getParameter("t4"));
	String deptno=req.getParameter("t5");
	PrintWriter out=res.getWriter();
	try
	{
		PreparedStatement ps=cn.prepareStatement("insert into portal values(?,?,?,?,?)");
		ps.setInt(1, eno);
		ps.setString(2,ename);
		ps.setString(3, pwd);
		ps.setFloat(4, salary);
		ps.setString(5, deptno);
		int c=ps.executeUpdate();
		out.println("<html>");
		out.println("<body style=background-image:url(./wb.jpg);background-size:cover;");
		out.println("<h2>CONGRATULATION!!</h2>");
		out.println("<h1>Registration Completed Successfully</h1>");
		out.println("<p><b>Thankyou for register.<br>Your information has been saved to our database.<br>Please choose from the following actions::<b></p>");
		out.println("<h2><a href=./login.html>Login</a></h2>");
		out.println("<h2><a href=./home.html>Home</a></h2>");
		out.println("</body></html>");
	}
	catch(Exception k)
	{
		k.printStackTrace();
	}
	}

}
