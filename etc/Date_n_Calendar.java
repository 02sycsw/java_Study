import java.util.*;
import java.text.SimpleDateFormat;

public class Date_n_Calendar {
	//Calendar를 이용해 원하는 날짜로 초기화
	public static Date getDate(int year, int month, int date) {
		Calendar cal = Calendar.getInstance();
		//Calendar는 추상 클래스기 때문에 new 연산자를 통해 객체를 생성할 수 없다.
		//getInstance() 메소드를 이용해서 간접적으로 객체를 얻을 수는 있다.
		cal.set(year, month-1, date);
		return new Date(cal.getTimeInMillis());
	}
	public static void main(String[] args) {
		Date date = getDate(2021, 9, 3);
		System.out.println(date);
		SimpleDateFormat fDay = new SimpleDateFormat("yyyy.MM.dd.");
		//날짜, 시간을 원하는 문자열 포맷으로 바꾸고 싶을 때 사용 
		
		String sfDay = fDay.format(date);
		System.out.println(sfDay);
	}
}
