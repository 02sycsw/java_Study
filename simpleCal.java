public class simpleCal {
	public int add(int num1, int num2) {
		int result;
		result = num1 + num2;
		return result;
	}
	public int add(int num1, int num2, int num3) {
		int result;
		result = add(num1, num2) + num3;
		return result;
	}
	public double add(double num1, double num2) {
		double result;
		result = num1 + num2;
		return result;
	}
	public double add(double num1, double num2, double num3) {
		double result;
		result = add(num1, num2) + num3;
		return result;
	}
	public static void main(String[] args) {
		simpleCal cal = new simpleCal();
		int re_int = cal.add(3, 4);
		int re_int_2 = cal.add(3, 4, 5);
		double re_dou = cal.add(3.5, 4.7);
		double re_dou_2 = cal.add(3.5, 4.7, 1.2);
		
		System.out.printf("%d + %d = %d\n", 3, 4, re_int);
		System.out.printf("%d + %d + %d = %d\n", 3, 4, 5, re_int_2);
		System.out.printf("%.1f + %.1f = %.1f\n", 3.5, 4.7, re_dou);
		System.out.printf("%.1f + %.1f + %.1f = %.1f\n", 3.5, 4.7, 1.2, re_dou_2);

	}

}
