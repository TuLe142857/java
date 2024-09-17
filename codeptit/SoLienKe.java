import java.util.*;

public class SoLienKe {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);

		int k = in.nextInt();
		in.nextLine();

		for(int i = 0; i < k; i++){
			if(check(in.nextLine()))
				System.out.println("YES");
			else 
				System.out.println("NO");

		}
	}

	public static boolean check(String s){
		for(int i = 0; i < s.length() - 1; i++){
			if(Math.abs(charToInt(s.charAt(i)) - charToInt(s.charAt(i+1))) != 1)
				return false;
		}
		return true;
	}
	public static int charToInt(char c){
		return (int)(c) - (int)('0');
	}



}
