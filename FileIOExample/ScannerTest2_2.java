import java.util.Scanner;
public class ScannerTest2_2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = "";
		
		do {
			System.out.print("값을 입력하세요(입력을 마치려면 Q를 입력하세요) : ");
			input = s.nextLine();
			System.out.println("입력한 값은 " + input + "입니다.");
		}while(!input.equalsIgnoreCase("q"));
		//equalsIgnoreCase는 대소문자 구분 없이 비교할 때 자주 쓰인다.
		
		System.out.println("프로그램을 종료합니다.");
		s.close();
	}

}
