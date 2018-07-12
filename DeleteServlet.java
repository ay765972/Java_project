package com.nit.servlets;

import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/del")
public class DeleteServlet extends GenericServlet 
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
	String pwd=req.getParameter("t2");
	PrintWriter out=res.getWriter();
	
	try
	{
		PreparedStatement ps=cn.prepareStatement("delete from portal where eno=? and pwd=?");
		ps.setInt(1, eno);
		ps.setString(2, pwd);
		int c=ps.executeUpdate();
		if(c==1)
		{
			out.println("<html>");
			out.println("<body style=background-image:url(./dust.jpg);background-size:cover;");
			out.println("<h1 style=font-color:white;><a href=home.html>HOME</a></h1>");
			out.println("</body></html>");
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("delete.html");
			rd.include(req,res);
			out.println("<h2 style=color:white>!!!!INVALID EMPLOYEE NO OR PASSWORD!!!!</h2>");
		}
	
	}
	catch(Exception k)
	{
		k.printStackTrace();
	}
	}

}
