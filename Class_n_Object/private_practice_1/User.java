import java.time.LocalDateTime;

public class User {
	private String user_name;
	private String tel;
	private Ticket ticket;
	private int left_money;
	
	public String get_user_name() {
		return user_name;
	}
	
	public void set_user_name(String user_name) {
		this.user_name = user_name;
	}
	
	public String get_tel() {
		return tel;
	}
	
	public void set_tel(String tel) {
		this.tel = tel;
	}
	
	public Ticket get_ticket() {
		return ticket;
	}
	
	public void set_ticket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public int get_left_money() {
		return left_money;
	}
	
	public void set_left_money(int left_money) {
		this.left_money = left_money;
	}
	
	
	
	void ticketing(Movie movie, int refer) {
		Ticket ticket = movie.ticketing(refer);
		this.ticket = ticket;
		left_money -= ticket.get_price();
		
	}
	
	public void Display_User_info() {
		System.out.println("유저 정보 출력");
		System.out.printf("이름: %s, 전화번호: %s, 티켓: %s, 잔액: %d\n"
				, user_name, tel, ticket, left_money);
	}

}
