/*
 * @author N22DCCN193 Le Ngoc Tu
 */
import java.util.*;

public class HieuSoNguyenLon_1 {
	public static void main(String []args){
		Scanner in= new Scanner(System.in);
		
		int k = in.nextInt();
		
		String s1, s2, ans;
		s1 = in.nextLine();
		for(int i = 0; i < k; i++){
			s1 = in.nextLine();
			s2 = in.nextLine();
			ans = Subtract(s1, s2);
			System.out.println(ans);
		}
	}

	public static String Subtract(String a, String b){
		int compare = compareString(a, b);
		if(compare == 0) return "0";
		if(compare == -1) return Subtract(b, a);
		String ans = "";

		//a > b
		int l = a.length();
		while(b.length() < l){
			b = "0" + b;
		}

		
		int r = 0;
		for(int i = l-1; i>=0; i--){
			int digitA = charToInt(a.charAt(i));
			int digitB = charToInt(b.charAt(i));
			int x = digitA - digitB - r;
			r = 0;
			if(x < 0) {
				x += 10;
				r = 1;
			}
			ans = String.valueOf(x) + ans;
		}
		return ans;
	}

	public static int compareString(String a, String b){
		if(a.length() < b.length())
			return -1;
		if(a.length() > b.length())
			return 1;

		return a.compareTo(b);
	}

	public static int charToInt(char c){
		return (int)c - (int)('0');
	}

	
}
