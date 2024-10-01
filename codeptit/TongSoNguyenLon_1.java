import java.math.BigInteger;
import java.util.*;
public class TongSoNguyenLon_1 {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int nTest = in.nextInt();
		in.nextLine();
	
		for(int i = 0; i < nTest; i++){
			System.out.println( (new BigInteger(in.nextLine())).add(new BigInteger(in.nextLine())).toString());
		}
	}
}
