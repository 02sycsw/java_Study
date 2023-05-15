import java.util.Random;
import java.util.ArrayList;

public class ArrayListRandTest_2 {
	public static void main(String[] args) {
		ArrayList<Integer> v = new ArrayList<>();
		int sum = 0;
		double average = 0.0;
		
		Random randObj = new Random();
		for(int n = 0; n < 12; n++) {
			v.add(randObj.nextInt(100));
		}
		
		System.out.println("before removing...");
		for(int n = 0; n<v.size(); n++) {
			int val = v.get(n);
			System.out.print(val + " ");
		}
		System.out.println("");
		
		v.remove(5);
		v.remove(2);
		
		System.out.println("after removing...");
		for(int n = 0; n<v.size(); n++) {
			int val = v.get(n);
			System.out.print(val + " ");
		}
		System.out.println("");
		
		v.set(0, randObj.nextInt(100));
		v.set(7, randObj.nextInt(100));
		
		System.out.println("after replacing...");
		for(int n = 0; n<v.size(); n++) {
			int val = v.get(n);
			sum += val;
		}
		average = (double)sum/v.size();
		
		System.out.println("합: " + sum);
		System.out.println("평균: " + average);
	}

}
