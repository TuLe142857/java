import java.util.*;
public class SapXepDanhSachMatHang {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int nTest = in.nextInt();
		in.nextLine();

		Item []arr = new Item[nTest];
		for(int i = 0; i < nTest; i++){
			arr[i] = Item.getInput(in);
		}

		Arrays.sort(arr, (a, b)->{
			double compare = b.getProfit() - a.getProfit();
			if(compare == 0) 
				return 0;
			if(compare < 0)
				return -1;
			return 1;
		});
		
		for(Item i : arr){
			System.out.println(i.toString());
		}

	}
}

class Item{
	private static int nextID = 1;
	private int id;
	private String name;
	private String category;
	private double buyPrice;
	private double salePrice;

	public static Item getInput(Scanner in){
		return new Item(
			in.nextLine(), in.nextLine(), 
			Double.parseDouble(in.nextLine()), Double.parseDouble(in.nextLine())
		);
	}
	public Item(String name, String category, double buyPrice, double salePrice){
		this.id = nextID++;
		this.name = name;
		this.category = category;
		this.buyPrice = buyPrice;
		this.salePrice = salePrice;
	}

	public double getProfit(){
		return salePrice - buyPrice;
	}

	public String toString(){
		return String.format(
			"%d %s %s %.02f", 
			id, name, category, getProfit());
	}
}
