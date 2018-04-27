package ent;

public class BorrowedBooks {
	private String Borrower="";
	private String BookName="";
	private String BookType="";
	private String Author="";
	private float Price=0;
	private String Remark="";
	public String getBorrower() {
		return Borrower;
	}
	public void setBorrower(String borrower) {
		Borrower = borrower;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getBookType() {
		return BookType;
	}
	public void setBookType(String bookType) {
		BookType = bookType;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	
}
