import java.util.*;

public class ChiaHet {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		for(int i = 0; i < n; i++){
			String s = in.nextLine();
			String []arr = s.split(" ");
			if(check(arr[0], arr[1]))
				System.out.println("YES");
			else 
				System.out.println("NO");
		}
	}

	public static boolean check(String a, String b){
		a = removeZero(a);
		b = removeZero(b);
		while(a.length() < b.length())
			a = "0" + a;
		while(b.length() < a.length())
			b = "0" + b;

		if(a.compareTo(b) < 0)
			return check(b, a);
		
		int l = a.length();
		int r, x;
		String ans;
		// System.out.println("-----------------------------------");
		// System.out.println("a = " + a);
		// System.out.println("b " + b);
	
		while(a.compareTo(b) >= 0){
			ans = "";
			r = 0;
			for(int i = l-1; i >= 0; i--){
				x = charToInt(a.charAt(i)) - charToInt(b.charAt(i)) - r;
				r = 0;
				if(x < 0){
					r = 1;
					x += 10;
				}
				ans = String.valueOf(x) + ans;
			}

			a = ans;

			// System.out.println("-----------------------------------");
			// System.out.println("a = " + a);
			// System.out.println("b " + b);

		}
		return removeZero(a) == "0";
	}

	

	public static String removeZero(String s){
		int count  = 0;
		for(int i = 0; i < s.length() && s.charAt(i) == '0'; i++, count ++);
		if(count == s.length())
			return "0";
		else if(count == 0)
			return s;
		else 
			return s.substring(count);
	}

	public static int charToInt(char c){
		return (int)c - (int)('0');
	}
}


