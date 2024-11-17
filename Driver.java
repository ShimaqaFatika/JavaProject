import java.util.Collections;
import java.util.Scanner;
 
public class Driver {
 
	public static void main(String[] args) throws BookNotFoundException {
		Scanner sc = new Scanner(System.in);
		Library l = new Library();
		//Library l = new Library("Central Library","Hyderabad, Telangana - 500064","9000283671","centrallib@gmail.com","Lara Goel");
		//System.out.println(l.toString());
		
		int ch = 0;
		do {
			System.out.println("Menu:");
			System.out.println("1. Add Book");
			System.out.println("2. Search Book by Id or Name");
			System.out.println("3. Print all books");
			System.out.println("4. Delete Book");
			System.out.println("5. Issue Book");
			System.out.println("6. Return Book");
			System.out.println("7. Sort books by price");
			System.out.println("8. Sort books by name");
			System.out.println("9. Exit");
			System.out.println("Enter your choice:");
			ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter Book name");
		    	String bookname=sc.next();
		    	System.out.println("Enter ISBN");
		    	String isbnno=sc.next();
		    	System.out.println("Enter Price");
		    	double  price=sc.nextDouble();
		    	System.out.println("Enter no.of pages");
		    	int pages=sc.nextInt();
		    	System.out.println("Enter publisher name");
		    	String pubname=sc.next();
		    	System.out.println("Enter Author");
		    	String autname=sc.next();
		    	System.out.println("Enter AuthorId");
		    	int autId=sc.nextInt();
		    	System.out.println("Enter author Contact");
		    	String autcon=sc.next();
		    	System.out.println("Enter author email");
		    	String autemail=sc.next();
		    	Author author = new Author(autname, autId,autcon,autemail);
		    	Book book = new Book(bookname,isbnno,price,pages,pubname,author);
		    	//Library l = new Library();
		    	l.addBook(book);
		    	
				break;
			case 2:
				//searchBook();
				System.out.println("Enter isbn of the book you want to search: ");
				String a = sc.next();
				try {
					l.searchBook(a);
				} catch (BookNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				//printBooks();
				try {
					l.printAllBooks();
				} catch (BookNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				//deleteBook();
				System.out.println("Enter isbn of the book you want to delete: ");
				String b = sc.next();
				try {
					l.deleteBook(b);
				} catch (BookNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				//issueBook();
				System.out.println("Enter isbn");
				String is = sc.next();
				try {
					l.issueBook(is);
				} catch (BookNotFoundException e) {
					e.printStackTrace();
				}
				
				break;
			case 6:
				//returnBook();
				System.out.println("Enter isbn");
				String returnBook = sc.next();
				try {
					l.returnBook(returnBook);
				} catch (BookNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 7:
				Collections.sort(l.books, new BookPriceComparator());
				System.out.println("Books sorted based on price:");
				for(Book bo: l.books) {
					System.out.println(bo);
					
				}
				break;
			case 8:
				System.out.println("Books sorted by name:");
				l.sortByName();
				break;
			case 9:
				ch = -1;
				System.out.println("Exited from menu!!");
				break;
			default:
				System.out.println("Invalid input!!");
				break;
			}
		}while(ch>0 && ch<9);
 
	}
 
}
 
