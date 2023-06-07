import java.io.*;
public class FileOutputStreamEx2 {
	public static void main(String[] args) {
		byte b[] = {7, 51, 3, 4, -2, 21};
		
		try {
			FileOutputStream fout = new FileOutputStream("test.bin");
			for(int i = 0; i<b.length; i++)
				fout.write(b[i]);
			fout.close();
		}catch(IOException e) {}
		
		//try with resource 사용
		//close()를 사용하지 않고 try 안의 코드가 모두 실행된 후 자동으로 close()메소드를 호출한다
		//try-with-resource 안에 사용하는 클래스는 AutoCloseAble를 상속해야한다.
		
		/*try(FileOutputStream fout = new FileOutputStream("test.bin")) {
			for(int i = 0; i<b.length; i++)
				fout.write(b[i]); //배열 b의 바이너리를 그대로 기록
			//fout.close();
		}catch(IOException e) {}*/
		
		System.out.println("test.bin을 저장하였습니다.");
	}
}
