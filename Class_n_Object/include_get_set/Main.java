import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Movie movie = new Movie();
		movie.set_name("라라랜드");
		movie.set_price(15000);
		movie.set_left(50);
		movie.set_time(LocalDateTime.now());
		
		User user = new User();
		user.set_user_name("홍길동");
		user.set_tel("010-0000-1111");
		user.set_left_money(100000);
		
		Scanner s = new Scanner(System.in);
		int refer_num;
		System.out.print("예매할 사람 수는? ");
		refer_num = s.nextInt();
		s.close();
		
		user.ticketing(movie, refer_num);
	}
}
