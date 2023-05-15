import java.util.ArrayList;
public class IntegerVectorEx {
	public static void main(String[] args) {
		ArrayList<Integer> v = new ArrayList<>();
		//크기가 10인 AraayList 객체를 생성한다.
		
		v.add(3);
		v.add(7);
		v.add(2);
		//마지막 위치에 원소를 추가하고 결과를 반환한다. 
		
		int sum = 0;
		for(int i = 0; i < v.size(); i++) {
			int n = v.get(i);
			//index 위치의 원소를 반환한다. (+자동으로 언박싱)
			System.out.println(n);
			sum += n;
		}
		
		System.out.println("모든 원소 합: " + sum);
	}
}
