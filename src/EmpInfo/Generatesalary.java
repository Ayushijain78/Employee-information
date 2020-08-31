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
@WebServlet("/servlet/Generatesalary")
public class Generatesalary extends HttpServlet
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
		
		try
		{
			Paymast pm=new Paymast();
			Dbcon db=new Dbcon();
			String eno="";
			double da=0,ta=0,hra=0,spall=0,gross=0;;
			String sal="";
			int x=0;
			ResultSet rs=db.getRecords();
			
			while(rs.next())
			{
				eno=rs.getString("eno");
			    sal=rs.getString("salary");
			   
			    da=Integer.parseInt(sal)*1.20;
			    if(rs.getString("city").equalsIgnoreCase("mumbai")||rs.getString("city").equalsIgnoreCase("chennai")||rs.getString("city").equalsIgnoreCase("delhi"))
			    {
			    	ta=Integer.parseInt(sal)*0.40;
			    }
			    else
			    {
			    	ta=Integer.parseInt(sal)*0.30;
			    }
			    if(rs.getString("desgn").equalsIgnoreCase("manager"))
			    {
			    	hra=Integer.parseInt(sal)*0.35;
			    }
			    else
			    {
			    	hra=Integer.parseInt(sal)*0.25;
			    }
			    if(rs.getString("gender").equalsIgnoreCase("female")&&rs.getString("desgn").equalsIgnoreCase("manager"))
			    {
			    	spall=Integer.parseInt(sal)*0.3;
			    }
			    else
			    {
			    	spall=Integer.parseInt(sal)*0.1;
			    }
			    
			    gross=Integer.parseInt(sal)+da+ta+hra+spall;
			    
			    String month =request.getParameter("month");
				String year=request.getParameter("year");
				String msg="";
				
				if(request.getQueryString()!=null)
				{
					 x=pm.insertsalary(Integer.parseInt(eno),da, ta, hra, spall, Integer.parseInt(sal),gross, month, Integer.parseInt(year));
				}	
			}
			if(x==1)
			{
				p.print("<h3 class=text-center text-warning'>salary generated</h3>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		p.print("<table>"
					+"<tr>"
						+"<td></td>"
					+"</tr>"
				+"</table>");
		rd1.include(request, response);
		p.print("</body></html>");
		
	}
}
