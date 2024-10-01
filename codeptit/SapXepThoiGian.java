import java.util.*;
public class SapXepThoiGian {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Time []arr = new Time[n];
		for(int i = 0; i < n; i++){
			arr[i] = new Time(in.nextInt(), in.nextInt(), in.nextInt());
		}

		Arrays.sort(arr, (a, b)->
			((a.getHour()*3600 + a.getMinute()*60 + a.getSecond()) - 
			(b.getHour()*3600 + b.getMinute()*60 + b.getSecond()))   );
		for(Time t : arr){
			System.out.println(t.toString());
		}
	}
}

class Time /*implements Comparable<Time>*/{
	
	private int hour;
	private int minute;
	private int second;

	public Time(){
		hour = 0;
		minute = 0;
		second = 0;
	}

	public Time(int hour, int minute, int second){
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	// public int compareTo(Time t){
	// 	if(this.hour < t.hour)
	// 		return -1;
	// 	if(this.hour > t.hour) 
	// 		return 1;
		
	// 	if(this.minute < t.minute){
	// 		return -1;
	// 	}
	// 	if(this.minute > t.minute){
	// 		return 1;
	// 	}

	// 	if(this.second < t.second){
	// 		return -1;
	// 	}
	// 	if(this.second > t.second){
	// 		return 1;
	// 	}
	// 	return 0;
	// }

	public int getHour(){
		return hour;
	}
	public int getMinute(){
		return minute;
	}

	public int getSecond(){
		return second;
	}

	public String toString(){
		return String.valueOf(hour) + " " + String.valueOf(minute) + " " + String.valueOf(second);
	}
}