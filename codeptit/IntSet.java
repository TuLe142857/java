import java.util.*;
public class IntSet {
	//MAIN
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		IntSet []intset = {new IntSet(), new IntSet()};
		int n1 = in.nextInt(), n2 = in.nextInt();
		for(int i = 0; i < n1; i++, intset[0].add(in.nextInt()));
		for(int i = 0; i < n2; i++, intset[1].add(in.nextInt()));

		System.out.println(intset[0].hop(intset[1]).toString());
	}

	//ATTRIBUTES & METHODS

	private ArrayList<Integer> list;

	public IntSet(){
		list = new ArrayList<>();
	}

	//size, add, get, set, hop, toString
	public int size(){
		return list.size();
	}

	public void add(int value){
		if(list.size() == 0){
			list.add(value);
			return;
		}
		//empty
		int pos = 0;
		while(pos < list.size() && list.get(pos) < value){
			pos ++;
		}

		//them cuoi
		if(pos == list.size()){
			list.add(value);
		}
		//them giua(hoac dau)
		else if(list.get(pos) != value){
			list.add(pos, value);
		}
	}

	public int get(int index) throws IndexOutOfBoundsException{
		if(index >= 0 && index < list.size()){
			return list.get(index);
		}else{
			throw new IndexOutOfBoundsException("invalid index");
		}
	}

	// public void set(int index, int value) throws IndexOutOfBoundsException{
	// 	if(index >= 0 && index < list.size()){
	// 		list.set(index, value);
	// 	}else{
	// 		throw new IndexOutOfBoundsException("invalid index");
	// 	}
	// }

	public IntSet hop(IntSet other){
		IntSet intset = new IntSet();
		for(int i = 0; i < list.size(); i++){
			intset.add(list.get(i));
		}

		for(int i = 0; i < other.size(); i++){
			intset.add(other.get(i));
		}
		return intset;
	}

	public IntSet giao(IntSet other){
		IntSet intset = new IntSet();
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j < other.size(); j++){
				if(list.get(i) == other.get(j)){
					intset.add(list.get(i));
				}
			}
		}
		return intset;
	}

	public String toString(){
		String s = "";
		for(int i : list){
			s += String.valueOf(i) + " ";
		}
		return s;
	}

}
