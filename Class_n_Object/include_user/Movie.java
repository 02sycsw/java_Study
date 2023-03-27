import java.time.LocalDateTime;
public class Movie {
	String name;
	LocalDateTime time;
	int left;
	int price;
	
	Ticket ticketing(int refer) {		
		Ticket ticket = new Ticket();
		
		ticket.people = refer;
		ticket.name = this.name;
		ticket.time = this.time;
		ticket.price = this.price * refer;
		
		System.out.println("예매가 완료되었습니다.");
		
		return ticket;
	}
	
	void Display_info() {
		System.out.printf("영화 이름: %s, 상영시간: %s, 잔여석: %d, 가격: %d\n"
				, name, time, left, price);
	}
	
}