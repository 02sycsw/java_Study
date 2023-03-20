import java.time.LocalDateTime;
public class Ticket {
	String name;
	LocalDateTime time;
	int price;
	int people;
	
	public void Display_info() {
		System.out.printf("영화 이름: %s, 상영시간: %s, 가격: %d, 인원수: %d"
				, name, time, price, people);
	}
}
