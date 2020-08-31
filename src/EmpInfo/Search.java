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
 * Servlet implementation class Search
 */
@WebServlet("/servlet/Search")
public class Search extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);  
        String n=(String)session.getAttribute("id");  
       
		
		p.print("<form action=\"Searchandupdate\" id=\"d1\">\r\n" + 
				"				<h5 class=\"text-center text-capitalize\">search employee</h5>\r\n" + 
				"				<label class=\"text-left font-weight-bold\">enter eno</label>\r\n" + 
				"				<input type=\"text\" name=\"eno\" placeholder=\"enter eno\" class=\"form-control-sm\"><br><br>\r\n" + 
				"				<input type=\"submit\" name=\"search\" value=\"search\" class=\"btn btn-success col-sm-4\" id=\"b1\">	\r\n" + 
				"			</form>\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"col-sm-\" id=\"\"></div>\r\n" + 
				"		<div class=\"bg-warning col-sm-8\">\r\n" 
				);
	}

}
