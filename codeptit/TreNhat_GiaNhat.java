import java.util.*;
public class TreNhat_GiaNhat {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();

		Person min, max, input;
		input = Person.toPerson(in.nextLine());
		min = input;
		max = input;

		for(int i = 1; i < n; i++){
			input = Person.toPerson(in.nextLine());
			if(input.getDateOfBirth().compareTo(min.getDateOfBirth()) < 0)
				min = input;
			if(input.getDateOfBirth().compareTo(max.getDateOfBirth()) > 0)
				max = input;
		}

		System.out.println(max.getName() + "\n" + min.getName());

		
	}
}

class Person{
	private String name;
	private Date dateOfBirth;

	public static Person toPerson(String text){
		String []s = text.split(" ");
		return new Person(s[0], Date.toDate(s[1]));
	}
	public Person(String name, Date dateOfBirth){
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfBirth(){
		return dateOfBirth;
	}

	public String getName(){
		return name;
	}
}

class Date{
	private int day;
	private int month;
	private int year;

	public static Date toDate(String text){
		String []s = text.split("/");
		int d = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int y = Integer.parseInt(s[2]);
		return new Date(d, m, y);
	}

	public Date(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int compareTo(Date other){
		if(this.year - other.year != 0)	
			return (this.year - other.year);
		if(this.month - other.month != 0)
			return (this.month - other.month);
		return (this.day - other.day);
	}
}