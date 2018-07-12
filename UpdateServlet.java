package com.nit.servlets;

import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/update")
public class UpdateServlet extends GenericServlet 
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
		PreparedStatement ps=cn.prepareStatement("select * from portal where ename=? and pwd=?");
		ps.setString(1, ename);
		ps.setString(2, pwd);
		ResultSet rs=ps.executeQuery();
		boolean b=rs.next();
		if(b==true)
		{
			RequestDispatcher rd1=req.getRequestDispatcher("update2.html");
			req.setAttribute("ename", rs.getString(2));
			req.setAttribute("pwd",rs.getString(3));
		
			rd1.forward(req,res);
			
			/*RequestDispatcher rd2=req.getRequestDispatcher("salupdate.html");
			req.setAttribute("ename", rs.getString(2));
			req.setAttribute("pwd",rs.getString(3));
		
			rd2.include(req,res);
			
			RequestDispatcher rd3=req.getRequestDispatcher("SalUpServlet");
			req.setAttribute("ename", rs.getString(2));
			req.setAttribute("pwd",rs.getString(3));
		
			rd3.forward(req,res);*/
		}
		else
		{
			RequestDispatcher rd2=req.getRequestDispatcher("update.html");
			rd2.include(req, res);
			out.println("<h2 style=color:white font-family:verdana>!!!INVALID EMPLOYEE NAME OR PASSWORD!!!</h2>");
		}
	}
	catch(Exception k)
	{
		k.printStackTrace();
	}
	}

}
