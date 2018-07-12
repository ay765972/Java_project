package com.nit.servlets;

import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/signin")
public class Signin extends GenericServlet 
   {
	private Connection  cn;
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
	String ename=req.getParameter("t1");
	String pwd=req.getParameter("t2");
	PrintWriter out=res.getWriter();
	try
	{
		PreparedStatement ps=cn.prepareStatement("select count(*) from portal where ename=? and pwd=?");
		ps.setString(1, ename);
		ps.setString(2, pwd);
		ResultSet rs=ps.executeQuery();
		rs.next();
		int c=rs.getInt(1);
		if(c==1)
		{
			out.println("<html>");
			out.println("<body style=background-image:url(./w.png);background-size:cover;");
			out.println("</body></html>");
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req,res);
			out.println("<h2 style=color:white>!!!!INVALID EMPLOYEE NAME OR PASSWORD!!!!</h2>");
		}
	}
	catch(Exception k)
	{
		k.printStackTrace();
	}
	}

}
