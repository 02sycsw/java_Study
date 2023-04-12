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
	public void ShowDetailInfo2D() {
		ShowInfo();
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
	public void ShowDetailInfo3D() {
		ShowDetailInfo2D();
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
	public void ShowDetailInfo2D() {
		ShowInfo();
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
	public void ShowDetailInfo3D() {
		ShowDetailInfo2D();
		System.out.printf("좌표(z축): %d\n", z);
		System.out.printf("깊이: %d\n", depth);
	}
}

public class shapeTest {
	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.ShowInfo();
		
		Circle circle = new Circle("동전", 5, 3, 4);
		circle.ShowDetailInfo2D();
		
		Rect rectangle = new Rect("타일", 7, 5, 11, 13);
		rectangle.ShowDetailInfo2D();
		
		Sphere sphere = new Sphere("공", 9, 9, 5, 8);
		sphere.ShowDetailInfo3D();
		
		Box box = new Box("책", 1, 3, 7, 7, 13, 11);
		box.ShowDetailInfo3D();
		
		Box box1 = new Box();
		box1.ShowDetailInfo3D();

	}

}
