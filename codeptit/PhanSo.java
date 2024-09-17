import java.util.*;
public class PhanSo {
	//main
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		long ts = in.nextLong(), ms = in.nextLong();
		PhanSo x = new PhanSo(ts, ms);
		x.toiGian();
		System.out.println(x.toString());
	}


	//attributes & methods

	private long ts;
	private long ms;

	public PhanSo(){
		ts = 0;
		ms = 0;
		
	}

	public PhanSo(long ts, long ms){
		this.ts = ts;
		this.ms = ms;
	}

	public void toiGian(){
		long x = gcd(ts, ms);
		ts /= x;
		ms /= x;
	}

	public long gcd(long a, long b){
		while(b != 0){
			long temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}

	public String toString(){
		return String.valueOf(ts) + "/" + String.valueOf(ms);
	}

	
}
