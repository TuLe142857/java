import java.util.*;
public class SapXepThoiGian_V2 {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int nTestCase = in.nextInt();

		//arr luu tong so giay
		int []arr = new int[nTestCase];

		for(int i = 0; i < nTestCase; i++){
			arr[i] = in.nextInt()*3600 + in.nextInt()*60 + in.nextInt();
		}

		Arrays.sort(arr);
		int h, m, s;
		for(int i:arr)
			System.out.println( (i/3600) + " " + ((i/60)%60) + " " + (i%60) );
	}
}
