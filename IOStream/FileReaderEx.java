import java.io.*;
public class FileReaderEx {
	public static void main(String[] args) throws Exception {
		try(FileReader in = new FileReader("c:\\windows\\system.ini")){
			int c;
			while((c = in.read()) != -1)
				System.out.print((char)c);
		}catch(IOException e) {
			System.out.println("입출력 오류");
		}
	}
}