import java.io.FileInputStream;
import java.io.IOException;
public class testFileRead {
	public static void main(String[] args) throws IOException {
		byte[] b = new byte[1024];
		FileInputStream input = new FileInputStream("out.txt");
		input.read(b);
		System.out.println(new String(b));
		//byte 배열을 문자열로 변경해서 출력
		input.close();
	}

}
