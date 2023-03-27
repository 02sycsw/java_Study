import java.time.LocalDateTime;
import java.util.Scanner;

public class User {
	String user_name;
	String tel;
	Ticket ticket;
	int left_money;
	
	void ticketing(Movie movie, int refer) {
		if(left_money >= movie.price * refer) {
			Ticket ticket = movie.ticketing(refer);
			this.ticket = ticket;
			left_money -= ticket.price;
			Display_info();
		}
		else {
			System.out.println("잔액이 부족합니다.");
		}
	}
	
	void Display_info() {
		System.out.printf("유저 정보 출력: 이름: %s, 전화번호: %s, 티켓: %s, 잔액: %d\n", 
				user_name, tel, ticket, left_money);
	}
	public static void main(String[] args) {
		Movie movie = new Movie();
		movie.name = "라라랜드";
		movie.price = 15000;
		movie.left = 50;
		movie.time = LocalDateTime.now();
		
		User user = new User();
		user.user_name = "홍길동";
		user.tel = "010-0000-1111";
		user.left_money = 100000;
		
		Scanner s = new Scanner(System.in);
		int refer_num;
		System.out.print("예매할 사람 수는? ");
		refer_num = s.nextInt();
		s.close();
		
		user.ticketing(movie, refer_num);
	}

}
