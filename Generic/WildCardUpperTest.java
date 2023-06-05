import java.util.*;

public class WildCardUpperTest {
	public static double sumOfList(List<? extends Number> v) {
		double s = 0.0;
		
		for(Number n:v)
			s += n.doubleValue();
		
		return s;
	}
	public static void main(String[] args) {
		List<Integer> li = Arrays.asList(1, 2, 3);
		System.out.println("sum = " + sumOfList(li));
		List<Double> ld = Arrays.asList(1.2, 3.2, 3.4);
		System.out.println("sum = " + sumOfList(ld));
	}
}