import java.io.IOException;
import java.io.PrintWriter;
public class testFileMake2 {
	public static void main(String[] args) throws IOException{
		PrintWriter pw = new PrintWriter("out2.txt");
		for(int i = 1; i<21; i++) {
			String data = i + "번째 줄입니다.";
			pw.println(data);
		}
		pw.close();

	}

}
