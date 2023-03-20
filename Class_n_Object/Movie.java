import java.time.LocalDateTime;
import java.util.Scanner;
public class Movie {
	String name;
	LocalDateTime time;
	int left;
	int price;
	
	Ticket ticketing(int refer) {
		left -= refer;
		
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
	
	public static void main(String[] args) {
		Movie movie = new Movie();
		movie.name = "라라랜드";
		movie.price = 15000;
		movie.left = 50;
		movie.time = LocalDateTime.now();
		
		movie.Display_info();
		
		Scanner s = new Scanner(System.in);
		int num;
		System.out.print("예매할 사람 수는? ");
		num = s.nextInt();
		s.close();
				
		Ticket ticket = movie.ticketing(num);
		ticket.Display_info();
	}

}
