public class MonthTest {
	public static void main(String[] args) {
		Month today = Month.APRIL;
		Month nextMonth = Month.MAY;
		
		System.out.println(today.name()); //"APRIL" 반환
		System.out.println(today.ordinal()); 
		//인덱스가 0부터 시작하기 때문에 (4-1)반환
		
		int diff1 = today.compareTo(nextMonth);
		int diff2 = nextMonth.compareTo(today);
		//compareTo(열거형 변수) 두 열거 객체의 값을 비교하여 차이를 반환한다.
		
		System.out.println("diff1(today - nextMonth): " + diff1);
		System.out.println("diff2(nextMonth - today): " + diff2);
		
		Month[] months = Month.values();
		//values()를 쓰면 열거 배열로 모든 값을 가지는 배열을 반환한다. 
		for(Month m : months) {
			System.out.println(m);
		}
	}
}
