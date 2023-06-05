import java.util.*;
public class GenericAverage_2 {
	public static void print(Vector<? extends Number> v) {
		for(int n = 0; n < v.size(); n++) {
			Number val = v.elementAt(n);
			System.out.print(val + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int n_sum = 0;
		double d_sum = 0.0;
		
		Vector<Integer> intVector = new Vector<Integer>();
		for(int n = 0; n < 10; n++) {
			int num = (int)(Math.random() * 100) + 1;
			intVector.add(num);
			n_sum += num;
		}
		
		System.out.println("elements in Integer Vector...");
		print(intVector);
		System.out.println("정수 합: " + n_sum);
		System.out.println("정수 평균: " + (double)n_sum / intVector.size());
		
		Vector<Double> doubleVector = new Vector<Double>();
		for(int n = 0; n < 10; n++) {
			double num = Math.random() * 5;
			doubleVector.add(num);
			d_sum += num;
		}
		
		System.out.println("elements in Double Vector...");
		print(doubleVector);
		System.out.println("정수 합: " + d_sum);
		System.out.println("정수 평균: " + (double)d_sum / doubleVector.size());
	}
}
