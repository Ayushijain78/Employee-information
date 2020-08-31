package EmpInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Footer
 */
@WebServlet("/servlet/Footer")
public class Footer extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		p.print("<html>");
		p.print("<head>");
		p.print("<title></title>");
		p.print("<link rel='stylesheet' type='text/css' href='../css/bootstrap.css'>");
		p.print("<script type='text/javascript' src='../js/jquery.min.js'></script>");
		p.print("<script src='js/bootstrap.min.js'></script>");
		p.print("</head>");
		p.print("<body>");
		p.print("<div class='bg-dark'>");
		p.print("<p class='text-capitalize text-center text-light' >&copy; all right reserved</p>");
		
		p.print("</div></body></html>");


		
	}

}
