import java.util.*;
public class GenericAverage {
	public static <E> void randomInput(List <? super Integer> arr) {
		for(int i = 0; i < 10; i++) {
			int randNum = (int)(Math.random() * 100) + 1;
			arr.add(randNum);
		}
	}
	public static <E> void printArray(List <E> arr) {
		for(E element:arr) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int iSum = 0;
		double dSum = 0.0;
		
		List<Integer> intArray = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			int randNum = (int)(Math.random()*100) + 1;
			intArray.add(randNum);
			iSum += randNum;
		}
		System.out.println("elements in Integer Vector...");
		//GenericAverage.printArray(intArray);
		//<타입>을 생략해도 동작
		GenericAverage.<Integer>printArray(intArray);
		System.out.println("정수 합: " + iSum);
		System.out.println("정수 평균: " + (double)iSum / intArray.size());
		
		List<Double> doubleArray = new ArrayList<Double>();
		for(int i = 0; i < 10; i++) {
			double randNum = Math.random()*5 + 1;
			doubleArray.add(randNum);
			dSum += randNum;
		}
		
		GenericAverage.<Double>printArray(doubleArray);
		System.out.println("실수 합: " + dSum);
		System.out.println("실수 평균: " + (double)dSum / doubleArray.size());
	}

}
