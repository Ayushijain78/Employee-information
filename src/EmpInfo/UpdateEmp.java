package EmpInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;

import dbo.Dbcon;

/**
 * Servlet implementation class UpdateEmp
 */
@WebServlet("/servlet/UpdateEmp")
public class UpdateEmp extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest rq, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setHeader("cache-control","no-store,no-cache,must-revalidate");
		res.setHeader("cache-control ", "post-check=0,pre-check=0");
		res.setHeader("pragma", "no-cache");
		HttpSession session=rq.getSession();  
        String n=(String)session.getAttribute("id");  
         session.setAttribute("id",n);
		if(session.isNew())
			
			res.sendRedirect("../index.html");
		
		
		PrintWriter p =res.getWriter();
		res.setContentType("text/html");
		try
		{
			String ename=rq.getParameter("ename");
			String dob=rq.getParameter("dob");
			
			String email=rq.getParameter("email");
			String mobile=rq.getParameter("mobile");
			String city=rq.getParameter("city");
			String state=rq.getParameter("state");
			String dept=rq.getParameter("dept");
			String desgn=rq.getParameter("desgn");
			String address=rq.getParameter("address");
			String picture=rq.getParameter("photo");
			String salary=rq.getParameter("salary");
			String eno=rq.getParameter("eno");
			Dbcon db=new Dbcon();
			int x=db.updatetEmp(Integer.parseInt(eno), ename, email, mobile, city, state, dept, desgn, Integer.parseInt(salary),address, picture);
			if(x==1)
				res.sendRedirect("EmpData");
			else
				res.sendRedirect("../index.html");
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}

}
