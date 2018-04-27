package ent;

public class Books {
	private int BookID=0;
	private String BookName="";
	private String BookType="";
	private String Author="";
	private float Price=0;
	private String Remark="";
	public int getBookID() {
		return BookID;
	}
	public void setBookID(int bookID) {
		BookID = bookID;
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
