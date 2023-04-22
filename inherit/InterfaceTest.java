interface RemoteControl{
	void turnOn();
	void turnOff();
	public default void printBrand() {
		System.out.println("Remote Control 가능 TV");
	}
	//default 메소드
	//실행블록을 가지는 메소드로 default 키워드를 반드시 사용해야 한다.
	//public으로 가정한다.
}

class TV implements RemoteControl{
	boolean on;
	public void turnOn() {
		on = true;
		System.out.println("TV가 켜졌습니다.");
	}
	public void turnOff() {
		on = false;
		System.out.println("TV가 꺼졌습니다.");
	}
	public void printBrand() {
		System.out.println("JAVA TV입니다.");
	}
}

public class InterfaceTest{
	public static void main(String[] args) {
		RemoteControl obj = new TV();
		obj.turnOn();
		obj.turnOff();
		obj.printBrand();
	}
}