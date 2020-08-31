package EmpInfo;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbo.Dbcon;

@WebServlet("/servlet/SearchEmp")
public class SearchEmp extends HttpServlet
{



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		String eno=request.getParameter("eno");
		try
		{
			Dbcon db=new Dbcon();
			ResultSet rs=db.getEmp(Integer.parseInt(eno));
			if(rs.next())
			{
				
				p.print("<style>input[type='text']" + 
						"{" + 
						"	border-left:5px solid red;" + 
						"	margin-top:20px;" + 
						"	border-right:none;" + 
						"	border-top:none;" + 
						"	" + 
						"	" + 
						"}" + 
						".btn" + 
						"{" + 
						"	margin-bottom:25px;" + 
						"	" + 
						"}" + 
						"#img" + 
						"{" + 
						"	height:500px;" + 
						"	width:auto;" + 
						"}" + 
						"label" + 
						"{" + 
						"	color:white;" + 
						"}" + 
						".col" + 
						"{" + 
						"margin-left:10px;" + 
						"margin-right:10px;" + 
						"box-shadow:0px 15px 10px 0px #ccc;" + 
						"}" + 
						"</style>");
				p.print("<head><link rel='stylesheet' href='../css/bootstrap.css'></head><body class=container>");
				p.print("<div class='col bg-dark'>");
				p.print("<form action=UpdateEmp>");
				p.print("<input type=text placeholder=enter empid id=eno class=form-control-sm name=eno value="+rs.getString(1)+"><br>");
				p.print("<input type=text placeholder=enter  id=name class=form-control-sm name=ename value="+rs.getString(2)+"><br>");
				p.print("<input type=text placeholder=enter desgnation id=desgn class=form-control-sm name=desgn value="+rs.getString(4)+"><br>");
				p.print("<input type=text placeholder=city id=city class=form-control-sm name=city  value="+rs.getString(5)+"><br>");
				p.print("<input type=text placeholder=enter salary id=salary class=form-control-sm name=salary value="+rs.getString(6)+"><br><br>");
				p.print("<label for=gender class=font-weight-bold>gender</label><br>");
				if(rs.getString("gender").equalsIgnoreCase("female"))
				{
					p.print("&nbsp;&nbsp;&nbsp;<input type=radio  value="+rs.getString("gender")+" name=gender checked>&nbsp;&nbsp;&nbsp;<label for=female>female</label>&nbsp;&nbsp;&nbsp;");
					p.print("&nbsp;&nbsp;&nbsp;<input type=radio value="+rs.getString("gender")+" name=gender >&nbsp;&nbsp;&nbsp;<label for=male>male</label>&nbsp;&nbsp;<br><br>");
					
				}
				else
				{	
					p.print("&nbsp;&nbsp;&nbsp;<input type=radio  value="+rs.getString("gender")+" name=gender >&nbsp;&nbsp;&nbsp;<label for=female>female</label>&nbsp;&nbsp;&nbsp;");
				
					p.print("&nbsp;&nbsp;&nbsp;<input type=radio value="+rs.getString("gender")+" name=gender checked>&nbsp;&nbsp;&nbsp;<label for=male>male</label>&nbsp;&nbsp;<br><br>");
				
				}
				p.print("<input type=submit value=update  name=s1 class='btn btn-warning '>");
				p.print("<input type=submit name=s1 id=s2 value=delete class='btn btn-danger'>");
				
			  p.print("</form></div></body>");

			}
			else
			{
				response.sendRedirect("../Errorpage.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

