public class User {
	private String user_name;
	private String tel;
	private Ticket ticket;
	private int left_money;
	
	public User() {
		this.user_name = "손님";
		this.left_money = 0;
		this.tel = "010-0000-1111";
	}
	
	public User(String user_name, int left_money, String tel) {
		this.user_name = user_name;
		this.left_money = left_money;
		this.tel = tel;
	}
	
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
		if(left_money >= movie.get_price() * refer) {
			Ticket ticket = movie.ticketing(refer);
			this.ticket = ticket;
			left_money -= ticket.get_price();
			Display_User_info();
		}
		else {
			System.out.println("잔액이 부족합니다.");
			System.out.printf("현재 잔액은 %d원이고, %d원이 부족합니다.", 
					left_money, (left_money - movie.get_price() * refer) * (-1));
		}
	}
	
	void Display_User_info() {
		System.out.printf("유저 정보 출력: 이름: %s, 전화번호: %s, 티켓: %s, 잔액: %d\n", 
				user_name, tel, ticket, left_money);
	}
}
