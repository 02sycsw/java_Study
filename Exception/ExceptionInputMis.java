import java.util.InputMismatchException;
import java.util.Scanner;
public class ExceptionInputMis {
	public static void main(String[] args) {
		int sum = 0, n = 0;
		Scanner s = new Scanner(System.in);
		
		System.out.println("정수 3개를 입력하세요");
		for(int i = 0; i<3; i++) {
			System.out.print(i + 1 + "번째 입력: ");
			
			try {
				n = s.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("정수가 아닙니다. 다시 입력하세요.");
				s.next(); //입력 스트림에 있는 정수가 아닌 토큰을 버린다. 
				i--;
				continue;
			}
			sum += n;
		}
		System.out.println("합은 " + sum);
		s.close();
	}
}
