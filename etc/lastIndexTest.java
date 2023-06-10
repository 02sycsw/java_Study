import java.io.File;
public class lastIndexTest {
	public static void main(String[] args) {
		File file = new File("readtest.txt");
		String fileName = file.getName();
		int index = fileName.lastIndexOf(".");
		
		if(index > 0) {
			String extension = fileName.substring(index + 1);
			System.out.println(extension);
		}
	}
}