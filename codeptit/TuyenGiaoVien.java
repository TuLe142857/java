
import java.util.*;
public class TuyenGiaoVien{
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		Teacher []arr = new Teacher[n];
		for(int i = 0; i < n; i++){
			arr[i] = getInput(in);
		}
		
		Arrays.sort(arr, (a, b)->(-a.compareTo(b)));
		for (Teacher t : arr){
			System.out.println(t.toString());
		}

	}

	public static Teacher getInput(Scanner in){
		return new Teacher(
			in.nextLine(),
			in.nextLine(),
			Double.parseDouble(in.nextLine()),
			Double.parseDouble(in.nextLine())
		);
	}
}

class Teacher implements Comparable<Teacher>{
	private static int nextID = 1;
	private final String []strSubject = {"TOAN", "LY", "HOA"};
	private final double []priorityScore = {2.0, 1.5, 1.0, 0};
	private int id;
	private String name;
	private int subject;
	private double score;

	public int compareTo(Teacher other){
		double cmp = this.score - other.score;
		if(cmp > 0)
			return 1;
		else if(cmp == 0)
			return 0;
		return -1;
	}
	public Teacher(String name, String subjectCode, double itScrore, double specializatiionScore){
		this.id = nextID++;
		this.name = name;
		int priority = Integer.parseInt(subjectCode.substring(1, 2));
		this.subject = (int)(subjectCode.charAt(0)) - (int)('A');
		this.score = (itScrore*2) + specializatiionScore + priorityScore[priority-1];
	}

	public String getStatus(){
		if(score >= 18)
			return "TRUNG TUYEN";
		return "LOAI";
	}

	public String toString(){
		return String.format(
			"GV%02d %s %s %.01f %s",
			id, name, strSubject[subject], score, getStatus()
		);
	}
}