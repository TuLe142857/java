import java.util.*;
public class Pair {
	//---------------------------------------------
	//				MAIN
	//---------------------------------------------
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int nTest = in.nextInt();
		for(int i = 0; i < nTest; i++){
			Pair ans = calc(in.nextInt());
			if(ans.getX1() != -1)
				System.out.println(ans.getX1() + " " + ans.getX2());
			else	
				System.out.println(-1);
		}
	}

	public static Pair calc (int n){
		for(int i = 2; i <= n/2; i++){
			if(isPrime(i) && isPrime(n-i))
				return new Pair(i, n-i);
		}
		return new Pair(-1, -1);
	}


	public static boolean isPrime(int n){
		if(n < 2) return false;
		for(int i = 2; i < Math.sqrt(n); i++){
			if(n % i == 0)
				return false;
		}
		return true;
	}

	//---------------------------------------------
	//				ATTRIBUTES & METHODS
	//---------------------------------------------

	private int x1;
	private int x2;

	public Pair(){
		x1 = 0;
		x2 = 0;
	}

	public Pair(int x1, int x2){
		this.x1 = x1;
		this.x2 = x2;
	}

	public int getX1(){
		return x1;
	}
	public int getX2(){
		return x2;
	}

	public void setX1(int x1){
		this.x1 = x1;
	}

	public void setX2(int x2){
		this.x2 = x2;
	}
}
