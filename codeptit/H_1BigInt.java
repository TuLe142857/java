import java.math.BigInteger;
import java.util.*;

public class H_1BigInt {
	public static void main(String []args){
		Scanner in= new Scanner(System.in);
		
		int k = in.nextInt();
		
		String s1, s2, ans;
		in.nextLine();
		for(int i = 0; i < k; i++){
			s1 = in.nextLine();
			s2 = in.nextLine();
			if(s)
			BigInteger b1 = new BigInteger(s1), b2 = new BigInteger(s2);
			int cmp = b1.compareTo(b2);

			int l = 0;
			if(cmp > 0){
				l = s1.length();
				ans = b1.subtract(b2).toString();
			}
			else if(cmp < 0){
				l = s2.length();
				ans = b2.subtract(b1).toString();
			}
			else{
				ans = "0";
				l = s1.length();
			}

			while(ans.length() < l)
				ans = "0" + ans;

			System.out.println(ans);
		}
	}
}
