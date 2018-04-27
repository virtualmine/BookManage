package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ent.Books;
import ent.User;
import util.CloseDB;
import util.DBT;

public class UserDao {
	public void saveUser(User u) throws SQLException, ClassNotFoundException{
		Connection con=null;
		con=DBT.getcon();
		String sql="insert into users(UserName,UserPwd) values (?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, u.getUserName());
		pst.setString(2, u.getUserPwd());
		pst.executeUpdate();
		con.close();
	}
	public User findBy(String username,String pwd) throws ClassNotFoundException, SQLException{
		User u=null;
		Connection con=DBT.getcon();
		String sql="select * from users where UserName=? and UserPwd=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, username);
		pst.setString(2, pwd);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			u=new User();
			u.setUserName(rs.getString("UserName"));
			u.setUserPwd(rs.getString("UserPwd"));
		}
		return u;
	}
	public List<User> showAll() throws ClassNotFoundException, SQLException{
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		User u=null;
		con=DBT.getcon();
		List<User> users=new ArrayList<User>();
		String sql="select * from Users";
		pst=con.prepareStatement(sql);
		rs=pst.executeQuery();
		while(rs.next()){
			u=new User();
			u.setUserName(rs.getString("UserName"));
			u.setUserPwd(rs.getString("UserPwd"));
			users.add(u);
		}
		CloseDB.CloseDB(con, pst, rs);
		return users;
	}
	public void deleteUser(String DeleteUserName) throws ClassNotFoundException, SQLException{
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		con=DBT.getcon();
		String sql="delete from Users where UserName=?";
		pst=con.prepareStatement(sql);
		pst.setString(1, DeleteUserName);
		pst.executeUpdate();
		//CloseDB.CloseDB(con, pst, rs);
	}
}
