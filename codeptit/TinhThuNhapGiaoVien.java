import java.util.*;
public class TinhThuNhapGiaoVien {
	public static void main(String []args){
		Scanner in  =new Scanner(System.in);
		GiaoVien gv = new GiaoVien(in.nextLine(), in.nextLine(), in.nextInt());
		System.out.println(gv.toString());
	}
}

class GiaoVien{
	private String chucVu;
	private int bacLuong;
	private String ten;
	private int luongCoBan;

	public GiaoVien(String maNgach, String ten, int luongCoBan){
		this.chucVu = maNgach.substring(0, 2);
		this.bacLuong = Integer.parseInt(maNgach.substring(2, 4));
		this.ten = ten;
		this.luongCoBan = luongCoBan;
	}

	public int getPhuCap(){
		int phucap = 0;
		switch(chucVu){
			case "HT":{
				phucap = 2000000;
				break;
			}
			case "HP":{
				phucap = 900000;
				break;
			}
			case "GV":{
				phucap = 500000;
				break;
			}
	
		}
		return phucap;
	}

	public int getThuNhap(){
		return getPhuCap() + (luongCoBan*bacLuong);
	}

	public String toString(){
		return String.format(
			"%s%02d %s %d %d %d",
			chucVu, bacLuong, ten, bacLuong, getPhuCap(), getThuNhap()
		);
	}

}
