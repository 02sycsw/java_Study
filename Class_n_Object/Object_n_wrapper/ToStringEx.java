class Rect{
	int width, height;
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public String toString() {
		return "Rect(" + width + ", " + height + ")";
	}
}
public class ToStringEx {
	public static void main(String[] args) {
		Rect p = new Rect(15, 20);
		System.out.println(p.toString());
		System.out.println(p);
	}
}