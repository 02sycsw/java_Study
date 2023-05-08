public class Compare_String {
	public static void main(String[] args) {
		if("java".equals("java"))
			System.out.println("동일함(0)");
		
		String str1 = "java";
		String str2 = "java";
		if(str1 == str2) 
			System.out.println("동일함(1-1)");
		if(str1.equals(str2))
			System.out.println("동일함(1-2)");
		//문자열 리터럴을 이용해서 만들면
		//자바 가상 기계 내부에서 리터럴 테이블에 저장되고 공유된다. 
		//같은 내용의 문자열이면 같은 객체를 가리킨다. 
		
		String str3 = new String("java");
		String str4 = new String("java");
		if(str3 == str4)
			System.out.println("동일함(2-1)");
		if(str3.equals(str4))
			System.out.println("동일함(2-2)");
		//new String()으로 문자열을 만들면
		//힙 영역에 생성되고 공유되지 않는다.
		//같은 내용의 문자열이어도 다른 객체를 가리킨다.

	}

}
