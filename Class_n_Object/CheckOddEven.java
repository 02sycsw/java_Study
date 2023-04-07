import java.util.Scanner;

public class CheckOddEven {
	public boolean checkEven(int num) {
		return ((num % 2) == 0);
	}
	
	public static boolean checkEven2(int num) {
		return ((num % 2) == 0);
	}
	//정적(static)멤버
	//전역 변수와 전역 함수를 만들 때 사용한다. 
	//공유 멤버를 만들고 싶을 때도 쓰는데, 공유 멤버는 클래스의 객체들이 공유한다.
	
	public static void main(String[] args) {
		int inPut;
		Scanner s = new Scanner(System.in);
		
		System.out.print("1개의 정수 입력: ");
		inPut = s.nextInt();
		s.close();
		
		//static을 안 쓰고 obj를 쓰는 경우
//		CheckOddEven obj = new CheckOddEven();
//		if(obj.checkEven(inPut))
//			System.out.println(inPut + ": 짝수");
//		else
//			System.out.println(inPut + ": 홀수");
		
		
		//static을 쓰는 경우
		if(checkEven2(inPut))
			System.out.println(inPut + ": 짝수");
		else
			System.out.println(inPut + ": 홀수");

	}

}
