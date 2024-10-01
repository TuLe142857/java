import java.util.*;
public class BaiToanTuyenSinh {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		String studentId = in.nextLine();
		String studentName = in.nextLine();
		double totalScore = in.nextDouble()*2 + in.nextDouble() + in.nextDouble();
		
		double []priorityScore = {0.5, 1, 2.5};
		int kv = Integer.parseInt(studentId.substring(2, 3));
		
		String status;
		if((totalScore + priorityScore[kv-1]) >= 24)
			status = "TRUNG TUYEN";
		else	
			status = "TRUOT";
		
		String strOut = studentId + " " + studentName;
		if(priorityScore[kv-1] == (int)priorityScore[kv-1])
			strOut += " " + (int)priorityScore[kv-1];
		else
			strOut += String.format(" %.1f", priorityScore[kv-1]);
		
		if(totalScore == (int)totalScore)
			strOut += " " + (int)totalScore;
		else
			strOut += String.format(" %.1f", totalScore);
		
		strOut += " " + status;

		System.out.println(strOut);


	}

	
}

