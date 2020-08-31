package EmpInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbo.Dbcon;


@WebServlet("/servlet/AdminLogin")
public class AdminLogin extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		response.setHeader("cache-control","no-store,no-cache,must-revalidate");
		response.setHeader("cache-control ", "post-check=0,pre-check=0");
		response.setHeader("pragma", "no-cache");
		HttpSession session=request.getSession();  
        String n=(String)session.getAttribute("id");  
        session.setAttribute("id",n);
		if(session.isNew())
			response.sendRedirect("../index.html");
		PrintWriter p =response.getWriter();
		response.setContentType("text/html");
		
		
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		HttpSession hs=request.getSession();
		hs.setAttribute("id",id);
		
		try
		{
			Dbcon db=new Dbcon();
			ResultSet rs=db.adminlogin(id, pwd);
			if(rs.next())
			{
				response.sendRedirect("Welcome");
			}
			else
			{
				response.sendRedirect("../index.html");	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}

}
