import java.util.*; 
public class DanhSachDoiTuongNhanVien {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();

		for(int i = 1; i <= n; i++){
			String s = 
				in.nextLine() + " " + 
				in.nextLine() + " " +
				in.nextLine() + " " +
				in.nextLine() + " " +
				in.nextLine() + " " + 
				in.nextLine();
			System.out.println(String.format("%05d %s", i, s));
		}
	}
}
