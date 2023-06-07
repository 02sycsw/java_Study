import java.io.FileOutputStream;
public class FileOutputStreamEx {
	public static void main(String[] args) throws Exception{
		FileOutputStream fout = new FileOutputStream("test.bin");
		
		int num[] = {1, 2, 3, 4, 5};
		byte b[] = {1, 2, 3, 4, 5, 6, 7};
		
		for(int i = 0; i<num.length; i++) {
			fout.write(num[i]);
		}
		fout.write(b);
		
		fout.close();
	}
}