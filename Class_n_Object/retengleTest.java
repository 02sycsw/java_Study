class rectangle{
	private int x, y, width, height;
	
	public rectangle() {
		this(0, 0, 1, 1);
	}
	public rectangle(int x, int y, int width, int height){
		this.x = x;
		this.y = y;

		if(width > 0)
			this.width = width;
		else {
			System.out.println("사각형 가로 길이는 음수가 될 수 없습니다.");
			this.width = 1;
		}
		if(height > 0)
			this.height = height;
		else {
			System.out.println("사각형 세로 길이는 음수가 될 수 없습니다.");
			this.height = 1;
		}
	}
	
	public void set(int x, int y, int width, int height) {
		if(width < 0 || height < 0) {
			System.out.println("사각형 크기는 음수가 될 수 없습니다.");
		}
		else {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
	}
	
	public int area() {
		int area;
		area = width * height;
		return area;
	}
	
	public void printInfo() {
		System.out.printf("좌표: (%d, %d), 크기: (%d, %d), ", 
				x, y, width, height);
		System.out.printf("면적: %d\n", area());
	}
	
	public boolean equls(rectangle x) {
		if((this.width == x.width) && (this.height == x.height))
			return true;
		else
			return false;
	}
}
public class retengleTest {
	public static void main(String[] args) {
		rectangle r = new rectangle();
		rectangle s = new rectangle(1, 2, 10, 15);
		
		r.printInfo();
		s.printInfo();
		
		System.out.println(s.area());
		
		r.set(-3, 2, -1, 4);
		r.printInfo();
		
		if(r.equals(s))
			System.out.println("두 사각형은 같습니다.");
		else
			System.out.println("두 사각형은 다릅니다.");
	}

}
