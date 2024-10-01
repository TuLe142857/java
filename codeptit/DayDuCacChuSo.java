import java.util.*;
public class DayDuCacChuSo {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int nTest = in.nextInt();
		for(int i = 0; i < nTest; i++ ){
			long k = calc(in.nextLong());
			if( k!= -1)
				System.out.println(k);
			else	
				System.out.println("Impossible");
		}
	}

	/*
	 * Luu danh sach cac so xuat hien trong mang bit
	 * int digit = 0b0000000000
	 * bit thu n(tu phai sang trai, tinh tu 0)  = 1 => chu so n co xuat hien
	 */

	public static int checkDigit(long n){
		int digit = 0;

		do{
			digit |= (0b01 << (n%10));
			n /= 10;
		}while(n != 0);
		return digit;
	}

	public static long calc(long n){
		if(n <= 0 ) return -1; 
		long k = 0;
		int digit =  0b0000000000;
		int target = 0b1111111111;

		do{
			k += n;
			digit |= (checkDigit(k));
		}while(digit != target);
		return k;
	}
}
