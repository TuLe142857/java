import java.util.*;
public class DanhDauChuCai {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);

		//256 ky tu ASCII
		boolean []exist = new boolean[256];
		
		String s = in.nextLine();

		int count = 0;
		for(int i = 0; i < s.length(); i++){
			if(!exist[(int)s.charAt(i)]){
				count ++;
				exist[(int)s.charAt(i)] = true;
			}
		}
		System.out.println(count);
	}
}
