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
import ent.Books;
import ent.BorrowedBooks;

public class BooksServ extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String uri=req.getRequestURI();
		uri=uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		BookDao d=new BookDao();
		//图书添加;
		if(uri.equals("/AddBook")){
			String BookName=req.getParameter("BookName");
			String BookType=req.getParameter("BookType");
			String Author=req.getParameter("Author");
			Float Price=Float.parseFloat(req.getParameter("Price"));
			String Remark=req.getParameter("Remark");
			Books b=new Books();
			b.setBookName(BookName);
			b.setBookType(BookType);
			b.setAuthor(Author);
			b.setPrice(Price);
			b.setRemark(Remark);
			try {
				d.saveBook(b);
				req.getRequestDispatcher("AddBook.jsp").forward(req, res);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//显示所有图书;
		else if(uri.equals("/bookshow")){
			List<Books> books=new ArrayList<Books>();
			try {
				books=d.showAll();
				req.setAttribute("bookslist", books);
				req.getRequestDispatcher("page/ShowBook.jsp").forward(req, res);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//图书搜索;按输入的图书名搜索
		else if(uri.equals("/searchalter")){
			String AlterBookName=req.getParameter("AlterBookName");
			try {
				Books b=d.searchBooks(AlterBookName);
				if(b!=null){
					req.setAttribute("booksinfo", b);
					req.getRequestDispatcher("page/AlterBook_1.jsp").forward(req, res);
				}else if(b==null){
					req.getRequestDispatcher("noSearch.jsp").forward(req, res);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//修改图书信息（先删除再增加）;
		else if(uri.equals("/bookalterbefore")){
			List<Books> books=new ArrayList<Books>();
			try {
				books=d.showAll();
				req.setAttribute("bookslist", books);
				req.getRequestDispatcher("page/AlterBook.jsp").forward(req, res);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(uri.equals("/AlterBook")){
			String OldBookName=req.getParameter("OldBookName");
			String BookName=req.getParameter("BookName");
			String BookType=req.getParameter("BookType");
			String Author=req.getParameter("Author");
			Float Price=Float.parseFloat(req.getParameter("Price"));
			String Remark=req.getParameter("Remark");
			Books b=new Books();
			b.setBookName(BookName);
			b.setBookType(BookType);
			b.setAuthor(Author);
			b.setPrice(Price);
			b.setRemark(Remark);
			try {
				Books b1=d.deleteBooks(OldBookName);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				d.saveBook(b);
				System.out.println("here?");
				req.getRequestDispatcher("bookalterbefore.da").forward(req, res);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//删除图书
		else if(uri.equals("/bookdeletebefore")){
			List<Books> books=new ArrayList<Books>();
			try {
				books=d.showAll();
				req.setAttribute("bookslist", books);
				req.getRequestDispatcher("page/DeleteBook.jsp").forward(req, res);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(uri.equals("/DeleteBook")){
			String DeleteBookName=req.getParameter("DeleteBookName");
			try {
				Books b=d.deleteBooks(DeleteBookName);
				if(b!=null){
					req.getRequestDispatcher("bookdeletebefore.da").forward(req, res);
				}else if(b==null){
					req.getRequestDispatcher("noSearch.jsp").forward(req, res);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//显示所有图书后再点击查看详情
		else if(uri.equals("/Detail")){
			String DetailBookName=req.getParameter("DetailBookName");
			try {
				Books b=d.searchBooks(DetailBookName);
				if(b!=null){
					req.setAttribute("booksinfo", b);
					req.getRequestDispatcher("page/DetailBook.jsp").forward(req, res);
					
				}else if(b==null){
					req.getRequestDispatcher("noSearch.jsp").forward(req, res);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//显示当前用户没有借过的书籍
		else if(uri.equals("/borrowbook")){
			List<Books> books=new ArrayList<Books>();
			List<BorrowedBooks> borrowedbooks=new ArrayList<BorrowedBooks>();
			String Borrower=req.getParameter("borrower");
			try {
				books=d.showAll();
				borrowedbooks=d.showAllBorrowed(Borrower);
				req.setAttribute("bookslist", books);
				req.setAttribute("borrowedbookslist", borrowedbooks);
				req.setAttribute("borrower", Borrower);
				req.getRequestDispatcher("page/BorrowBook.jsp").forward(req, res);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//能借阅的书籍展示详情并提供借阅
		else if(uri.equals("/BorrowBookDetail")){
			String DetailBookName=req.getParameter("DetailBookName");
			String Borrower=req.getParameter("borrower");
			String Count=req.getParameter("Count");
			try {
				Books b=d.searchBooks(DetailBookName);
				if(b!=null){
					req.setAttribute("booksinfo", b);
					req.setAttribute("borrower", Borrower);
					req.setAttribute("Count", Count);
					req.getRequestDispatcher("page/BorrowedDetail.jsp").forward(req, res);
					
				}else if(b==null){
					req.getRequestDispatcher("noSearch.jsp").forward(req, res);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//借书;
		else if(uri.equals("/borrowing")){
			String BorrowedBookName=req.getParameter("borrowedbookname");
			String Borrower=req.getParameter("borrower");
			try {
				d.borrowBook(BorrowedBookName, Borrower);
				req.setAttribute("borrower", Borrower);
				req.getRequestDispatcher("borrowbook.da").forward(req, res);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(uri.equals("/showborrowedbook")){
			List<BorrowedBooks> books=new ArrayList<BorrowedBooks>();
			String Borrower=req.getParameter("borrower");
			try {
				books=d.showAllBorrowed(Borrower);
				req.setAttribute("bookslist", books);
				req.getRequestDispatcher("page/ShowBorrowedBook.jsp").forward(req, res);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(uri.equals("/PreReadDetail")){
			String DetailBookName=req.getParameter("DetailBookName");
			String Borrower=req.getParameter("borrower");
			try {
				Books b=d.searchBooks(DetailBookName);
				if(b!=null){
					req.setAttribute("booksinfo", b);
					req.setAttribute("borrower", Borrower);
					req.getRequestDispatcher("page/PreRead.jsp").forward(req, res);
					
				}else if(b==null){
					req.getRequestDispatcher("noSearch.jsp").forward(req, res);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(uri.equals("/deleteborrowedbook")){
			List<BorrowedBooks> books=new ArrayList<BorrowedBooks>();
			String Borrower=req.getParameter("borrower");
			try {
				books=d.showAllBorrowed(Borrower);
				req.setAttribute("bookslist", books);
				req.getRequestDispatcher("page/DeleteBorrowedBook.jsp").forward(req, res);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(uri.equals("/Deleteonebook")){
			String BookName=req.getParameter("DeleteBookName");
			String Borrower=req.getParameter("borrower");
			try {
				d.deleteBorrowedBooks(BookName, Borrower);
				req.setAttribute("borrower", Borrower);
				req.getRequestDispatcher("deleteborrowedbook.da").forward(req, res);
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
