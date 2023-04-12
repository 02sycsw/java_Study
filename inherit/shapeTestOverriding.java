class Shape {
	protected String name;
	protected int x, y;
	
	public Shape() {
//		this.name = "도형";
//		this.x = 0;
//		this.y = 0;
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
	public void ShowInfo() {
		super.ShowInfo();
		System.out.printf("반지름: %d\n", radius);
	}
}

class Sphere extends Circle {
	protected int z;
	
	public Sphere() {
		super("구");
		this.z = 0;
	}
	public Sphere(String name, int x, int y, int z, int radius) {
		super(name, x, y, radius);
		this.z = z;
	}
	public void ShowInfo() {
		super.ShowInfo();
		System.out.printf("좌표(z축): %d\n", z);
	}
}

class Rect extends Shape{
	protected int width, height;
	
	public Rect() {
		super("사각형", 0, 0);
		this.width = 1;
		this.height = 1;
	}
	public Rect(String name) {
		super(name, 0, 0);
		this.width = 1;
		this.height = 1;
		//this.width = this.height = 1;
	}
	public Rect(String name, int x, int y, int width, int height) {
		super(name, x, y);
		this.width = width;
		this.height = height;
	}
	public void ShowInfo() {
		super.ShowInfo();
		System.out.printf("너비, 높이: %d, %d\n", width, height);
	}
}

class Box extends Rect{
	protected int z, depth;
	
	public Box() {
		super("육면체", 0, 0, 1, 1);
		this.z = 0;
		this.depth = 1;
	}
	public Box(String name, int x, int y, int z, int width, int height, int depth) {
		super(name, x, y, width, height);
		this.z = z;
		this.depth = depth;
	}
	public void ShowInfo() {
		super.ShowInfo();
		System.out.printf("좌표(z축): %d\n", z);
		System.out.printf("깊이: %d\n", depth);
	}
}

public class shapeTestOverriding {
	static void ShowInfo(Shape s) {
		s.ShowInfo();
	}
	
	public static void main(String[] args) {
		ShowInfo(new Shape());
		ShowInfo(new Rect());
		ShowInfo(new Circle());
		ShowInfo(new Box());
	}
	//다형성polymorphism은
	//한 클래스 내에서 같은 이름이지만 다르게 동작(method overloading)하도록 구현하는 것
	//동일한 이름의 동작(method)를 클래스에 따라 다르게(method overriding) 구현하는 것
	//final 메소드는 오버라이딩이 불가능하다. 
}
