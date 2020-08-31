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
 * Servlet implementation class RegisterEmp
 */
@WebServlet("/servlet/RegisterEmp")
public class RegisterEmp extends HttpServlet
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
		p.print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"	<title>registration page</title>\r\n" + 
				"	<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/bootstrap.css\">\r\n" + 
				"	<script src=\"../js/jquery.min.js\"></script>\r\n" + 
				"\r\n" + 
				"</head>\r\n" + 
				"<style type=\"text/css\">\r\n" + 
				"	\r\n" + 
				"	*\r\n" + 
				"	{\r\n" + 
				"		text-transform: capitalize;\r\n" + 
				"		font-family: verdana;\r\n" + 
				"		color: black;\r\n" + 
				"		\r\n" + 
				"	}\r\n" + 
				"\r\n" + 
				".bg \r\n" + 
				"{\r\n" + 
				"  /* The image used */\r\n" + 
				"  background-image: url(\"../images/m8.jfif\");\r\n" + 
				"\r\n" + 
				"  /* Full height */\r\n" + 
				"  height: 150%;\r\n" + 
			
				"  background-position: center;\r\n" + 
				"  background-repeat: no-repeat;\r\n" + 
				"  background-size: cover;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"*\r\n" + 
				"{\r\n" + 
				"	text-transform:capitalize;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#d1\r\n" + 
				"{\r\n" + 
				"	border-radius:0px;\r\n" + 
				"	background-color: ;\r\n" + 
				"	\r\n" + 
				"	padding-bottom: 10px;\r\n" + 
				"	box-shadow: 0 4px 8px 16px 20px #ccc;\r\n" + 
				"}\r\n" + 
				"label\r\n" + 
				"{\r\n" + 
				"	color:black;\r\n" + 
				"	font-size: 0.8rem;\r\n" + 
				"	font-weight:bold;\r\n" + 
				"	float: left;\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				".row\r\n" + 
				"{\r\n" + 
				"	flex-wrap:wrap;\r\n" + 
				"	margin-right:-150px;\r\n" + 
				"	mardin-left:100px;\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				".card\r\n" + 
				"{\r\n" + 
				"	\r\n" + 
				"	background:#f3eeee66;\r\n" + 
				"	border-radius:30%;\r\n" + 
				"}\r\n" + 
				".card-header\r\n" + 
				"{\r\n" + 
				"	padding:0;\r\n" + 
				"	background:#0000008c;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</style>\r\n" + 
				"<body >\r\n"); 
				rd.include(request, response);
				p.print("\r\n" + 
				"<div class=\"container-fluid bg\" >\r\n" + 
				" <center> \r\n" + 
				"  <div class=\"col-sm-7 card \" id=\"d1\" style=\"\">\r\n" + 
				"    <div class=\"card-header\"><h3 class=\"display-5 text-warning\" id=\"h1\" style=\"color: white\">Register here</h3>\r\n" + 
				"      <HR class=\"bg-danger\" >\r\n" + 
				"    </div>\r\n" + 
				"    <div id=\"g1\">\r\n" + 
				"      <div class=\"card-body\">\r\n" + 
				"        <form action=\"EmpRegister\"  >\r\n" + 
				"\r\n" + 
				"          <div class=\"row\">\r\n" + 
				"            \r\n" + 
				"            <div class=\"col-sm-5\">\r\n" + 
				"            <label class=\"text-capitalize\">name</label>\r\n" + 
				"            <input type=\"text\" name=\"ename\" class=\"form-control text-capitalize\" id=name  required=\"required\">\r\n" + 
				"            </div>\r\n" + 
				"            <div class=\"col-sm-5\">\r\n" + 
				"            <label class=\"text-capitalize\">date of birth</label>\r\n" + 
				"            <input type=\"date\" name=\"dob\" class=\"form-control text-capitalize\" id=dob required=\"required\">\r\n" + 
				"            </div>\r\n" + 
				"           \r\n" + 
				"            <div class=\"col-sm-5\">\r\n" + 
				"            <label class=\"text-capitalize\">email</label><input type=\"email\" name=\"email\" class=\"form-control text-capitalize\" id=\"email\"  required=\"required\">\r\n" + 
				"            </div>\r\n" + 
				"            \r\n" + 
				"            <div class=\"col-sm-5\">\r\n" + 
				"            <label class=\"text-capitalize\">mobile no:</label><input type=\"text\" name=\"mobile\" class=\"form-control\" id=\"mobile\" required=\"required\" maxlength=\"10\">\r\n" + 
				"            </div>\r\n" + 
				"           \r\n" + 
				"           \r\n" + 
				" 			<div class=\"col-sm-5\">\r\n" + 
				"            <label for=\"state\">city</label>\r\n" + 
				"			<input type=\"text\" list=\"cities\" id=\"city\"required=\"required\" name=\"city\" class=\"form-control\">\r\n" + 
				"			<datalist id=\"cities\">\r\n" + 
				"			<option value=\"pune\">\r\n" + 
				"			<option value=\"delhi\">\r\n" + 
				"			<option value=\"hydrabad\">\r\n" + 
				"			<option value=\"banglore\">\r\n" + 
				"			<option value=\"manglore\">\r\n" + 
				"			<option value=\"gwalior\">\r\n" + 
				"			<option value=\"chennai\">\r\n" + 
				"			<option value=\"noida\">\r\n" + 
				"			<option value=\"delhi\">\r\n" + 
				"			\r\n" + 
				"			</datalist>\r\n" + 
				"          </div>\r\n" + 
				"          <div class=\"col-sm-5\"> \r\n" );
				
				
				p.print("<label>designation</label>\r\n" + 
						"	           <input list=\"desgn\" id=\"designation\" name=\"desgn\" class=\"form-control\">\r\n" + 
						"				<datalist id=\"desgn\">\r\n ");
						try
						{
							Dbcon db=new Dbcon();
							ResultSet rs=db.alldesgn();
							while(rs.next())
							{
								p.print("<option value="+rs.getString(1)+">"+rs.getString(1)+"</option>");
							}
						}
						catch (Exception e) 
						{
							e.printStackTrace();
						}
		
		
		
		
		
		p.print("</datalist>");
				
				
				
				p.print("   </div>\r\n" + 
				" 			\r\n" + 
				"            <div class=\"col-sm-5\">\r\n"); 
				p.print("<label>department</label>\r\n" + 
				"	           <input list=\"dept\" id=\"depty\" name=\"dept\" class=\"form-control\">\r\n" + 
				"				<datalist id=\"dept\">\r\n ");
				try
				{
					Dbcon db=new Dbcon();
					ResultSet rs=db.alldept();
					while(rs.next())
					{
						p.print("<option value="+rs.getString(1)+">"+rs.getString(1)+"</option>");
					}
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}

				p.print("</datalist>\r\n" + 
				"            </div>\r\n" + 
				"            <div class=\"col-sm-5\">\r\n" + 
				"            	<label>salary</label>\r\n" + 
				"            	<input type=\"text\" name=\"salary\" class=\"form-control\">\r\n" + 
				"\r\n" + 
				"            </div>\r\n" + 
				"            <div class=\"col-sm-5\">\r\n" + 
				"            	<label>picture</label>\r\n" + 
				"            	<input type=\"file\" name=\"picture\" class=\"form-control\" value=\"/images/\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"            </div>\r\n" + 
				"            \r\n" + 
				"            <div class=\"col-sm-10\">\r\n" + 
				"            	<label>address</label>\r\n" + 
				"            	<textarea class=\"form-control\" name=\"address\"></textarea>\r\n" + 
				"            </div>\r\n" + 
				"\r\n" + 
				"			<div class=\"radio col-sm-3\">\r\n" + 
				"				<br>\r\n" + 
				"			<input type=\"radio\" name=\"gender\" class=\"\" id=\"gen\" VALUE=\"male\">&nbsp;&nbsp;<span class=\"text-dark\">male</span>\r\n" + 
				"            </div>\r\n" + 
				"            <div class=\"radio col-sm-3\">\r\n" + 
				"            	<br>\r\n" + 
				"			<input type=\"radio\" name=\"gender\" class=\"\" id=\"gen\" VALUE=\"female\">&nbsp;&nbsp;<span class=\"text-dark\">female</span>\r\n" + 
				"            </div>\r\n" + 
				"            <div class=\"col-sm-10\"><br>\r\n" + 
				"         <input type=\"submit\" name=\"b1\" value=\"insert\" class=\"btn btn-warning col-sm-10\">\r\n" + 
				"     </div>\r\n" + 
				"      </div>\r\n" + 
				"      \r\n" + 
				"     \r\n" + 
				"     \r\n" + 
				"     \r\n" + 
				"    </form>\r\n" + 
				"  </div>\r\n" + 
				" </div>\r\n" + 
				"</div>\r\n" + 
				"</div></center>\r\n" + 
				"</body>\r\n" + 
				"</html>\r\n" + 
				"\r\n" );
				rd1.include(request, response);
				p.print("<script>\r\n" + 
				"$(document).ready(function () \r\n" + 
				"{\r\n" + 
				"	\r\n" + 
				"    $(\"#city\").change(function () {\r\n" + 
				"        var val = $(this).val();\r\n" + 
				"        if (val == \"pune\") {\r\n" + 
				"            $(\"#state\").html(\"<option value='maharastra'>Maharastra</option>\");\r\n" + 
				"        } else if (val == \"banglore\"||val==\"manglore\") {\r\n" + 
				"            $(\"#state\").html(\"<option value='karnatka'>Karnatka</option>\");\r\n" + 
				"        } else if (val == \"delhi\"||val==\"noida\") {\r\n" + 
				"            $(\"#state\").html(\"<option value='new delhi'>new delhi</option>\");\r\n" + 
				"        } else if (val == \"gwalior\") {\r\n" + 
				"            $(\"#state\").html(\"<option value='madhya pradesh'>madhya pradesh</option>\");\r\n" + 
				"        }\r\n" + 
				"          else if(val==\"hydrabad\"){\r\n" + 
				"     		$(\"#state\").html(\"<option value='telangana'>telangana</option>\");\r\n" + 
				"     	}\r\n" + 
				"          else if(val==\"chennai\"){\r\n" + 
				"       		$(\"#state\").html(\"<option value='tamilnadu'>tamilnadu</option>\");\r\n" + 
				"       	}\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"    });\r\n" + 
				"});\r\n" + 
				"</script>");
		
		
	}

}
