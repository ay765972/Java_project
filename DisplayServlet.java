package com.nit.servlets;

import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;


@WebServlet("/dis")
public class DisplayServlet extends GenericServlet 
    {
	private Connection cn;
	public void init (ServletConfig config)throws ServletException
	{
		try
		{Class.forName("com.mysql.jdbc.Driver");
		cn=DriverManager.getConnection ("JDBC:mysql://mysql156086-156084-ankit.j.layershift.co.uk:ankit","root","W5NK4PlPyzYBD04U");
		 
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
    		  PreparedStatement ps=cn.prepareStatement("select * from portal where eno=? and pwd=?");
    		  ps.setInt(1,eno);
    		  ps.setString(2,pwd);
    		  ResultSet rs=ps.executeQuery();
    		  boolean b=rs.next();
    		  if(b==true)
    		  {
    			  out.println("<html>");
    			  out.println("<body style=background-image:url(./l.jpg) background-size:cover;>");
    			  out.println("<table border=1 style=width:500px; >");
    			  out.println("<caption><h1>DETAILS</h1></CAPTION>");
    			  out.println("<tr>");
    			  out.println("<td><b>&nbsp&nbspEMPLOYEE NO.</b></td>");
    			  out.println("<td>"+rs.getInt(1)+"</td>");
    			  out.println("</tr><tr>");
    			  out.println("<td><b>&nbsp&nbspEMPLOYEE NAME</b></td>");
    			  out.println("<td>"+rs.getString(2)+"</td>");
    			  out.println("</tr><tr>");
    			  out.println("<td><b>&nbsp&nbspPASSWORD</b></td>");
    			  out.println("<td>"+rs.getString(3)+"</td>");
    			  out.println("</tr><tr>");
    			  out.println("<td><b>&nbsp&nbspSALARY</b></td>");
    			  out.println("<td>"+rs.getFloat(4)+"</td>");
    			  out.println("</tr><tr>");
    			  out.println("<td><b>&nbsp&nbspDEPARTMENT</b></td>");
    			  out.println("<td>"+rs.getString(5)+"</td>");
    			  out.println("</tr></table></body></html>");
    		  }
    		  else
    		  {
    			  out.println("<h2>invalid Employee no</h2>");
    		  }
    	  }
    	  catch(Exception k)
    	  {
    		  k.printStackTrace();
    	  }

	}

}
