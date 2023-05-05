class Rect{
	int width, height;
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
}
public class ObjectPropertyEx {
	public static void main(String[] args) {
		Rect p = new Rect(15, 20);
		System.out.println(p.getClass().getName());
		//get class는 클래스 정보를 담은 Class 객체를 리턴한다.
		//Class 객체의 getName() 메소드는 객체의 클래스 이름을 리턴
		System.out.println(p.hashCode());
		//(객체마다 다른)객체의 해시코드 값을 리턴
		System.out.println(p.toString());
		//객체를 문자열로 리턴
		//오버라이딩을 하지 않으면 아래와 같이 출력된다.
		//getClass().getName() + '@' + Integer.toHexString(hashCode())
		System.out.println(p);
		//객체를 출력하면 해당 객체의 toString()을 자동 호출한다. 
	}
}