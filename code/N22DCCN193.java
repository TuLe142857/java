
import java.util.*;
public class N22DCCN193 {
//-----------------------------------------------------------------
//						TEST PROGRAM
//-----------------------------------------------------------------
	private static Scanner in;
	public static void main(String []args){
		in = new Scanner(System.in);
		choose(1, 2);
	}	


	public static int choose(int a, int b){
		int c = 0;
		do{
			System.out.print("Choose(" + a + " to " + b + "): ");
			c = in.nextInt();
			in.nextLine();
		}while(!(c >= a && c <= b));
		return c;
	}
}

//-----------------------------------------------------------------
//						DOCUMENT
//-----------------------------------------------------------------
abstract class Document implements Comparable<Document>{
	protected String id;
	protected String publisher;
	protected int totalPublised;

	public Document(String id, String publisher, int totalPublised){
		this.id = id;
		this.publisher = publisher;
		this.totalPublised = totalPublised;
	}

	public int compareTo(Document o){
		return this.id.compareTo(o.id);
	}

	public abstract String toString();
}

//-----------------------------------------------------------------
//						BOOK
//-----------------------------------------------------------------
class Book extends Document{
	private String author;
	private int totalPages;

	public Book(String author, int totalPages, String id, String publisher, int totalPublised){
		super(id, publisher, totalPublised);
		this.author = author;
		this.totalPages = totalPages;
	}

	public String toString(){
		return String.format(
			"Book id: %s, author: %s, publisher: %s, total pages: %d, total published: %d",
			id, author, publisher, totalPages, totalPublised);
	}
}

//-----------------------------------------------------------------
//						MAGAGINE
//-----------------------------------------------------------------
class Magazine extends Document{
	private int number;
	private int month;

	public Magazine(int number, int month, String id, String publisher, int totalPublised){
		super(id, publisher, totalPublised);
		this.number = number;
		this.month = month;
	}

	public String toString(){
		return String.format(
			"Magagine id: %s number: %d, month: %d, publisher: %s, "
		)
	}

}
//-----------------------------------------------------------------
//						NEWSPAPER
//-----------------------------------------------------------------