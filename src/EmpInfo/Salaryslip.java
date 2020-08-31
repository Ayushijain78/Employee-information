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

import com.mysql.cj.protocol.Resultset;

import SalaryCalc.Paymast;
import dbo.Dbcon;

/**
 * Servlet implementation class Salaryslip
 */
@WebServlet("/servlet/Salaryslip")
public class Salaryslip extends HttpServlet
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
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd=request.getRequestDispatcher("Header");
		RequestDispatcher rd1=request.getRequestDispatcher("Footer");
		
		
		p.print("<html>");
		p.print("<head>");
		p.print("<link rel='stylesheet' type='text/css' href='../css/bootstrap.css'>");
		p.print("<script type='text/javascript' src='../js/jquery.min.js'></script>");
		p.print( "<script src='../js/bootstrap.min.js'></script>");
		p.print("<body>");
		rd.include(request, response);
			p.print("<center>"
					+ "<div class='card bg-light container'><br><br>"
						+ "<div class='card-header'>"
						+ "<h3 class='text-center text-capitalize'>generate salary</h3><hr><br>"
							+ "<form>"
							+ "<label class='text-capitalize text-left mr-5'>enter month</label>"
								+ "<input list=\"month\" name=\"month\" id=\"months\"class='mr-2 pl-3'><br>\r\n" + 
								"  <datalist id=\"month\">\r\n" + 
								"    <option value=\"january\">\r\n" + 
								"    <option value=\"february\">\r\n" + 
								"    <option value=\"march\">\r\n" + 
								"    <option value=\"april\">\r\n" + 
								"    <option value=\"may\">\r\n" + 
								"    <option value=\"june\">\r\n" + 
								"    <option value=\"july\"> \r\n" + 
								"    <option value=\"august\">\r\n" + 
								"    <option value=\"september\">\r\n" + 
								"    <option value=\"october\">\r\n" + 
								"    <option value=\"november\">\r\n" + 
								"    <option value=\"december\">\r\n" + 
								"  </datalist><br>"
								
								+ "<label class='text-capitalize text-left mr-5'>Enter Year</label>"
								
								+ "<input list=\"year\" name=\"year\" id=\"years\" class='px-md-3'><br><br>\r\n" + 
								"  <datalist id=\"year\">\r\n" + 
								"    <option value=\"2020\">\r\n" + 
								"    <option value=\"2019\">\r\n" + 
								"    <option value=\"2018\">\r\n" + 
								"    <option value=\"2017\">\r\n" + 
								"    <option value=\"2016\">\r\n" + 
								"    <option value=\"2015\">\r\n" + 
								"    <option value=\"2014\"> \r\n" + 
								"    <option value=\"2013\">\r\n" + 
								"    <option value=\"2012\">\r\n" + 
								"    <option value=\"2011\">\r\n" + 
								"    <option value=\"2010\">\r\n" + 
								"    \r\n" + 
								"  </datalist>"
								+ "<input type='submit' class=' ml-5 btn btn-primary' >"
							+ "</form>"
						+ "</div>"
					+ "</div></center>"
					);
			p.print("<div class='container'>");
			
			 try
			 {
				 String month =request.getParameter("month");
				 String year=request.getParameter("year");
				 Paymast db=new Paymast();
				 ResultSet rs=db.getsalaryslip(Integer.parseInt(year), month);
				 p.print(" <table class='table table-striped table-bordered'>"
				 		/*+ "<tr><th>eno</th>"
				 		+ "<th>ename</th>"
				 		+ "<th>designation</th>"
				 		+ "<th>department</th>"
				 		+ "<th>da</th>"
				 		+ "<th>ta</th>"
				 		+ "<th>hra</th>"
				 		+ "<th>spall</th>"
				 		+ "<th>salary</th>"
				 		+ "<th>gross</th></tr>*/);
				 while(rs.next())
				 {
					 p.print("<div class=''>");
					
					 p.print(""
					 	
					 		+ "<tr><td><p class='text-capitalize text-danger'>eno: "+rs.getString("eno")+"</p></td>"
					 		+ "<td><p class='text-capitalize text-danger'>name: "+rs.getString("ename")+"</p></td>"
					 		+ "<td><p class='text-capitalize text-danger'>designation: "+rs.getString("desgn")+"</p></td>"
					 		+ "<td><p class='text-capitalize text-danger'>department: "+rs.getString("dept")+"</p></td>"
					 		+ "<td><p class='text-capitalize text-danger'>Da: "+rs.getString("da")+"</p></td>"	
					 		+ "<td><p class='text-capitalize text-danger'>Ta: "+rs.getString("ta")+"</p></td>"
					 		+ "<td><p class='text-capitalize text-danger'>Hra: "+rs.getString("hra")+"</p></td>"
					 		+ "<td><p class='text-capitalize text-danger'>Spall: "+rs.getString("spall")+"</p></td>"
					 		+ "<td><p class='text-capitalize text-danger'>salary: "+rs.getString("salary")+"</p></td>"
					 		+ "<td><p class='text-capitalize text-danger'>gross: "+rs.getString("gross")+"</p></td>");
					 p.print("<td><button class='btn btn-primary' onclick='window.print()'>Print</button></td></tr>");
					
					  
					 p.print("</div>");
					
				 }
				 p.print("</table></div>");
				
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			
			  
			/*   p.print("<h4 class='card-title'>John Doe</h4>");
			     p.print(" <p class='card-text'>Some example text some example text. John Doe is an architect and engineer</p>");
			     p.print(" <a href='#' class='btn btn-primary' onclick='window.print()'>See Profile</a>");*/
			  

		
		
		p.print("</body>"
				+ "</html>");
		rd1.include(request, response);
		
	}
}
