import java.io.FileOutputStream;
import java.io.IOException;
public class testFileMake {
	public static void main(String[] args)throws IOException {
		FileOutputStream output = new FileOutputStream("out.txt");
		for(int i = 1; i<11; i++) {
			String data = i + "번째 줄입니다.\r\n";
			output.write(data.getBytes());
		}
        output.close();
	}
	//소스코드 출처: https://wikidocs.net/227
}
