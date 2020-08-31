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

import SalaryCalc.Paymast;
import dbo.N2W;

/**
 * Servlet implementation class Salarysheet
 */
@WebServlet("/servlet/Salarysheet")
public class Salarysheet extends HttpServlet
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
		if(request.getQueryString()!=null)
		
		p.print("<html>");
		p.print("<head>");
		p.print("<link rel='stylesheet' type='text/css' href='../css/bootstrap.css'>");
		p.print("<script type='text/javascript' src='../js/jquery.min.js'></script>");
		p.print( "<script src='../js/bootstrap.min.js'></script>");
		p.print("<body class='container'>");
		rd.include(request, response);
		p.print("<br><center>"
				+ "<div class='card bg-light container'><br><br>"
					+ "<div class='card-header'>"
					+ "<h3 class='text-center text-capitalize'>generate salary sheet</h3><hr><br>"
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
	
		p.print("<table class='table table-bordered'>");
			p.print("<tr>"
					+ "<th>Eno</th>"
					+ "<th>Ename</th>"
					+ "<th>Department</th>"
					+ "<th>Designation</th>"
					+ "<th>Da</th>"
					+ "<th>Ta</th>"
					+ "<th>Hra</th>"
					+ "<th>Spall</th>"
					+ "<th>Salary</th>"
					+ "<th>Gross</th>"
					+ "</tr>");
			try
			{
				
				String month=request.getParameter("month");
				String year=request.getParameter("year");
				
				Paymast pm=new Paymast();
				int i=0;
				double sumda=0,sumta=0,sumhra=0,sumspall=0,sumgross=0,sumsal=0;
				
				ResultSet rs=pm.getsalaryslip(Integer.parseInt(year), month);
				while(rs.next())
				{
					p.print("<tr>"
								+ "<td>"+rs.getString("eno")+"</td>"
								+ "<td>"+rs.getString("ename")+"</td>"
								+ "<td>"+rs.getString("dept")+"</td>"
								+ "<td>"+rs.getString("desgn")+"</td>"
								+ "<td>"+rs.getString("da")+"</td>"
								+ "<td>"+rs.getString("ta")+"</td>"
								+ "<td>"+rs.getString("hra")+"</td>"
								+ "<td>"+rs.getString("spall")+"</td>"
								+ "<td>"+rs.getString("salary")+"</td>"
								+ "<td>"+rs.getString("gross")+"</td>"
											
									
							+ "</tr>");
					
					 sumda+=rs.getDouble("da");
					 sumta+=rs.getDouble("ta");
					 sumhra+=rs.getDouble("hra");
					 sumspall+=rs.getDouble("spall");
					 sumsal+=rs.getDouble("salary");
					 sumgross=sumda+sumta+sumhra+sumspall+sumsal;
				}
				
				
				N2W n1=new N2W();
				String gross=Double.toString(sumgross);
				String[] s1=gross.split("\\.");
				String s=n1.toword(Integer.parseInt(s1[0]),Integer.parseInt(s1[1]));
				
				

				
					p.print("<tr><th colspan='4'>total</th><th class='text-danger'>"+sumda+"</th><th class='text-danger'>"+sumta+"</th><th class='text-danger'>"+sumhra+"</th><th class='text-danger'>"+sumspall+"</th><th class='text-danger'>"+sumsal+"</th><th class='text-danger'>"+sumgross+"</th></tr>");
					p.print("<tr><th colspan='6'><span class='text-danger mr-5'>Gross salary: </span>"+s+"</th></tr>");
					
				
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				// TODO: handle exception
			}
		p.print("</table>");
		
		p.print("</body></html>");
		rd1.include(request, response);
		
	}

}
