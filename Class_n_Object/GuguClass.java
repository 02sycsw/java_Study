public class GuguClass {
	static int outPut;
	String name;
	
	public void inFo() {
		System.out.println("단: " + outPut); //정적 멤버 접근 가능
		System.out.println(name); //비정적 멤버 접근 가능
	}
	
	public static void main(String[] args) {		
		//System.out.println(name); //비정적 멤버 접근 불가
		//inFo(); //비정적 멤버 접근 불가
		//공유 멤버가 아닌 게 들어가서
		
		for(int n = 1; n < 10; n++)
			System.out.printf("%d * %d = %d \n", outPut, n, outPut*n);
	}
}
