class Point{
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void displayInfo() {
		System.out.printf("(%d, %d)\n", x, y);
	}
}

class ColorPoint extends Point{
	private String color;
	
	public ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}
	public void displayInfo() {
		System.out.print(color + " ");
		super.displayInfo();
	}
}
public class pointTest {

	public static void main(String[] args) {
		Point point = new Point(5, 7);
		point.displayInfo();
		
		ColorPoint colorPoint = new ColorPoint(2, 9, "blue");
		colorPoint.displayInfo();
	}

}
