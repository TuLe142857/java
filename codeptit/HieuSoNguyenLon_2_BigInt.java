import java.math.BigInteger;
import java.util.*;
public class HieuSoNguyenLon_2_BigInt {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		System.out.println( (new BigInteger(in.nextLine())).subtract(new BigInteger(in.nextLine())).toString());
	}
}
