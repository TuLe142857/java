/*
 * @author Le Ngoc Tu N22DCCN193
 */

import java.util.*;

public class CatDoi {
	

	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		for(int i = 0; i < k; i++){
			long x = in.nextLong();
			long ans = cat(x);
			if(ans == 0){
				System.out.println("INVALID");
			}
			else System.out.println(ans);
		}

	}

	public static long cat(long n){
		final int []arr = {0, 1 , -1, -1, -1, -1, -1, -1, 0, 0};
		int pos = 0;
		long answer = 0;
		while(n != 0){
			long k = n%10;
			n /= 10;

			if(arr[(int)k] == -1)
				return 0;
			answer += Math.pow(10, pos) * arr[(int)k];
			pos ++;
		}

		return answer;

	}

}
