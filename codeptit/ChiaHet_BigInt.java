import java.math.BigInteger;
import java.util.*;

public class ChiaHet_BigInt{
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int nTest = in.nextInt();
		BigInteger a, b;
		String []s;
		in.nextLine();

		for(int i = 0; i < nTest; i++){
			s = in.nextLine().split(" ");
			a = new BigInteger(s[0]);
			b = new BigInteger(s[1]);
			if(a.compareTo(b) < 0){
				if(b.mod(a).compareTo(BigInteger.valueOf(0)) == 0)
					System.out.println("YES");
				else	
					System.out.println("NO");
			}else{
				if(a.mod(b).compareTo(BigInteger.valueOf(0)) == 0)
					System.out.println("YES");
				else	
					System.out.println("NO");
			}
		}
	}
}