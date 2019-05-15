package yalla;

import java.sql.*;

public class ttry {

	public static void main(String args[]){  
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/testing?useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","12345abcd");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from lecturer");  
			while(rs.next())  {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
			}
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
	}  

}
