import java.io.File;
import java.util.Scanner;
public class ScannerTest4_4 {
	public static void main(String[] args) throws Exception {
		Scanner s1 = new Scanner(new File("Salaries.csv"));
		Scanner s2 = null;
		int flag = 0, flag_inner = 0;
		int tot_Sum = 0;
		
		while(s1.hasNextLine()) {
			String line = s1.nextLine();
			s2 = new Scanner(line).useDelimiter(",");
			
			while(s2.hasNext()) {
				flag_inner++;
				String temp = s2.next();
				if(flag >=1 && flag_inner % 6 == 0) {
					int num;
					num = Integer.parseInt(temp);
		            System.out.println(num);					
					tot_Sum += num;
				}
			}
			flag++;
			s2.close();
		}
		System.out.println("sum : " + tot_Sum);
		s1.close();
	}

}
