public class GenericMethodPrint {
	public static <E> void printArray(E [] inputArray) {
		for(E element:inputArray) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Integer[] intArray = {1, 2, 3, 4, 5};
		Double[] doubleArray = {1.2, 3.2, 4.0};
		Character[] charArray = {'j', 'a', 'v', 'a'};
		
		System.out.println("[ 정수 배열 ]");
		printArray(intArray); //Integer 배열 전달
		System.out.println("[ 실수 배열 ]");
		printArray(doubleArray); //Double 배열 전달
		System.out.println("[ 문자 배열 ]");
		printArray(charArray); //Character 배열 전달
	}
}