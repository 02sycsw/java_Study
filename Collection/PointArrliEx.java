import java.util.ArrayList;

class Point{
	private int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	//모든 자바 클래스는 Object 클래스를 자동으로 상속, Object 클래스에는 toString이라는 메소드가 포함되어있다.
	//toString 메소드는 객체가 가지고 있는 정보/값을 문자열로 만들어 리턴하는 메소드
	//클래스를 만들 때 원하는 문자열 형식으로 재정의(오버라이딩)해서 사용하면 된다. 
}

public class PointArrliEx {
	public static void main(String[] args) {
		ArrayList<Point> v = new ArrayList<>();
		
		v.add(new Point(5, 5));
		v.add(new Point(2, 9));
		v.add(new Point(-7, -8));
		
		for(int i = 0; i < v.size(); i++) {
			Point p = v.get(i);
			System.out.println(p);
		}
	}

}
