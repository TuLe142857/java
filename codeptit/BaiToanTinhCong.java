import java.util.*;
public class BaiToanTinhCong {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		Employee e = new Employee(
			in.nextLine(),
			Integer.parseInt(in.nextLine()),
			Integer.parseInt(in.nextLine()),
			in.nextLine()
		);
		System.out.println(e.toString());
	}
}

class Employee{
	private static int nextID = 1;
	private String id;
	private String name;
	private int salaryPerDay;
	private int daysWork;
	private String position;

	public Employee(String name, int salaryPerDay, int daysWork, String position){
		this.id = String.format("NV%02d", nextID++);
		this.name = name;
		this.salaryPerDay = salaryPerDay;
		this.daysWork = daysWork;
		this.position = position;
	}

	public int getMonthlySalary(){
		return salaryPerDay * daysWork;
	}

	public int getBonus(){
		if(daysWork >= 25)
			return (int)(getMonthlySalary()*(0.2));
		if(daysWork >= 22)
			return (int)(getMonthlySalary()*(0.1));
		return 0;
	}

	public int getPhuCap(){
		switch (position){
			case "GD":
				return 250000;
			case "PGD":
				return 200000;
			case "TP":
				return 180000;
			case "NV":
				return 150000;
			default:
				return 0;
		}
	}

	public int getTotalIncome(){
		return getMonthlySalary() + getBonus() + getPhuCap();
	}

	public String toString(){
		return String.format(
			"%s %s %d %d %d %d",
			id, name, getMonthlySalary(), getBonus(), getPhuCap(), getTotalIncome()
		);
	}
}
