import java.util.*;

public class WildCardLowerTest {
	public static void addToList(List<? super Integer> v) {
		for(int i = 1; i <= 10; i++) {
			v.add(i);
		}
	}
	public static void printList(List<? super Integer> v) {
		for(int i = 0; i < v.size(); i++) {
			System.out.print(v.get(i) + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<Integer>();
		addToList(intList);
		printList(intList);
		List<Number> numList = new ArrayList<Number>();
		addToList(numList);
		printList(intList);
		List<Object> objList = new ArrayList<Object>();
		addToList(objList);
		printList(objList);
	}

}
