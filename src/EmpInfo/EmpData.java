package EmpInfo;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbo.Dbcon;

/**
 * Servlet implementation class EmpTable
 */
@WebServlet("/servlet/EmpData")

public class EmpData extends HttpServlet
{
	protected void doGet(HttpServletRequest rq, HttpServletResponse response) throws ServletException, IOException 
	{

		response.setHeader("cache-control","no-store,no-cache,must-revalidate");
		response.setHeader("cache-control ", "post-check=0,pre-check=0");
		response.setHeader("pragma", "no-cache");
		HttpSession session=rq.getSession();  
        String n=(String)session.getAttribute("id");  
        session.setAttribute("id",n);
		if(session.isNew())
			response.sendRedirect("../index.html");
		
		RequestDispatcher rd=rq.getRequestDispatcher("Header");
		RequestDispatcher rd1=rq.getRequestDispatcher("Footer");
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		rd.include(rq, response);
		p.print("<body class='container'><table class='table table-bordered table-hover'><tr class=bg-danger><th>Ename<th>Gender<th>Email<th>Date of Birth<th>Phone<th>City<th>State<th>Desgination<th>Department<th>Address<th>Picture</tr>");
		try
		{
			Dbcon db=new Dbcon();
			ResultSet rs=db.getRecords();
			while(rs.next())
			{
				p.print("<tr><td><a href=Searchandupdate?eno="+rs.getString(1)+">"+rs.getString("ename")+"<td>"+rs.getString("gender")+"<td>"+rs.getString("email")+"<td>"+rs.getString("dob")+"<td>"+rs.getString("mobile")+"<td>"+rs.getString("city")+"<td>"+rs.getString("state")+"<td>"+rs.getString("desgn")+"<td>"+rs.getString("dept")+"<td>"+rs.getString("address")+"<td><img class='rounded-circle' width=50px heigth=50px src=../images/"+rs.getString(13)+">"+"</tr>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		p.print("</table></body>");
		rd1.include(rq,response);
	}
}
