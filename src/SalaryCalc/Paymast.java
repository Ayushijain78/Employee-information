package SalaryCalc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;


public class Paymast 
{
	Connection cn;
	Statement st;
	ResultSet rs;
	public Paymast() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		st=cn.createStatement();
		
	}
	public int insertsalary(int eno,double da,double ta,double hra,double spall,int salary,double gross,String month,int year) throws SQLException
	{
		PreparedStatement pt=cn.prepareStatement("insert into paymast (eno,da,ta,hra,spall,salary,gross,month,year)values(?,?,?,?,?,?,?,?,?)  ");
		pt.setInt(1,eno);
		pt.setDouble(2, da);
		pt.setDouble(3, ta);
		pt.setDouble(4, hra);
		pt.setDouble(5, spall);
		pt.setInt(6, salary);
		pt.setDouble(7, gross);
		pt.setString(8,month);
		pt.setInt(9, year);
		
		int x=pt.executeUpdate();
		return x;
				
		
	}
	public ResultSet getsalaryslip() throws SQLException
	{
		st=cn.createStatement();
		ResultSet rs= st.executeQuery("SELECT  emp.picture,emp.eno,emp.desgn,emp.ename,emp.dept,paymast.month,paymast.year,paymast.salary,paymast.da,paymast.ta,paymast.hra,paymast.spall,paymast.gross" + 
				"	FROM emp" + 
				"	INNER JOIN paymast" + 
				"	ON emp.eno = paymast.eno");
		return rs;
	}
	
	public ResultSet getsalaryslip(int year,String month) throws SQLException
	{
		PreparedStatement pt=cn.prepareStatement("SELECT  emp.picture,emp.eno,emp.desgn,emp.ename,emp.dept,paymast.month,paymast.year,paymast.salary,paymast.da,paymast.ta,paymast.hra,paymast.spall,paymast.gross" + 
				"	FROM emp" + 
				"	INNER JOIN paymast" + 
				"	ON emp.eno = paymast.eno where month=? && year=?");
		pt.setString(1, month);
		pt.setInt(2, year);
		ResultSet rs=pt.executeQuery();
		return rs;
	}
	public ResultSet gettotalda(int year,String month) throws SQLException
	{
		PreparedStatement pt=cn.prepareStatement("SELECT SUM(da),sum(da),sum(ta),sum(hra),sum(spall),sum(salary),sum(gross) FROM paymast where month=? && year=?");
		pt.setString(1, month);
		pt.setInt(2, year);
		ResultSet rs=pt.executeQuery();
		return rs;
	}
	
	
	
	
	
}
