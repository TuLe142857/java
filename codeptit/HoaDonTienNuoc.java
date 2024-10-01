import java.util.*;
public class HoaDonTienNuoc {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		KhachHang []arr = new KhachHang[n];
		for(int i = 0; i < n ;i++){
			arr[i] = new KhachHang( "KH" + String.format("%02d", i+1), 
								in.nextLine(), 
								-in.nextInt() + in.nextInt());
			in.nextLine();
		}
		
		Arrays.sort(arr, (a, b)->(b.getTongTien() - a.getTongTien()));
		for(KhachHang k : arr)
			System.out.println(k.toString());
			
		
	}
}

class KhachHang {
	private String maso;
	private String ten;
	private int tongTien;

	public KhachHang(){
		this.maso = "unknown";
		this.ten = "unknown";
		this.tongTien = 0;
	}

	public KhachHang(String maso, String ten, int soNuocTieuTHu){
		this.maso = maso;
		this.ten = ten;
		double calc = 0;
		if(soNuocTieuTHu <= 0){
			this.tongTien = 0;
		}else if(soNuocTieuTHu <= 50){
			calc = (double)soNuocTieuTHu * 100;
			calc *= 1.02;
			this.tongTien = (int)Math.round(calc);
		}else if(soNuocTieuTHu <= 100){
			calc = (50 * 100) +  ((double)soNuocTieuTHu - 50) * 150;
			calc *= 1.03;
			this.tongTien = (int)Math.round(calc);
		}else{
			calc = (50 * 100) + (50 * 150) +  ((double)soNuocTieuTHu - 100) * 200;
			calc *= 1.05;
			this.tongTien = (int)Math.round(calc);
		}
	}

	public int getTongTien(){
		return tongTien;
	}

	public String toString(){
		return maso + " " + ten + " " + String.valueOf(tongTien);
	}
}
