import java.util.*;
public class TongSoNguyenLon_2 {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);

		String s1 = removeZero(in.nextLine());
		String s2 = removeZero(in.nextLine());
		String ans = (add(s1, s2));
		System.out.print(ans);
		
	}

	public static String add(String a, String b){
		while(a.length() < b.length()){
			a = "0" + a;
		}
		while(b.length() < a.length()){
			b = "0" + b;
		}
		String ans = "";
		int r = 0;
		int l = a.length();
		int x;
		//System.out.println(a + "\n" + b);
		for(int i = l-1; i >= 0; i--){
			x = charToInt(a.charAt(i)) + charToInt(b.charAt(i)) + r;
			r = 0;
			if(x >= 10){
				r = x/10;
				x = x%10;
			}
			ans = String.valueOf(x) + ans;
		}
		if(r != 0)
			ans = String.valueOf(r) + ans;
		
		return ans;
	}

	private static String removeZero(String s){
		int count = 0;
		for(int i = 0; i < s.length() && s.charAt(i) == '0' ; i++, count ++);
		if(count == 0)
			return s;
		else if(count == s.length())
			return "0";
		else return s.substring(count);
		
	}

	private static int charToInt(char c){
		return (int)c - (int)('0');
	}

	
}
