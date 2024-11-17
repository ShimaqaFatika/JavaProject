public class Author {
	String authorName;
	int authorId;
	String authorContact;
	String authorEmail;
	public Author(String authorName, int authorId, String authorContact, String authorEmail) {
		this.authorName = authorName;
		this.authorId = authorId;
		this.authorContact = authorContact;
		this.authorEmail = authorEmail;
	}
	
	public Author() {
		System.out.println("Author default constr...");
	}
 
	@Override
	public String toString() {
		return "Author [authorName=" + authorName + ", authorId=" + authorId + ", authorContact=" + authorContact
				+ ", authorEmail=" + authorEmail + "]";
	}
	
 
}
