import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HoaDonKhachSan {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int nTest = in.nextInt();
		

		Invoice []arr = new Invoice[nTest];
		for(int i = 0; i  < nTest; i++){
			in.nextLine();
			String name, checkIn, checkOut;
			int roomNumber, additionalCost;

			name = in.nextLine();
			roomNumber = in.nextInt();
			in.nextLine();
			checkIn = in.nextLine();
			checkOut = in.nextLine();
			additionalCost = in.nextInt();

			arr[i] = new Invoice(name, roomNumber, checkIn, checkOut, additionalCost);
			
		}

		Arrays.sort(arr, (a, b)->(b.getCost() - a.getCost()) );
		for(Invoice a: arr)
			System.out.println(a.toString());

	}
}

class Invoice {
	private static final int []floorPrice = {25, 34, 50, 80};
	private static int nextID = 1;

	private String customerID;
	private String customerName;
	private int roomNumber;
	private int daysStayed;
	private int totalCost;

	public Invoice(String customerName, int roomNumber, String checkInDate, String checkOutDate, int additionalCost){
		this.customerID = String.format("KH%02d",nextID++);
		this.customerName = customerName;
		this.roomNumber = roomNumber;
		LocalDate checkIn, checkOut;

		String []s = checkInDate.split("/");
		checkIn = LocalDate.of(Integer.parseInt(s[2]), Integer.parseInt(s[1]), Integer.parseInt(s[0]));
		s = checkOutDate.split("/");
		checkOut = LocalDate.of(Integer.parseInt(s[2]), Integer.parseInt(s[1]), Integer.parseInt(s[0]));
		this.daysStayed = (int)ChronoUnit.DAYS.between(checkIn, checkOut) + 1;

		int floor = roomNumber/100;
		totalCost = daysStayed*floorPrice[floor-1] + additionalCost;
		
	}

	public int getCost(){
		return totalCost;
	}

	public String toString(){
		return String.format("%s %s %d %d %d", customerID, customerName, roomNumber, daysStayed, totalCost);
	}

}
