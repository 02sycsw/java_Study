class Shape {
	protected String name;
	protected int x, y;
	
	public Shape() {
		this("도형", 0, 0);
	}
	public Shape(String name) {
		this(name, 0, 0);
	}	
	public Shape(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	public void ShowInfo() {
		System.out.println("==== 정보 출력 =======");
		System.out.println("이름: " + name);
		System.out.printf("좌표(2D): %d, %d\n", x, y);
	}
}

class Circle extends Shape{
	protected int radius;
	
	public Circle() {
		super("원");
		this.radius = 0;
	}
	public Circle(String name) {
		super(name);
		this.radius = 0;
	}
	public Circle(String name, int x, int y, int radius) {
		super(name, x, y);
		this.radius = radius;
	}
	public void ShowDetailInfo2D() {
		ShowInfo();
		System.out.printf("반지름: %d\n", radius);
	}
}

public class UpcastingEx {
	public static void main(String[] args) {
		Shape s;
		Circle c = new Circle();
		s = c; //upcasting
		//subclass의 레퍼런스를 superclass의 레퍼런스에 대입
		//superclass의 멤버만 접근 가능
		
		s.x = 10;
		s.y = 15;
		//s.radius = 7; //오류
		
		Circle newC = (Circle)s; //downcasting
		//superclass의 레퍼런스를 subclass 레퍼런스에 대입
		//upcasting한 것을 다시 원래대로 되돌리는 것
		//명시적 형변환 필요
		
		newC.radius = 7;		
	}
}