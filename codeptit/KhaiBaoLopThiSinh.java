import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class KhaiBaoLopThiSinh {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		Examinee examinee = new Examinee(
			in.nextLine(),
			in.nextLine(), 
			in.nextDouble(),
			in.nextDouble(),
			in.nextDouble()
		);
		System.out.println(examinee.toString());
	}
}


class Examinee{
	private String name;
	private String dateOfBirth;
	private double score1;
	private double score2;
	private double score3;
	private double totalScore;

	public Examinee(){
		name = "unknown";
		dateOfBirth = "unknown";
		score1 = -1;
		score2 = -1;
		score3 = -1;
		totalScore = -1;
	}

	public Examinee(String name, String dateOfBirth, double score1, double score2, double score3){
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.totalScore = score1 + score2 + score3;
	}

	public String toString(){
		return name + " " + dateOfBirth + " " + String.format("%.1f", totalScore);
	}


}
