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

import dbo.Dbcon;

/**
 * Servlet implementation class Searchandupdate
 */
@WebServlet("/servlet/Searchandupdate")
public class Searchandupdate extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		response.setHeader("cache-control","no-store,no-cache,must-revalidate");
		response.setHeader("cache-control ", "post-check=1,pre-check=1");
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
	
		//HttpSession session=request.getSession(false);  
        //String n=(String)session.getAttribute("id");  
		
		
		String eno="",ename="",city="",salary="",dob="",address="",email="",mobile="",state="",dept="",desgn="",photo="";
		Dbcon db;
		if(request.getQueryString()!=null)
		{
			eno=request.getParameter("eno");
			
			try
			{
				db=new Dbcon();
				ResultSet rs=db.getEmp(Integer.parseInt(eno));
				
				if(rs.next())
				{
					eno=rs.getString("eno");
					ename=rs.getString("ename");
					city=rs.getString("city");
					state=rs.getString("state");
					dob=rs.getString("dob");
					salary=rs.getString("salary");
					address=rs.getString("address");
					email=rs.getString("email");
					mobile=rs.getString("mobile");
					dept=rs.getString("dept");
					desgn=rs.getString("desgn");
					photo=rs.getString("picture");

				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}	
	
		 p.print("<link rel='stylesheet' type='text/css' href='../css/bootstrap.css'>");
		 p.print("<script type='text/javascript' src='../js/jquery.min.js'></script>");
		 p.print( "<script src='../js/bootstrap.min.js'></script>"); 
		 p.print("<body class='container>");
	    
		 rd.include(request, response);
		 
		 
		 p.print("<center>"
			 		+ "<div  class='card col-sm-6' >"
				 		+ "<div class='card-header'>"
					 		+ "<form>"
						 		+ "<label class='text-left' >Enter Eno</label>"
						 		+ "<input type='text' class='form-control-sm ml-4' name='eno'><br><br>"
						 		+ "<input type='submit' class='btn btn-primary col-sm-4' value='search'>"
					 		+ "</form>"
				 		+ "</div>"
				 		+ "<div class='card-body'>"
				 		+ "<h3 class='text-center text-capitalize'>update data</h3>"
				 		
				 		+ "<form action='EmpRegister'>");
				 		
		 				p.print("<img  height ='255px' width='255px' class='rounded-circle' id='blah' src=../images/"+photo+"><br>");
		 				p.print("<input type='file' name='photo' class='form-control-sm' onchange='readURL(this);' ><br>");
		 				 p.print("<label class='text-left' >Enter Eno</label>"  
		 				 		+ "<input type='text' class='form-control-sm ml-4' name='eno' readonly='true' value="+eno+"><br><br>");
				 		
				 		p.print( "<label>Ename</label>");
				 		
				 		p.print("<input type='text' class='form-control-sm' name='ename' value="+ename+"><br>");
				 		p.print("<label>date of birth</label><input type='date' class='form-sontrol-sm' value="+dob+"><br>");
				 		
				 		p.print( "<label>email</label>"
				 		+ "<input type='text' class='form-control-sm' name='email' value="+email+">");
				 		
				 		
				 		p.print( "<label>mobile</label>"
				 		+ "<input type='text' class='form-control-sm' name='mobile'  value="+mobile+"><br><br>");
				 		
		 
	 					p.print( 
	 							"	<label for='city'>city</label>" + 
	 							"	<input type='text' list='cities' id='city' required='required' name='city' class='form-control-sm' value="+city+"> " + 
	 							"	<datalist id='cities'> "  + 
	 							"	<option value='pune'>  " + 
	 							"	<option value='delhi'> " + 
	 							"	<option value='hydrabad'> " + 
	 							"	<option value='banglore'>" + 
	 							"	<option value='manglore'>" + 
	 							"	<option value='gwalior'>" + 
	 							"	<option value='chennai'>" + 
	 							"	<option value='noida'> " + 
	 							"	<option value='delhi'> " + 
	 							"	</datalist>");
	 					
	 					p.print("<label>state</label>  " + 
	 							"  <select id='state' class='form-control-sm col-sm-4' name='state' > " + 
	 							"	<option value="+state+">"+state+"</option>" + 
	 							"	</select><br>");
	 
		 
		 				p.print("<label>department</label><select name='dept' class='form-control-sm' selected>");
				 		try
				 		{
				 			db=new Dbcon();
				 			ResultSet rs=db.alldept();
				 			while(rs.next())
				 			{
				 				p.print("<option value="+rs.getString(1)+">"+rs.getString(1)+"</option>");
				 			}
				 			
				 		}
				 		catch(Exception e)
				 		{
				 			e.printStackTrace();
				 		}
				 		
				 		
				 		
		 				p.print( "</select>");
				 		
		 				
		 				p.print("<label>Designation</label><select class='form-control-sm col-3' name='desgn'>");
		 				try
				 		{
				 			db=new Dbcon();
				 			ResultSet rs=db.alldesgn();
				 			while(rs.next())
				 			{
				 				p.print("<option value="+rs.getString(1)+">"+rs.getString(1)+"</option>");
				 			}
				 			
				 		}
				 		catch(Exception e)
				 		{
				 			e.printStackTrace();
				 		}
				 		
				 		
				 		
		 				p.print( "</select><br>");
				 		p.print("salary<input type='text' name='salary' class='form-control-sm' value="+salary+">");
				 		p.print("<label>Address</label><input type='text' class='form-control-sm' name='address' value="+address+"><br>");
				 		p.print("<input type='submit' class='btn btn-primary' value='update' name='b1'>");
				 			 	
				 		p.print("</form>"
				 		+ "</div>"
				 		+ "</div>"
						+ "</center>");
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 rd1.include(request, response);
	     p.print("</body></html>");
		
			
			
			
			
				
				p.print(
				"<script>\r\n" + 
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
				
				p.print("<script>");
				p.print("function readURL(input) {\r\n" + 
						"        if (input.files && input.files[0]) {\r\n" + 
						"            var reader = new FileReader();\r\n" + 
						"\r\n" + 
						"            reader.onload = function (e) {\r\n" + 
						"                $('#blah')\r\n" + 
						"                    .attr('src', e.target.result)\r\n" + 
						"                    .width(150)\r\n" + 
						"                    .height(200);\r\n" + 
						"            };\r\n" + 
						"\r\n" + 
						"            reader.readAsDataURL(input.files[0]);\r\n" + 
						"        }\r\n" + 
						"    }");
				
				p.print("</script>");
		
				
		
	}

}
