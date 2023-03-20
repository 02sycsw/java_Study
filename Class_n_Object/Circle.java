public class Circle{
	int radius; 
	String name; //필드(내부 멤버)
	
	public double area_Cal() { //면적 계산 메소드
		return 3.14 * radius * radius;
	}
	
	public static void main(String[] args) {
		Circle Little; //변수 선언
		Little = new Circle(); //Circle 객체 생성
		Little.radius = 10;
		Little.name = "Coin";
		double area1 = Little.area_Cal();
		
		Circle Big;
		Big = new Circle();
		Big.radius = 90;
		Big.name = "Wheel";
		double area2 = Big.area_Cal();
		
		System.out.println(Little.name + "의 면적은 " + area1);
		System.out.println(Big.name + "의 면적은 " + area2);
		
		Circle other;
		other = new Circle();
		other = Little;
		Big = Little;
		area2 = Big.area_Cal();
		double area3 = other.area_Cal();
		
		System.out.println("객체의 치환 후");
		System.out.println(Little.name + "의 면적은 " + area1);
		System.out.println(Big.name + "의 면적은 " + area2);
		System.out.println(other.name + "의 면적은 " + area3);
		
	}
}