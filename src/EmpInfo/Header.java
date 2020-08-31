package EmpInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Header
 */
@WebServlet("/servlet/Header")
public class Header extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
			
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		
		p.print("<html>");
		p.print("<head>");
		  p.print("<link rel='stylesheet' type='text/css' href='../css/bootstrap.css'>");
		  p.print("<script type='text/javascript' src='../js/jquery.min.js'></script>");
		   p.print( "<script src='../js/bootstrap.min.js'></script>");
		 p.print("<title></title>");
		p.print("<body>");
		 p.print("<nav class='navbar navbar-expand-md  bg-dark navbar-dark fixed-top'>");
		  p.print("<a class='navbar-brand text-capitalize' href='#'>Employee information</a>");
		 p.print("<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#collapsibleNavbar'>");
		   p.print( "<span class='navbar-toggler-icon'></span>");
		 p.print( "</button>");
		 p.print(" <div class='collapse navbar-collapse' id='collapsibleNavbar'>");
		   p.print("<ul class='navbar-nav'>");
		     p.print("<li class='nav-item'>");
		     p.print( "<a class='nav-link' href='RegisterEmp'>register</a>");
		     p.print( "</li>");
		      p.print("<li class='nav-item'>");
		       p.print( "<a class='nav-link' href='Searchandupdate'>search and update</a>");
		      p.print("</li>");
		      p.print("<li class='nav-item'>");
		      p.print( " <a class='nav-link' href='Searchanddelete'>search and delete</a>");
		      p.print("</li>");    
		      p.print( "<li class='nav-item'>");
		       p.print( "<a class='nav-link' href='EmpData'>show all</a>");
		      p.print("</li>");   
		       p.print("<li class='nav-item'>");
		        p.print("<a class='nav-link' href='Generatesalary'>generate salary</a>");
		      p.print("</li>"); 
		       p.print("<li class='nav-item'>");
		        p.print("<a class='nav-link' href='Salaryslip'>salary slip</a>");
		      p.print("</li>");  
		       p.print("<li class='nav-item'>");
		        p.print("<a class='nav-link' href='Salarysheet'>salary sheet</a>");
		      p.print("</li>");
		    p.print("</ul>");
		    p.print("<ul class='navbar-nav ml-auto' >");
		      p.print("<li class='nav-item'>");
		          p.print("<a class='nav-link' href='Logout'>logout</a>");
		       p.print("</li>");
		   p.print("</ul>");
		  p.print("</div>");  
		p.print("</nav>");
		p.print("<br><br><br>");
		p.print("</body>");
		p.print("</html>");
		
		
	
	}

}
