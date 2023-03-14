import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class testFileRead1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("out.txt"));
		while(true) {
			String line = br.readLine();
			if(line == null) break;
			//더이상 읽을 라인이 없는 경우 while문을 빠져나간다.
			System.out.println(line);
		}
		br.close();
		
		//읽을 라인이 없을 때까지만 작동해서 나머지 공간만큼 쓰레기값이 출력되지 않는다.
	}

}
