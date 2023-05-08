public class String_Method {
	public static void main(String[] args) {
		String android = "android";
		String java = "java";
		int result1 = android.compareTo(java);
		System.out.println("비교 결과: " + result1);
		//두 문자열을 사전 순서로 비교한다. 
		//0은 동일할 때, 그 외의 값은 알파벳 순서에 따라서 다르다. 
		//a(1)에 비해서 파라미터로 들어온 j(10)가 값이 더 크기 때문에 -9가 반환된다.
		
		String src = "Hello ";
		String result2 = src.concat("Java");
		System.out.println("결과: " + result2);
		//기존 문자열 뒤에 새로운 문자열을 결합해서 반환한다. 
		
		String result3 = String.format("0x%X: %s", 0xff0000, "빨강");
		System.out.println(result3);
		//지정된 형식으로 새로운 문자열을 생성해서 반환한다. 
		
		String old = "사과는 맛있고 사과는 건강하다.";
		String result4 = old.replace("사과", "망고");
		System.out.println("문자열 대치 결과: " + result4);
		//String replace(CharSequence old, CharSequence new)
		//문자열의 모든 old를 새로운 부분 문자열 new로 변경한 후 반환한다.
		
		String regex_b = "□3□+□□5□*9";
		String[] result5 = regex_b.split("[+-/*]");
		for(String s:result5)
			System.out.println(s);
		//정교식을 기준으로 문자열을 분리해서 부분 문자열 배열을 반환한다.
		//부분 문자열 '배열'을 반환하기 때문에 String[]으로 해야 한다. 
		
		String trim_b = "  5 ";
		String result6 = trim_b.trim();
		System.out.println("공백 제거 결과: " + result6);
		//공백 문자를 제거한 결과를 반환한다. 
		
		String str1 = "Have a nice day!";
		String result7 = str1.substring(5);
		System.out.println(result7);
		//idx에서부터 끝까지 부분 문자열을 반환한다. 
		
		String str2 = "Have a nice day!";
		String result = str2.substring(7, 11);
		System.out.println(result);
		//idx_1에서 idx_2까지의 부분 문자열을 반환한다. 
		
	}

}
