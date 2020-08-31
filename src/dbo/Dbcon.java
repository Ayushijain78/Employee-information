package dbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbcon 
{
	

	
		Connection cn;
		Statement st;
		ResultSet rs;
		
		public  Dbcon() throws ClassNotFoundException,SQLException 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			st=cn.createStatement();
		}

		public ResultSet getRecords() throws SQLException 
		{
			ResultSet rs=st.executeQuery("select * from emp");
			return rs;
		}
		public ResultSet getEmp(int eno) throws SQLException
		{
			ResultSet rs=st.executeQuery("select *from emp where eno="+eno);
			return rs;
		}
		public int insertEmp(String ename,String dob,String gender,String email,String mobile,String city,String state,String dept,String desgn,int salary,String address,String picture)throws SQLException
		{
			PreparedStatement pt=cn.prepareStatement("insert into emp(ename,dob,gender,email,mobile,city,state,dept,desgn,salary,address,picture)values(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pt.setString(1,ename);
			pt.setString(2,dob);
			pt.setString(3,gender);
			pt.setString(4,email);
			pt.setString(5,mobile);
			pt.setString(6,city);
			pt.setString(7,state);
			pt.setString(8,dept);
			pt.setString(9,desgn);
			pt.setInt(10,salary);
			pt.setString(11,address);
			pt.setString(12, picture);
						
			int x=pt.executeUpdate();
			return x;
		}
		public int updatetEmp(int eno,String ename,String email,String mobile,String city,String state,String dept,String desgn,int salary,String picture, String picture2)throws SQLException
		{
			PreparedStatement pt=cn.prepareStatement("update emp set ename=?,email=?,mobile=?,city=?,state=?,dept=?,desgn=?,salary=?,picture=?,address=? where eno=?");
			
			pt.setString(1,ename);
			pt.setString(2,email);
			pt.setString(3,mobile);
			pt.setString(4,city);
			pt.setString(5,state);
			pt.setString(6,dept);
			pt.setString(7,desgn);
			pt.setInt(8,salary);
			
			pt.setString(9, picture);
			pt.setString(10,picture2);
			pt.setInt(11,eno);
			
			int x=pt.executeUpdate();
			return x;		
		}
		
		public int deleteEmp(int eno) throws SQLException
		{
			int x=st.executeUpdate("delete from emp where eno="+eno);
			return x;
		}
		
		public ResultSet adminlogin(String id,String pwd)throws SQLException
		{
			PreparedStatement pt=cn.prepareStatement("select * from admin where email=? or phone=? and pwd=?");
			pt.setString(1,id);
			pt.setString(2,id);
			pt.setString(3,pwd);
			ResultSet rs=pt.executeQuery();
			return rs;
			
		}
		public ResultSet alldept()throws SQLException
		{
			st=cn.createStatement();
			ResultSet rs=st.executeQuery("select distinct dept from department ");
			return rs;
		}
		public ResultSet alldesgn()throws SQLException
		{
			st=cn.createStatement();
			ResultSet rs=st.executeQuery("select distinct desgn from designation ");
			return rs;
		}
		
}

