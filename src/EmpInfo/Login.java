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

import org.apache.catalina.startup.SetContextPropertiesRule;

import dbo.Dbcon;

/**
 * Servlet implementation class Login
 */
@WebServlet("/servlet/Login")
public class Login extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
		
		HttpSession hs=request.getSession();
	
		RequestDispatcher rd=request.getRequestDispatcher("../header.html");
		RequestDispatcher rd1=request.getRequestDispatcher("Footer");
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		String msg="";
		String msg2="";
		
		
		
		p.print("<html><head><link rel='stylesheet' type='text/css' href='../css/bootstrap.css'>");
		p.print("<script type='text/javascript' src='../js/jquery.min.js'></script>");
		p.print("<script src='../js/bootstrap.min.js'></script>");
		p.print("</head>");
		p.print("<body>");
		
		//if(request.getQueryString()!=null)
		//msg=request.getParameter("msg");
		rd.include(request, response);		
		p.print("<div class='container'>");
		
		p.print("<img src='../images/back.jpg' class='img container' height=400px'>");
		p.print("</div>");
		p.print("<br>");
		p.print("<div class='row container' align='center'>");
			p.print("<div class='col-sm-2'></div>");
			p.print("<div class='col-sm-4'>");
				p.print("<h3 class='text-center'>about us</h3>");
				
				p.print("<p class=''>This is a list of United States–based companies having the most employees globally."+
						"Note that for some companies listed,"+
						"the majority of total employees live"+
						"and work in other countries.");
					
				p.print("</p>");
				p.print("</div>");

			p.print("<div class='col-sm-6' style='border:2px solid green' id='d'>");
			p.print("<form action='AdminLogin'>");
			//p.print("<h5 style='color:red'>"+msg+"</h5>");
			//if(request.getQueryString()!=null)
				//msg2=request.getParameter("msg2");
			
			p.print("<input type='text' name='id' class='form-control-sm' size='40' placeholder='enter your email or phone'><br><br>");
			//p.print("<h5 style='color:red'>"+msg2+"</h5>");
			p.print("<input type='password' name='pwd' class='form-control-sm' size='40' placeholder ='enter your password'><br><br>");
			p.print("<input type='submit' name='login' class='btn btn-success' value ='login'>");
			p.print("</form>");
			p.print("</div>");
		p.print("</div>");
		p.print("</body>");
		p.print("</html>");
		rd1.include(request, response);
		
	
	
	}

}
