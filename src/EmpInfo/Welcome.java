package EmpInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/servlet/Welcome")
public class Welcome extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd=request.getRequestDispatcher("Header");
		RequestDispatcher rd1=request.getRequestDispatcher("Footer");
		
		
		p.print("<html><head><link rel='stylesheet' type='text/css' href='../css/bootstrap.css'>");
		p.print("<script type='text/javascript' src='../js/jquery.min.js'></script>");
		p.print("<script src='../js/bootstrap.min.js'></script>");
	
		p.print("<style>\r\n" + 
				 
				".center {\r\n" + 
				"  position: absolute;\r\n" + 
				"  top: 30%;\r\n" + 
				"  left: 50%;\r\n" + 
				"  transform: translate(-50%, -50%);\r\n" + 
				"  font-size: 18px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"img { \r\n" + 
				"  width: 100%;\r\n" + 
				"  height:90%;\r\n" + 
				"  opacity: 0.5;\r\n" + 
				"}\r\n" +
				"#e1{ \r\n" + 
				"  margin-top:200px;\r\n" + 
				"  \r\n" +
				"#f1{ \r\n" + 
				"  background:#00cba9;\r\n" + 
				"  margin-top:300px;\r\n" +
				
				"}\r\n" +
				"</style>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" ); 
			rd.include(request, response);
			p.print("\r\n" + 
				"\r\n" + 
				"<div class=\"container\" id='f1'>\r\n" + 
			 
				"  <h1 class=\"center display-4 text-danger\">welcome to employe management system</h1>\r\n" );
					
				p.printf("</div>\r\n" + 
				"\r\n" );
				p.print("<svg id='e1' xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 1400 250\"><path fill=\"#00cba9\" fill-opacity=\"1\" d=\"M0,64L20,90.7C40,117,80,171,120,197.3C160,224,200,224,240,197.3C280,171,320,117,360,85.3C400,53,440,43,480,69.3C520,96,560,160,600,202.7C640,245,680,267,720,250.7C760,235,800,181,840,176C880,171,920,213,960,224C1000,235,1040,213,1080,197.3C1120,181,1160,171,1200,186.7C1240,203,1280,245,1320,234.7C1360,224,1400,160,1420,128L1440,96L1440,320L1420,320C1400,320,1360,320,1320,320C1280,320,1240,320,1200,320C1160,320,1120,320,1080,320C1040,320,1000,320,960,320C920,320,880,320,840,320C800,320,760,320,720,320C680,320,640,320,600,320C560,320,520,320,480,320C440,320,400,320,360,320C320,320,280,320,240,320C200,320,160,320,120,320C80,320,40,320,20,320L0,320Z\"></path></svg>");
				
			rd1.include(request, response);
				p.print("</body>\r\n" + 
				"</html>");
			
		
		
		
	}

}
