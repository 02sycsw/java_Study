import java.util.*;
public class HashSetTest {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		
		set.add("YOGURT");
		set.add("MILK");
		set.add("BREAD");
		set.add("BUTTER");
		set.add("MILK");
		set.add("CHEESE");
		//중복을 허용하지 않는다. 따로 에러 메세지나 컴파일 에러는 없음
		set.remove("BUTTER");
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String str = iter.next();
			System.out.println(str);
			//get() 메소드가 없다.
		}
	}
}