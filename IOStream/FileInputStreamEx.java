import java.io.FileInputStream;
public class FileInputStreamEx {
	public static void main(String[] args) throws Exception {
		byte [] b = new byte [12]; //byte 배열 생성
		
		try {
			FileInputStream fin = new FileInputStream("test.bin");
			int n = 0, c;
			
			while((c = fin.read()) != -1)
				b[n++] = (byte)c; //읽은 바이트를 배열에 저장
			
			System.out.println("test.bin을 출력합니다.");
			for(int i = 0; i<b.length; i++)
				System.out.print(b[i] + " ");
			System.out.println();
			
			fin.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}