import java.util.*;
public class GiaoHaiDaySo {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);

		boolean []arrayA = new boolean[1000];
		boolean []arrayB = new boolean[1000];

		int nA, nB;
		nA = in.nextInt();
		nB = in.nextInt();
		int n;
		for(int i = 0; i < nA; i++){
			n = in.nextInt();
			arrayA[n] = true; 
		}

		for(int i = 0; i < nB; i++){
			n = in.nextInt();
			arrayB[n] = true; 
		}

		for(int i = 1; i < 1000; i++){
			if(arrayA[i] && arrayB[i]){
				System.out.print(i + " ");
			}
		}

	}
}
