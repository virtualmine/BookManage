package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ent.Books;
import ent.BorrowedBooks;
import util.CloseDB;
import util.DBT;

public class BookDao {
	public void saveBook(Books b) throws SQLException, ClassNotFoundException{
		Connection con=null;
		con=DBT.getcon();
		String sql="insert into Books(BookName,BookType,Author,Price,Remark) values (?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, b.getBookName());
		pst.setString(2, b.getBookType());
		pst.setString(3, b.getAuthor());
		pst.setFloat(4, b.getPrice());
		pst.setString(5, b.getRemark());
		pst.executeUpdate();
		con.close();
	}
	public List<Books> showAll() throws ClassNotFoundException, SQLException{
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Books b=null;
		con=DBT.getcon();
		List<Books> books=new ArrayList<Books>();
		String sql="select * from Books";
		pst=con.prepareStatement(sql);
		rs=pst.executeQuery();
		while(rs.next()){
			b=new Books();
			b.setBookName(rs.getString("BookName"));
			b.setBookType(rs.getString("BookType"));
			b.setAuthor(rs.getString("Author"));
			b.setPrice(rs.getFloat("Price"));
			b.setRemark(rs.getString("Remark"));
			books.add(b);
		}
		CloseDB.CloseDB(con, pst, rs);
		return books;
	}
	public Books searchBooks(String AlterBookName) throws ClassNotFoundException, SQLException{
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Books b=null;
		con=DBT.getcon();
		String sql="select * from Books where BookName=?";
		pst=con.prepareStatement(sql);
		pst.setString(1, AlterBookName);
		rs=pst.executeQuery();
		b = getBooks(rs, b);
		CloseDB.CloseDB(con, pst, rs);
		return b;
	}

	private Books getBooks(ResultSet rs, Books b) throws SQLException {
		while(rs.next()){
			b=new Books();
			b.setBookName(rs.getString("BookName"));
			b.setBookType(rs.getString("BookType"));
			b.setAuthor(rs.getString("Author"));
			b.setPrice(rs.getFloat("Price"));
			b.setRemark(rs.getString("Remark"));
		}
		return b;
	}

	public Books deleteBooks(String DeleteBookName) throws ClassNotFoundException, SQLException{
		System.out.println("come here?");
		System.out.println(DeleteBookName);
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Books b=null;
		con=DBT.getcon();
		String sql="select * from Books where BookName=?";
		pst=con.prepareStatement(sql);
		pst.setString(1, DeleteBookName);
		rs=pst.executeQuery();
		b = getBooks(rs, b);
		String sql2="delete from Books where BookName=?";
		pst=con.prepareStatement(sql2);
		pst.setString(1, DeleteBookName);
		pst.executeUpdate();
		return b;
	}
	public void borrowBook(String borrowedbookname,String borrower) throws ClassNotFoundException, SQLException{
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Books b=null;
		BorrowedBooks bb=null;
		con=DBT.getcon();
		String sql="select * from Books where BookName=?";
		pst=con.prepareStatement(sql);
		pst.setString(1, borrowedbookname);
		rs=pst.executeQuery();
		while(rs.next()){
			bb=new BorrowedBooks();
			bb.setBorrower(borrower);
			System.out.println(bb.getBorrower());
			bb.setBookName(rs.getString("BookName"));
			bb.setBookType(rs.getString("BookType"));
			bb.setAuthor(rs.getString("Author"));
			bb.setPrice(rs.getFloat("Price"));
			bb.setRemark(rs.getString("Remark"));
			String sql2="insert into BorrowedBooks(Borrower,BookName,BookType,Author,Price,Remark) values (?,?,?,?,?,?)";
			pst=con.prepareStatement(sql2);
			pst.setString(1, bb.getBorrower());
			pst.setString(2, bb.getBookName());
			pst.setString(3, bb.getBookType());
			pst.setString(4, bb.getAuthor());
			pst.setFloat(5, bb.getPrice());
			pst.setString(6, bb.getRemark());
			pst.executeUpdate();
		}
		
	}
	public List<BorrowedBooks> showAllBorrowed(String Borrower) throws ClassNotFoundException, SQLException{
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		BorrowedBooks b=null;
		con=DBT.getcon();
		List<BorrowedBooks> books=new ArrayList<BorrowedBooks>();
		String sql="select * from BorrowedBooks where Borrower=?";
		pst=con.prepareStatement(sql);
		pst.setString(1, Borrower);
		rs=pst.executeQuery();
		while(rs.next()){
			b=new BorrowedBooks();
			b.setBorrower(rs.getString("Borrower"));
			b.setBookName(rs.getString("BookName"));
			b.setBookType(rs.getString("BookType"));
			b.setAuthor(rs.getString("Author"));
			b.setPrice(rs.getFloat("Price"));
			b.setRemark(rs.getString("Remark"));
			books.add(b);
		}
		CloseDB.CloseDB(con, pst, rs);
		return books;
	}
	public void deleteBorrowedBooks(String DeleteBookName,String Borrower) throws ClassNotFoundException, SQLException{
		Connection con=null;
		PreparedStatement pst=null;
		con=DBT.getcon();
		String sql="delete from BorrowedBooks where BookName=? and Borrower=?";
		pst=con.prepareStatement(sql);
		pst.setString(1, DeleteBookName);
		pst.setString(2, Borrower);
		pst.executeUpdate();
	}
	public void deleteUsersbooks(String Borrower) throws ClassNotFoundException, SQLException{
		Connection con=null;
		PreparedStatement pst=null;
		con=DBT.getcon();
		String sql="delete from BorrowedBooks where Borrower=?";
		pst=con.prepareStatement(sql);
		pst.setString(1, Borrower);
		pst.executeUpdate();
	}
}
