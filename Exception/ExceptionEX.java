import java.util.Scanner;

public class ExceptionEX {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("분자 입력: ");
		int mole = s.nextInt();
		System.out.print("분모 입력: ");
		int dom = s.nextInt();
		
		System.out.printf("%d / %d 의 몫은, %.3f", mole, dom, mole/dom);

		s.close();
	}

}