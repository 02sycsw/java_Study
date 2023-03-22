import java.time.LocalDateTime;
public class Ticket {
	private String name;
	private LocalDateTime time;
	private int price;
	private int people;
	
	public String get_name() {
		return name;
	}
	
	public void set_name(String name) {
		this.name = name;
	}
	
	public LocalDateTime get_time() {
		return time;
	}
	
	public void set_time(LocalDateTime time) {
		this.time = time;
	}
	
	public int get_price() {
		return price;
	}
	
	public void set_price(int price) {
		this.price = price;
	}
	
	public int get_people() {
		return people;
	}
	
	public void set_people(int people) {
		this.people = people;
	}
	
	public void Display_info() {
		System.out.printf("영화 이름: %s, 상영시간: %s, 가격: %d, 인원수: %d"
				, name, time, price, people);
	}
}
