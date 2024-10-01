
import java.util.*;
public class SapXepDanhSachDoiTuongNhanVien {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int nTestCase = in.nextInt();
		in.nextLine();

		Employee []arr = new Employee[nTestCase];
		for(int i = 0; i < nTestCase; i++){
			arr[i] = Employee.getInput(in);
		}

		Arrays.sort(arr, (a, b)-> (a.getDateOfBirth().compareTo(b.getDateOfBirth())) );
		for (Employee e : arr){
			System.out.println(e.toString());
		}
	}
}

class Date{
	private int year;
	private int month;
	private int day;

	public Date(String text){
		String []s = text.split("/");
		this.day = Integer.parseInt(s[0]);
		this.month = Integer.parseInt(s[1]);
		this.year = Integer.parseInt(s[2]);
	}

	public int compareTo(Date other){
		if(this.year != other.year)
			return this.year - other.year;
		if(this.month != other.month)
			return this.month - other.month;
		return this.day - other.day;
	}

	public String toString(){
		return String.format("%02d/%02d/%02d",day, month, year);
	}
}

class Employee{
	private static int nextID = 1;
	private static String []strSex = {"Nam", "Nu"};

	private int id;
	private String name;
	private int sex;
	private Date dateOfBirth;
	private String address;
	private String taxCode;
	private Date contractDate;

	public static Employee getInput(Scanner in){
		// Scanner in = new Scanner(System.in);
		Employee e = new Employee(
			in.nextLine(),
			(in.nextLine().compareTo("Nam") == 0)?((int)0):((int)1),
			new Date(in.nextLine()),
			in.nextLine(),
			in.nextLine(),
			new Date(in.nextLine())
		);
		//in.close();
		return e;
	}
	

	public Employee(String name, int sex, Date dateOfBirth, String address, String taxCode, Date contractDate){
		this.id = nextID++;
		this.name = name;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.taxCode = taxCode;
		this.contractDate = contractDate;
	}

	

	public Date getDateOfBirth(){
		return dateOfBirth;
	}

	public String toString(){
		return String.format(
			"%05d %s %s %s %s %s %s",
			id, name, strSex[sex], dateOfBirth.toString(), address, taxCode, contractDate.toString()	
		);
	}
}
