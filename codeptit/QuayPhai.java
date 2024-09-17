import java.util.*;
public class QuayPhai {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int nTest = in.nextInt();
		for(int i = 0; i < nTest; i++){
			int n = in.nextInt();
			int []arr = new int[n];
			for(int j = 0; j < n; j++)
				arr[j] = in.nextInt();
			System.out.println(calc(arr, n));
		}
	}

	public static int calc(int []arr, int n){
		int k = 0;

		/*
		 * tim vi tri phan tu lon nhat = k
		 * su khi dich 0 lan, k = n-1
		 * 	           1       k = 0
		 *             2       k = 1
		 * => so lan dich = k+1, if(k == n) k = 0
		 * => (k+1)%n
		 */
		for(k = 0; k < n-1; k++){
			if(arr[k] > arr[k+1])
				break;
		}
		return((k+1)%n);
	}
}
