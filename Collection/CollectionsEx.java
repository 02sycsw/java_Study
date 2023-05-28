import java.util.*;
public class CollectionsEx {
	static void printList(LinkedList<String> l) {
		Iterator<String> iter = l.iterator();
		
		while(iter.hasNext()) {
			String e = iter.next();
			String seperator;
			if(iter.hasNext())
				seperator = " -> ";
			else
				seperator = "\n";
			
			System.out.print(e + seperator);
		}
	}
	public static void main(String[] args) {
		LinkedList<String> myList = new LinkedList<String>();
		
		myList.add("사과");
		myList.add("바나나");
		myList.add("포도");
		myList.add(0, "망고");
		myList.add(2, "감귤");
		
		Collections.sort(myList); //정렬
		printList(myList);
		
		Collections.reverse(myList); //역순
		printList(myList);
	}
}
