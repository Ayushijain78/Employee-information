package EmpInfo;

import dbo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/EmpRegister")
public class EmpRegister extends HttpServlet
{	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException
	{
		PrintWriter p=rs.getWriter();
		rs.setContentType("text/html");
		
		
		try
		{
			Dbcon db=new Dbcon();
			String b1=rq.getParameter("b1");
			if(b1.equalsIgnoreCase("insert"))
				insertEmp(rq,db);
			else
				if(b1.equalsIgnoreCase("update"))
					updateEmp(rq,db);
				else
					if(b1.equalsIgnoreCase("delete"))
						deleteEmp(rq,db);
					else 
						if(b1.equalsIgnoreCase("search"))
							searcheEmp(rq,db);
			else
				p.print("falied");
			}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		rs.sendRedirect("EmpData");
	}

	private void searcheEmp(HttpServletRequest rq, Dbcon db) throws NumberFormatException, SQLException
	{
		String eno=rq.getParameter("eno");
		ResultSet rs1=db.getEmp(Integer.parseInt(eno));
		
	}

	private void deleteEmp(HttpServletRequest rq, Dbcon db) throws NumberFormatException, SQLException 
	{
		String eno=rq.getParameter("eno");
		int x=db.deleteEmp(Integer.parseInt(eno));
	}

	private void updateEmp(HttpServletRequest rq, Dbcon db) throws NumberFormatException, SQLException
	{
		String ename=rq.getParameter("ename");
		String dob=rq.getParameter("dob");
		String email=rq.getParameter("email");
		String mobile=rq.getParameter("mobile");
		String city=rq.getParameter("city");
		String state=rq.getParameter("state");
		String dept=rq.getParameter("dept");
		String desgn=rq.getParameter("desgn");
		String address=rq.getParameter("address");
		String picture=rq.getParameter("photo");
		String salary=rq.getParameter("salary");
		String eno=rq.getParameter("eno");
		
		int x=db.updatetEmp(Integer.parseInt(eno), ename, email,mobile, city, state, dept, desgn, Integer.parseInt(salary), picture,address);
		
	}

	private void insertEmp(HttpServletRequest rq, Dbcon db) throws NumberFormatException, SQLException
	{
		
		String ename=rq.getParameter("ename");
		String dob=rq.getParameter("dob");
		String gender=rq.getParameter("gender");
		String email=rq.getParameter("email");
		String mobile=rq.getParameter("mobile");
		String city=rq.getParameter("city");
		String state=rq.getParameter("state");
		String dept=rq.getParameter("dept");
		String desgn=rq.getParameter("desgn");
		String address=rq.getParameter("address");
		String picture=rq.getParameter("picture");
		String salary=rq.getParameter("salary");
		int x=db.insertEmp(ename, dob, gender, email, mobile, city, state, dept, desgn, Integer.parseInt(salary), address, picture);
		
	}

}
