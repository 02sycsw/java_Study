import java.util.Scanner;
public class ScannerTest1_1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("두 개의 숫자(정수)를 입력해주세요 : ");
		int num1 = s.nextInt();
		int num2 = s.nextInt();
		System.out.println("합 : " + (num1+num2));
		
		System.out.print("두 개의 숫자(실수)를 입력해주세요 : ");
		double num3 = s.nextDouble();
		double num4 = s.nextDouble();
		System.out.println("합 : " + (num3+num4));
		
		s.close();
	}
}