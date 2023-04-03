import java.util.Scanner;

public class ExceptionArithmetic {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("분자 입력: ");
		int mole = s.nextInt();
		System.out.print("분모 입력: ");
		int dom = s.nextInt();
		
		try {
			System.out.println(mole + "/" + dom + "의 몫: " + mole/dom);
		}
		catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
			System.out.println("1로 설정합니다.");
			dom = 1;
			System.out.println(mole + "/" + dom + "의 몫: " + mole/dom);
		}
		finally {
			s.close();
		}
	}

}
