class Rect {
	int width, height;
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	//Rect class의 width, height가 동일한 경우 true 반환
	//equals 메소드는 객체의 내용물을 비교하기 위해 클래스의 멤버로 작성된다.
	public boolean equals(Rect p) {
		if(width == p.width && height == p.height)
			return true;
		else
			return false;
	}
}
public class EqualEx {
	public static void main(String[] args) {
		Rect a = new Rect(15, 20);
		Rect b = new Rect(15, 20);
		Rect c = new Rect(20, 30);
		
		if(a == b)
			System.out.println("a == b");
		//==은 객체의 레퍼런스를 비교한다. 
		//a와 b는 내용물은 같지만 같은 객체를 가리키는 게 아니기 때문에 false다. 
		
		if(a.equals(b))
			System.out.println("a is equal to b");
		if(a.equals(c))
			System.out.println("a is equal to c");

	}

}
