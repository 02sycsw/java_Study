import java.util.*;
public class LLinkTest {
	public static void main(String[] args) {
		LinkedList<String> llink = new LinkedList<String>();
		
		llink.add("Milk");
		llink.add("Bread");
		llink.add("Butter");
		llink.add(1, "Apple");
		llink.set(2, "Grape");
		llink.remove(3);
		
		for(int i = 0; i<llink.size(); i++) {
			System.out.println(llink.get(i));
		}
		
		//LinkedList에서 iterator를 사용하기
		Iterator<String> iter = llink.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
