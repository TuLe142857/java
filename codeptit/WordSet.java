import java.util.*;

public class WordSet {
	// MAIN 
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		WordSet []wordset = {new WordSet(in.nextLine()), new WordSet(in.nextLine())};
		System.out.println(wordset[0].hop(wordset[1]).toString());
		System.out.println(wordset[0].giao(wordset[1]).toString());
	}



	// ATTRIBUTES & METHODS

	private ArrayList<String> word;

	public WordSet(){
		word = new ArrayList<>();
	}

	public WordSet(String s){
		String []arr = s.split(" ");
		for(int i = 0; i < arr.length; i++)
			arr[i] = arr[i].toLowerCase();
		//Arrays.sort(arr);

		word = new ArrayList<>();
		// word.add(arr[0]);
		// for(int i = 1; i < arr.length; i++){
		// 	if(arr[i].compareTo(word.getLast()) != 0){
		// 		word.add(arr[i]);
		// 	}
		// }
		for(int i = 0; i < arr.length; i++)
			this.add(arr[i]);
	}

	public int size(){
		return word.size();
	}

	public void add(String s){
		s = s.toLowerCase();
		//them dau
		if(word.size() == 0){
			word.add(s);
			return ;
		}


		//pos(position) la vi tri thich hop de them vao
		int pos = 0;
		while(pos < word.size() && word.get(pos).compareTo(s) < 0){
			pos ++;
		}
		
		//them cuoi
		if(pos ==word.size()){
			word.add(s);
		}
		//them giua
		else if(word.get(pos).compareTo(s) != 0){
			word.add(pos, s);
		}
			
	}

	public String get(int index) throws IndexOutOfBoundsException{
		if(index >= 0 && index < this.size()){
			 return word.get(index);
		}else{
			throw new IndexOutOfBoundsException("chi so khong hop le");
		}
	}

	public void set(int index, String s) throws IndexOutOfBoundsException{
		if(index >= 0 && index < this.size()){
			word.set(index, s);
		}else{
			throw new IndexOutOfBoundsException("chi so khong hop le");
		}
	}

	public WordSet hop(WordSet w){
		return new WordSet(this.toString() + " " + w.toString());
	}

	public WordSet giao(WordSet w){
		WordSet newword = new WordSet();

		for(int i = 0; i < this.size(); i++){
			
			for(int j = 0; j < w.size(); j++){
				if(w.get(j).compareTo(this.get(i)) == 0){
					newword.add(w.get(j));
				}
			}
		}
		return newword;
	}

	public String toString(){
		return String.join(" ", word);
	}	
}