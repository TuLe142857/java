import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class SoKhacNhauTrongFile_1 {
	public static void main(String []args){
		File inputFile = new File("DATA.in");
		
		int []arr = new int[1000];
		try(Scanner in = new Scanner(inputFile);){
			
			while(in.hasNextInt()){
				arr[in.nextInt()] ++;
			
			}
			for(int i = 0; i < 1000; i++){
				if(arr[i] != 0)
					System.out.println(i + " " + arr[i]);
			}

		}
		catch(FileNotFoundException e){

		}
	}


}
