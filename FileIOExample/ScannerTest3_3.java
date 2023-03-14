import java.io.File;
import java.util.Scanner;
public class ScannerTest3_3 {
	public static void main(String[] args) throws Exception{
		Scanner s1 = new Scanner(new File("test.txt"));
		Scanner s2 = null;
		int flag = 0;
		int tot_Sum = 0;
		
		while(s1.hasNextLine()) {
			String line = s1.nextLine();
			s2 = new Scanner(line).useDelimiter(",");
			int sum = 0;
			
			while(s2.hasNextInt()) {
				sum += s2.nextInt();
			}
			
			System.out.println(line);
			System.out.println("sum = " + sum);
			tot_Sum += sum;
			flag++;
			s2.close();
		}
		
		System.out.println("Line : " + flag + " Total : " + tot_Sum);
		s1.close();

	}

}
