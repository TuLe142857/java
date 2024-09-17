import java.util.*;

public class ThuGonDaySo {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < k; i++){
			int value = in.nextInt();
			if(stack.isEmpty()){
				stack.push(value);
			}
			else{
				if((stack.peek() + value) % 2 == 0){
					stack.pop();
				}
				else{
					stack.push(value);
				}
			}
		}

		System.out.println(stack.size());
	}
}
