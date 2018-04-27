package action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dao.UserDao;
import ent.Books;
import ent.User;

public class UserServ extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String uri=req.getRequestURI();
		uri=uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		UserDao d=new UserDao();
		BookDao bd=new BookDao();
		if(uri.equals("/Login")){
			String uname=req.getParameter("UserName");
			String upassword=req.getParameter("UserPwd");
			try {
				User u=d.findBy(uname, upassword);
				if(u!=null){
					req.setAttribute("uname", uname);
					req.getRequestDispatcher("Main.jsp").forward(req, res);
				}else{
					res.sendRedirect("Login.jsp");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(uri.equals("/Register")){
			String uname=req.getParameter("UserName");
			String upassword=req.getParameter("UserPwd");
			User u=new User();
			u.setUserName(uname);
			u.setUserPwd(upassword);
			try {
				d.saveUser(u);
				req.setAttribute("flag", "Y");
				req.getRequestDispatcher("Login.jsp").forward(req, res);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(uri.equals("/DeleteUsers")){
			List<User> users=new ArrayList<User>();
			try {
				users=d.showAll();
				req.setAttribute("userslist", users);
				req.getRequestDispatcher("page/DeleteUsers.jsp").forward(req, res);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(uri.equals("/DeleteU")){
			String DeleteUserName=req.getParameter("dltu");
			try {
				d.deleteUser(DeleteUserName);
				bd.deleteUsersbooks(DeleteUserName);
				req.getRequestDispatcher("DeleteUsers.do").forward(req, res);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
