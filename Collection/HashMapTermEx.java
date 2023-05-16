import java.util.*;
public class HashMapTermEx {
	public static void main(String[] args) {
		HashMap<String, String> term = new HashMap<String, String>();
		//capacity를 정해주지 않으면 초기 용량이 16개로 생성되고, 16개 단위로 HashMap의 크기가 변한다. 
		
		//3개 원소 저장
		term.put("binary", "2진법");
		term.put("octal", "8진법");
		term.put("decimal", "10진법");
		term.put("hexadecimal", "16진법");

		//모든 (key, value) 쌍 출력
		//내부에 index가 없는 구조기 때문에 뒤섞여서 출력될 수 있다. 
		//key 값만 얻는 방법은 없고, 이렇게 간접적으로 얻을 수는 있다.
		Set<String> keys = term.keySet(); //Set 리턴
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			String value = term.get(key);
			System.out.println("(" + key + ", " + value + ")");
		}
	}

}
