import java.time.LocalDateTime;
public class Movie {
	private String name;
	private LocalDateTime time;
	private int left;
	private int price;
	
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
	
	public int get_left() {
		return left;
	}
	public void set_left(int left) {
		this.left = left;
	}
	
	public int get_price() {
		return price;
	}
	public void set_price(int price) {
		this.price = price;
	}
	
	Ticket ticketing(int refer) {		
		Ticket ticket = new Ticket();
		
		ticket.set_people(refer);
		ticket.set_name(this.name);
		ticket.set_time(this.time);
		ticket.set_price(this.price * refer);
		
		System.out.println("예매가 완료되었습니다.");
		
		return ticket;
	}
	
	void Display_info() {
		System.out.printf("영화 이름: %s, 상영시간: %s, 잔여석: %d, 가격: %d\n"
				, name, time, left, price);
	}
	
}