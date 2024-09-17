import java.util.*;

public class DanhSachCanh {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				int value = in.nextInt();
				if(value == 1 && (j > i)){
					System.out.println("(" + (i+1) + "," + (j+1) + ")");
				}
			}
		}
	}
}
