import java.util.*;
class Employee{
	int id;
	String dept;
	public Employee(int id, String dept) {
		this.id = id;
		this.dept = dept;
	}
}
public class HashMapEmpEx {
	public static void main(String[] args) {
		HashMap<String, Employee> map = new HashMap<String, Employee>();
		
		map.put("Lee", new Employee(101, "sales"));
		map.put("Park", new Employee(102, "personnel"));
		map.put("Kim", new Employee(103, "planning"));
		//map.put("Kim", new Employee(104, "scanning"));
		//같은 키 값을 쓰게 되면 나중에 put한 내용으로 덮어씌워진다. 
		map.put("Choe", new Employee(103, "planning"));
		//같은 키 값이 아닌, 키에 따라가는 원소 값이 같은 건 상관 없다.

		System.out.println("원소의 개수: " + map.size());
		
		Set<String> names = map.keySet();
		Iterator<String> iter = names.iterator();
		while(iter.hasNext()) {
			String name = iter.next();
			Employee emp = map.get(name);
			System.out.println(name + ": " + emp.id + " " + emp.dept);
		}
	}

}
