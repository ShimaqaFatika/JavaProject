
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
 
public class Library extends Thread {
	String libName;
	String libAddress;
	String libContact;
	String libEmail;
	String libOwner;
	public ArrayList<Book> books;
	// Threads
	Thread t = new Thread();
 
	// int Max_books = 50;
	int index = 0;
	String arr[] = new String[50];
	int available[] = new int[50];
 
	// int c=0;
	
	//Files
		public static void write(String fileName, String book) throws IOException {
			try (FileOutputStream fout = new FileOutputStream(fileName, true)) {
				//fout.write(System.lineSeparator().getBytes());
				fout.write(book.getBytes());
				fout.write(System.lineSeparator().getBytes());
				fout.flush();
			}	
 
		}
 
 
	public Library() {
		books = new ArrayList<>();
		// books = new Book[Max_books];
		System.out.println("Library default constructor..");
	}
 
	public Library(String libName, String libAddress, String libContact, String libEmail, String libOwner) {
		// books = new Book[Max_books];
		books = new ArrayList<>();
		this.libName = libName;
		this.libAddress = libAddress;
		this.libContact = libContact;
		this.libEmail = libEmail;
		this.libOwner = libOwner;
 
	}
 
	public void addBook(Book book) {
		books.add(book);
		arr[index] = book.ISBN;
		available[index] = 1;
		index++;
		try {
			write("src/files/books.txt",book.getBookName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Book added successfully");
 
	}
 
	public void printAllBooks() throws BookNotFoundException {
		if(books.isEmpty()) {
			throw new BookNotFoundException("No books available");
		}
		Iterator<Book> itr = books.iterator();
		while (itr.hasNext()) {
			Book temp = itr.next();
			for (int i = 0; i <= index; i++) {
				if (arr[i] != null && available[i] == 1) {
					System.out.println(temp);
					// Threads
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}
 
	public void searchBook(String isbn) throws BookNotFoundException {
		boolean flag = false;
		Iterator<Book> itr = books.iterator();
		while (itr.hasNext()) {
			Book temp = itr.next();
			for (int i = 0; i <= index; i++) {
				if (temp.getISBN().equalsIgnoreCase(isbn) && arr[i].equalsIgnoreCase(isbn) && available[i] == 1) {
					System.out.println(temp);
					flag = true;
					break;
				}
			}
		}
		if (!flag) {
			throw new BookNotFoundException("Book not found");
		}
 
	}
 
	public void deleteBook(String isbn) throws BookNotFoundException {
		boolean flag = false;
		Book temp;
		Iterator<Book> itr = books.iterator();
		while (itr.hasNext()) {
			temp = itr.next();
			for (int i = 0; i <= index; i++) {
				if (arr[i] != null && temp.getISBN().equalsIgnoreCase(isbn) && arr[i].equalsIgnoreCase(isbn)
						&& available[i] == 1) {
					itr.remove();
					arr[i] = null;
					available[i] = 0;
					System.out.println("Book deleted");
					flag = true;
				}
			}
		}
		if (!flag) {
			throw new BookNotFoundException("Book not found");
		}
	}
 
	public void issueBook(String isbn) throws BookNotFoundException {
		Book temp;
		boolean flag = false;
		Iterator<Book> itr = books.iterator();
		while (itr.hasNext()) {
			temp = itr.next();
			for (int i = 0; i <= index; i++) {
				if (arr[i] != null && temp.getISBN().equalsIgnoreCase(isbn) && arr[i].equalsIgnoreCase(isbn)
						&& available[i] == 1) {
					System.out.println("Book Issued");
					available[i] = 0;
					flag = true;
				}
			}
		}
		if (!flag) {
			throw new BookNotFoundException("Book not found");
		}
 
	}
 
	public void returnBook(String isbn) throws BookNotFoundException {
		Book temp;
		boolean flag = false;
		Iterator<Book> itr = books.iterator();
		while (itr.hasNext()) {
			temp = itr.next();
			for (int i = 0; i <= index; i++) {
				if (arr[i] != null && temp.getISBN().equalsIgnoreCase(isbn) && arr[i].equalsIgnoreCase(isbn)
						&& available[i] == 0) {
					System.out.println("Book Returned");
					available[i] = 1;
					flag = true;
				}
			}
		}
		if (!flag) {
			throw new BookNotFoundException("Book not found");
		}
 
	}
 
	public void sortByName() {
		books.sort(Comparator.comparing(Book::getBookName));
		for (Book bo : books) {
			System.out.println(bo);
		}
	}
 
	public String getLibName() {
		return libName;
	}
 
	public void setLibName(String libName) {
		this.libName = libName;
	}
 
	public String getLibAddress() {
		return libAddress;
	}
 
	public void setLibAddress(String libAddress) {
		this.libAddress = libAddress;
	}
 
	public String getLibContact() {
		return libContact;
	}
 
	public void setLibContact(String libContact) {
		this.libContact = libContact;
	}
 
	public String getLibEmail() {
		return libEmail;
	}
 
	public void setLibEmail(String libEmail) {
		this.libEmail = libEmail;
	}
 
	public String getLibOwner() {
		return libOwner;
	}
 
	public void setLibOwner(String libOwner) {
		this.libOwner = libOwner;
	}
 
	/*
	 * public String[] getBook() { return Book; } public void setBook(String[] book)
	 * { Book = book; }
	 */
	@Override
	public String toString() {
		return "Library [Library Name= " + libName + ", Library Address= " + libAddress + ", Library Contact= "
				+ libContact + ", Library Email= " + libEmail + ", Library Owner= " + libOwner;
	}
	
	
	/*public static void main(String[] args) throws IOException {
		write("src/files/books.txt",);
	}*/
 
}
