import java.time.LocalDateTime;

//LocalDate: 날짜 정보만 필요할 때 사용
//LocalTime: 시간 정보만 필요할 때 사용
//LocalDateTime: 날짜와 시간 모두 필요할 때 사용
//LocalDate.now(); 로컬 컴퓨터의 현재 날짜 정보를 저장한 LocalDate 객체를 리턴
//LocalDate.of(2023, 3, 20); parameter(인자)로 주어진 날짜 정보를 저장한 LocalDate 객체를 리턴
//.now()는 로컬 컴퓨터의 현재 정보를 저장한 객체 반환
//.of(parameter)는 parameter로 주어진 정보를 저장한 객체 반환
//Time이 들어갈 때 second, nanosecond는 선택 인수

public class Movie_Single {
	String name;
	LocalDateTime time;
	int price;
	int left;
	
	public void ticketing() {
		left--;
		System.out.println("예매가 완료되었습니다.");
	}
	
	public void Display_info() {
		System.out.printf("영화 이름: %s, 상영시간: %s, 가격: %d, 잔여석: %d"
				, name, time, price, left);
	}
	
	public static void main(String[] args) {
		Movie_Single movie_Single = new Movie_Single();
		
		movie_Single.name = "아바타2";
		movie_Single.time = LocalDateTime.of(2023, 3, 20, 9, 54);
		movie_Single.time = LocalDateTime.now();
		movie_Single.price = 15000;
		movie_Single.left = 50;
		
		movie_Single.ticketing();
		movie_Single.Display_info();
	}
	//시간 API 설명 출처: https://java119.tistory.com/52
}