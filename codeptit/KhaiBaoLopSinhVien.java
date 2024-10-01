import java.util.*;
public class KhaiBaoLopSinhVien {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		System.out.println(
			"B20DCCN001" + " " + 
			in.nextLine() + " " +
			in.nextLine() + " " +  
			formatDate(in.nextLine()) +" " + 
			String.format("%.02f", in.nextDouble())
		);
	}

	public static String formatDate(String s){
		String []s_ = s.split("/");
		int d = Integer.parseInt(s_[0]);
		return String.format(
			"%02d/%02d/%02d", 
			Integer.parseInt(s_[0]), 
			Integer.parseInt(s_[1]), 
			Integer.parseInt(s_[2]) 
		);
	}
}
