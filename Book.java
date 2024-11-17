public class Book {
	String bookName;
	String ISBN;
	double price;
	int noOfPages;
	String pubName;
	Author author;
	boolean isIssued;
	
	public Book() {
		author = new Author();
	}
	
	public Book(String bookName, String iSBN, double price, int noOfPages, String pubName, Author author) {
		this.bookName = bookName;
		ISBN = iSBN;
		this.price = price;
		this.noOfPages = noOfPages;
		this.pubName = pubName;
		this.author = author;
		this.isIssued = false;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNoOfPages() {
		return noOfPages;
	}
	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}
	public String getPubName() {
		return pubName;
	}
	public void setPubName(String pubName) {
		this.pubName = pubName;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", ISBN=" + ISBN + ", price=" + price + ", noOfPages=" + noOfPages
				+ ", pubName=" + pubName + ", author=" + author + "]";
	}
	
 
}
