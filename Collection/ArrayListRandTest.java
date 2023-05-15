import java.util.*;
public class ArrayListRandTest {
	public static void main(String[] args) {
		ArrayList<Integer> v = new ArrayList<>(12);
		Random randObj = new Random();
		int sum = 0;
		
		System.out.println("before removing...");
		for(int i = 0; i < 12; i++) {
			int n = randObj.nextInt(100);
			v.add(n);
			System.out.print(n + " ");
		}
		System.out.println("");
		
		v.remove(2);
		v.remove(5);
		
		System.out.println("after removing...");
		for(int i = 0; i < v.size(); i++) {
			System.out.print(v.get(i) + " ");
		}
		System.out.println("");

		v.set(0, randObj.nextInt(100));
		v.set(7, randObj.nextInt(100));
		
		System.out.println("after replacing...");
		for(int i = 0; i < v.size(); i++) {
			System.out.print(v.get(i) + " ");
			sum += v.get(i);
		}
		System.out.println("");
		
		System.out.println("합: " + sum + "\n" + "평균: " + (double)sum/v.size());
	}

}
