class Car{
	public Car() {
		System.out.println("자동차");
	}
	public Car(int num) {
		System.out.println("자동차(숫자)");
	}
}

class passCar extends Car {
	public passCar() {
		System.out.println("승용차");
	}
	public passCar(int num) {
		super(num);
		//subclass에서 명시적으로 superclass의 생성자를 선택 호출할 때 사용한다.
		//반드시 subclass 생성자 코드의 첫번째 라인에 위치해야 한다.
		System.out.println("승용차(숫자)");
	}
}

class Taxi extends passCar {
	public Taxi() {
		System.out.println("택시");
	}
	public Taxi(int num) {
		super(num);
		System.out.println("택시(숫자)");
	}
}

public class carTest {
	public static void main(String[] args) {
		Taxi taxi = new Taxi(3);
		//subclass의 생성자가 먼저 호출되고 
		//subclass의 생성자가 실행 전 superclass 생성자를 호출한다. 
		//superclass의 생성자가 먼저 실행된 후 subclass의 생성자가 실행된다. 
	}

}
