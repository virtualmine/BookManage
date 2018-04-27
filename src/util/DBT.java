package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBT {
	public static Connection getcon() throws ClassNotFoundException, SQLException{
		String userName="root";
	    String userPwd="root";
	    String dbName="BookManage";
	    String url1="jdbc:mysql://localhost:3306/"+dbName;
	    String url2="?user="+userName+"&password="+userPwd;
	    String url3="&useSSL=false&useUnicode=true&characterEncoding=UTF-8";
	    String url=url1+url2+url3;
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url);
		return con;
	}	
}
