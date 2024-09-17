import java.util.*;
public class XauDoiXung {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();

		in.nextLine();
		for(int i = 0; i < k; i++){
			if(check(in.nextLine()))
				System.out.println("YES");
			else System.out.println("NO");
		}
	}

	public static boolean check(String s){
		int l = s.length();
		int count = 0;

		int i = 0, j = l-1;
		while(i < j){
			if(Character.compare(s.charAt(i),s.charAt(j)) != 0){
				count ++;
				if(count == 2)
					return false;
			}
			i++;
			j--;
		}
		return (count == 1 || (count == 0 && l%2 == 1));
	}
}
