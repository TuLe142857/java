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
			// if(s1.length() == 0)
			// 	s1 = new String("0");
			// if(s2.length() == 0)
			// 	s2 = new String("0");
			if(s1.length() == 0 || s2.length() == 0){
				if(s1.length() == 0)
					System.out.println(s2);
				else	
					System.out.println(s1);
				continue;
			}
			ans = Subtract(s1, s2);
			System.out.println(ans);
		}
	}

	public static String Subtract(String a, String b){
		while(a.length() < b.length()){
			a = "0" + a;
		}
		while(b.length() < a.length()){
			b = "0" + b;
		}

		if(a.compareTo(b) < 0){
			return Subtract(b, a);
		}

		//now: a.length == b.length && a >= b
		String ans = "";
		int l = a.length();
		int r = 0, x;
		for(int i = l-1; i >= 0; i--){
			x = charToInt(a.charAt(i)) - charToInt(b.charAt(i)) - r;
			r = 0;
			if(x < 0){
				x += 10;
				r ++;
			}

			ans = String.valueOf(x) + ans;
		}

		return ans;
	}

	public static int charToInt(char c){
		return (int)c - (int)('0');
	}

	
}
