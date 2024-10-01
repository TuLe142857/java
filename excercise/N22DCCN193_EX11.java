import java.util.*;
public class N22DCCN193_EX11 {
	public static void main(String []ags){
		
		TreeMap<String, String> treeMapStudents = new TreeMap<>();
		treeMapStudents.put("N22DCCN001", "Nguyen Van A1");
		treeMapStudents.put("N22DCCN002", "Nguyen Van A2");
		treeMapStudents.put("N22DCCN003", "Nguyen Van A3");
		treeMapStudents.put("N22DCCN004", "Nguyen Van A4");
		treeMapStudents.put("N22DCCN005", "Nguyen Van A5");

		Set<String> keys = treeMapStudents.keySet();
		System.out.println("key: " + keys);
		Collection<String> value = treeMapStudents.values();
		System.out.println("Value: " + value);

		System.out.println("Lowest key:" + treeMapStudents.firstKey());
		System.out.println("Highest key: " + treeMapStudents.lastKey() );
	}
}
