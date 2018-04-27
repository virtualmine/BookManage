package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class CloseDB {
	public static void CloseDB(Connection con,PreparedStatement pstm,ResultSet rs){
		
			try {
				if(rs!=null)rs.close();
				if(pstm!=null)rs.close();
				if(con!=null)rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
}
