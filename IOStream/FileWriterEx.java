import java.io.*;
public class FileWriterEx {
	public static void main(String[] args) {
		int c;
		
		try(InputStreamReader in = new InputStreamReader(System.in);
				FileWriter fout = new FileWriter("c:\\tmp\\test.txt", true);){
			//FileWriter(String name, boolean append) append가 true이면 파일의 마지막부터 데이터를 저장
			//default는 false
			while((c = in.read()) != -1)
				fout.write(c);
			System.out.println(fout.getEncoding());
			//출력 스트림이 사용하는 문자 집합의 이름을 반환
			//결과: UTF8
		}catch(IOException e) {
			System.out.println("입출력 오류");
		}
	}
}