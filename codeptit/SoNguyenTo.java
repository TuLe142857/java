/*
 * @author Le Ngoc Tu N22DCCN193
 */
import java.util.*;

public class SoNguyenTo{
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();

		int n, i, j;
		boolean isPrime;
		for(i = 0; i < k; i++){
			n = in.nextInt();
			isPrime = true;
			for(j = 2; j < Math.sqrt(n); j++){
				if((n%j) == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
}