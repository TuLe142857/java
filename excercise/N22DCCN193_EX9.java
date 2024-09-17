import java.util.*;
import java.io.*;

public class N22DCCN193_EX9 {
	public static void main(String []args){
		File fileInput = new File("Data.txt");
		try (Scanner in = new Scanner (fileInput)){
			while(in.hasNextInt()){
				try{
					int k = in.nextInt();
					double x = Math.sqrt(k);
					System.out.println(x);
				}
				catch(IllegalArgumentException e){
					System.out.println("So am!");
				}
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Khong tim thay file");
		}

	}
}
