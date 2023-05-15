import java.util.*;
public class IteratorEx {
	public static void main(String[] args) {
		ArrayList<Integer> v = new ArrayList<>();
		
		v.add(3);
		v.add(7);
		v.add(2);
		v.add(10);
		
		//Iterator를 사용하여 모든 원소 출력
		Iterator<Integer> iter = v.iterator();
		int sum = 0;
		while(iter.hasNext()) {
			//hasNext(): 다음 반복에서 사용될 원소가 있으면 true를 반환한다
			int n = iter.next(); 
			//next(): 다음 원소 반환
			System.out.println(n);
			sum += n;
		}
		System.out.println("모든 원소 합: " + sum);
	}
}
