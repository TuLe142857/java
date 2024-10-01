import java.util.*;
public class BangDiemHocSinh {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int nTest = in.nextInt();
		in.nextLine();
		Student []arr = new Student[nTest];

		for(int i = 0; i < nTest; i++)
			arr[i] = Student.getInput(in);
		Arrays.sort(arr, (a, b)->(b.compareTo(a)));
		for(Student i : arr)
			System.out.println(i.toString());
		
	}
}

class Student{
	private static int nextID = 1;

	private int id;
	private String name;
	private double []score;

	public static Student getInput(Scanner in){
		String name = in.nextLine();
		double []score = new double[10];
		for(int i = 0; i < 10; i++)
			score[i] = in.nextDouble();
		in.nextLine();
		return new Student(name, score);
	}

	public Student(String name, double []score){
		this.id = nextID++;
		this.name = name;
		this.score = score;
	}

	public double getAverageScore(){
		double sum = score[0] + score[1];
		for (double i : score)
			sum += i;
		sum /= 12;
		return sum;
		// return (double)(Math.round(sum*10))/10;
	}

	public String getClassify(){
		double avg = getAverageScore();
		if(avg >= 9)
			return "XUAT SAC";
		if(avg >= 8)
			return "GIOI";
		if(avg >= 7)
			return "KHA";
		if(avg >= 5)
			return "TB";
		return "YEU";
	}

	public int compareTo(Student other){
		double cmp = this.getAverageScore() - other.getAverageScore();
		if(cmp >0)
			return 1;
		if(cmp < 0)
			return -1;
		return other.id - this.id;
	}

	public String toString(){
		return String.format(
			"HS%02d %s %.01f %s", 
			id, name, (double)(Math.round(getAverageScore()*10))/10, getClassify()
			//id, name, getAverageScore(), getClassify()
		);
	}
}