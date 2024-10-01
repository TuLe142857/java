
//calc big int 

import java.util.*;
public class Calculate {
	public static void main(String []args){
		
	}
	//add, subtract
	public static String add(String a, String b){
		return "";
	}

	public static String subtract(String a, String b){
		return "";
	}

	public static String multiply(String a, String b){
		return "";
	}

	public static String divide(String a, String b){
		return "";
	}


	public static boolean isInt(String s){
		for(int i = 0; i < s.length(); i++)
			if(!(s.charAt(i) >= '0' && s.charAt(i) <= 9))
				return false;

		return true;
	}	

	public static String removeZero(String s){
		int count  = 0;
		for(int i = 0; i < s.length() && s.charAt(i) == '0'; i++, count ++);
		if(count == s.length())
			return "0";
		else if(count == 0)
			return s;
		else 
			return s.substring(count);
	}
}
