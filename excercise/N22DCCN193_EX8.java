import java.util.*;

class Student{
	private String id;
	private String name;

	public Student(){
		this.id = "unknown";
		this.name = "unknown";
	}

	public Student(String id, String name){
		this.id = id;
		this.name = name;
	}

	public String getId(){
		return id;
	}

	public String toString(){
		return id + "_" + name;
	}
}

public class N22DCCN193_EX8 {
	public static void main(String [] args){
		ArrayList<Student> arr = new ArrayList<>();
		arr.add(new Student("1", "SV1"));
		arr.add(new Student("3", "SV3"));
		arr.add(new Student("2", "SV2"));

		Collections.sort(arr, (a, b) -> a.getId().compareTo(b.getId()));
		for(Student a:arr){
			System.out.println(a.toString());
		}

	}
}
