package com.nit.servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;


@WebServlet("/salup")
public class SalUpServlet extends GenericServlet 
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
		System.out.println("we are in service class");
	 Float salary=Float.parseFloat(req.getParameter("t1"));
	 PrintWriter out=res.getWriter();
	 try
	 {
		 String ename=(String)req.getAttribute("ename");
		 String pwd=(String)req.getAttribute("pwd");
		 System.out.println("password is "+pwd);
		 PreparedStatement ps=cn.prepareStatement("update portal set salary=? where ename=? and pwd=?");
		 
		 ps.setFloat(1, salary);
		 ps.setString(2, ename);
		 ps.setString(3, pwd);
		 int c=ps.executeUpdate();
		 if(c==1)
		 {
			 out.println("<h2>salary updated</h2>");
		 }
		 else
			 out.println("<h2>not updated</h2>");
		 }
	 catch(Exception k)
	 {
		 k.printStackTrace();
	 }
	}

}
