import java.sql.*;
import javax.swing.*;

public class DbConnect {
	
	public static Connection myconnector()         //static method for connection of database...    
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");    //accessing JDBC driver
		Connection conn = DriverManager.getConnection("jdbc:mysql://societydb.c1uwejlvz6kt.ap-south-1.rds.amazonaws.com:3306/lib", "admin", "beproj$21");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Lib", "root", "manik@12345");
		System.out.println("Connected successfully");
		return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
		    return null;
		}	
	}
	
}
