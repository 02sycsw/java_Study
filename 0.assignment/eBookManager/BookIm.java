import java.util.*;
import java.io.*;

class BookBasicInfo {
	private String ISBN; //ISBN
	private String bookTitle; //책 제목
	private Subject bookSubject; //책 분류(예시| 000 총류)
	private String publisher; //책 출판사
	private int publicateDate; //출판날짜(해당하는 책의 Edition 기준)
	private Language lang; //언어
	private Date registrationDate; //그 책을 서버에 등록한 날짜
	private String billSymbol; //청구기호(예시| 005.133-신65이)
	
	public BookBasicInfo(String ISBN, String bookTitle, Subject bookSubject, String publisher, 
			int publicateDate, Language lang, Date registrationDate, String billSymbol) {
		this.ISBN = ISBN;
		this.bookTitle = bookTitle;
		this.bookSubject = bookSubject;
		this.publisher = publisher;
		this.publicateDate = publicateDate;
		this.lang = lang;
		this.registrationDate = registrationDate;
		this.billSymbol = billSymbol;
	}
	
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public Subject getBookSubject() {
		return bookSubject;
	}

	public void setBookSubject(Subject bookSubject) {
		this.bookSubject = bookSubject;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPublicateDate() {
		return publicateDate;
	}

	public void setPublicateDate(int publicateDate) {
		this.publicateDate = publicateDate;
	}

	public Language getLang() {
		return lang;
	}

	public void setLang(Language lang) {
		this.lang = lang;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getBillSymbol() {
		return billSymbol;
	}

	public void setBillSymbol(String billSymbol) {
		this.billSymbol = billSymbol;
	}
	
	public void printAllInfo() {
		System.out.println("ISBN: " + ISBN);
		System.out.println("책 제목: " + bookTitle);
		System.out.println("책 주제: " + bookSubject);
		System.out.println("출판사: " + publisher);
		System.out.println("출판 연도: " + publicateDate);
		System.out.println("언어: " + lang);
		System.out.println("등록 날짜: " + SetDateBasic.formatDate(registrationDate));
		System.out.println("청구 기호: " + billSymbol + "\n");
	}
	
	public String toString() {
		String bookstr = ("책제목: " + bookTitle + "\n");
		bookstr += ("책 주제: " + bookSubject +" ");
		bookstr += ("등록 언어: " + lang + " ");
		bookstr += ("청구 기호: " + billSymbol + "\n");
		
		return bookstr;
	}
}

class BookInfos extends Manage{
	private ArrayList<BookBasicInfo> bInfos = new ArrayList<>();
	private static Scanner s = new Scanner(System.in);
	
	public void selectMenu() throws Exception {
		boolean flag = true;
		
		while(flag) {
			PrintMenu();
			int sel = s.nextInt();
			s.nextLine();
			
			switch(sel) {
			case 1:
				AddData();
				break;
				
			case 2:
				System.out.print("파일 이름을 입력해주세요: ");
				String fileName = s.nextLine();
				AddData(new File(fileName));
				break;
				
			case 3:
				SetData();
				break;
				
			case 4:
				DelData();
				break;
				
			case 5:
				Search();
				break;
				
			case 6:
				print();
				break;
				
			case 7:
				printAll();
				break;
				
			case 8:
				flag = false;
				break;
				
			default:
				System.out.println("잘못된 선택입니다.");
				System.out.println("다시 선택해주세요.");
			}
		}
	}
	
	protected void PrintMenu() {
		System.out.println("\n[ 도서 정보 조회 및 관리 ]");
		System.out.println("1. 도서 데이터 등록 - 직접 입력");
		System.out.println("2. 도서 데이터 등록 - 파일 입력");
		System.out.println("3. 도서 데이터 수정");
		System.out.println("4. 도서 데이터 삭제");
		System.out.println("5. 도서 데이터 검색");
		System.out.println("6. 도서 데이터 출력");
		System.out.println("7. 도서 데이터 전체 정보 출력");
		System.out.println("8. 종료");
		System.out.print("\n메뉴 선택: ");
	}
	
	protected void WriteFile() {
		try (FileOutputStream fileOut = new FileOutputStream("c:\\tmp\\BookInfoTest.ser");
	            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
	            
	        	for(int i = 0; i < bInfos.size(); i++) {
	        		objectOut.writeObject(bInfos.get(i));
	        	}
	        } catch (IOException e) {
	            System.out.println("Serialization error: " + e.getMessage());
	        }
	}
	
	protected void ReadFile() {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:\\tmp\\adminTest.ser"));){
			bInfos.clear();
			while(true) {
				try {
					BookBasicInfo info = (BookBasicInfo)in.readObject();
					if(info != null) {
						bInfos.add(info);
					}
				}catch(EOFException e) {
					break;
				}
			}
		}catch(IOException e) {
			System.out.println("Serialization error: " + e.getMessage());
		}catch(ClassNotFoundException e) {
			System.out.println("클래스 오류");
		}
	}
	
	protected void AddData(BookBasicInfo newBook) {
		bInfos.add(newBook);
	}
	
	protected void AddData() {		
		System.out.print("추가할 책의 ISBN을 입력해주세요: ");
		String ISBN = s.nextLine();
		System.out.print("추가할 책의 제목을 입력해주세요: ");
		String bookTitle = s.nextLine();
		System.out.print("추가할 책의 주제 분류 번호를 입력해주세요: ");
		int sNum = s.nextInt();
		s.nextLine();
		System.out.print("추가할 책의 세부 주제을 입력해주세요: ");
		String sBook = s.nextLine();
		System.out.print("추가할 책의 출판사를 입력해주세요: ");
		String publisher = s.nextLine();
		System.out.print("추가할 책의 출판 연도를 입력해주세요: ");
		int publicateDate = s.nextInt();
		s.nextLine();
		System.out.print("추가할 책의 언어를 입력해주세요: ");
		String lang = s.nextLine();
		System.out.print("추가할 책의 등록 날짜를 입력해주세요: ");
		int registrationDate =  s.nextInt();
		s.nextLine();
		System.out.print("추가할 책의 청구 기호를 입력해주세요: ");
		String billSymbol = s.nextLine();
		
		Subject newSubBook = new Subject(sNum, sBook);
		Language newlang = Language.valueOf(lang);
		
		int year, month, day;
		year = registrationDate / 10000;
		month = (registrationDate / 100) % 100;
		day = registrationDate % 100;
		
		Date newDate = SetDateBasic.getDate(year, month, day);
		
		BookBasicInfo newBookInfo = new BookBasicInfo(ISBN, bookTitle, newSubBook, publisher,
				publicateDate, newlang, newDate, billSymbol);
		
		bInfos.add(newBookInfo);
		WriteFile();
	}
	
	protected void AddData(File file) throws Exception {
		String fileName = file.getName();
		String extension = null;
		int index = fileName.lastIndexOf(".");
		
		if(index > 0)
			extension = fileName.substring(index + 1);
		
		if(extension == null) {
			System.out.println("잘못된 파일입니다.");
		}
		else if(extension.equals("csv")) {
			Scanner s1 = new Scanner(file);
			Scanner s2 = null;
			
			while(s1.hasNextLine()) {
				String line = s1.nextLine();
				s2 = new Scanner(line).useDelimiter(",");
				
				while(s2.hasNext()) {
					String ISBN = s2.next();
					String bookTitle = s2.next();
					String sNum_temp = s2.next();
					int sNum = Integer.parseInt(sNum_temp);
					String sBook = s2.next();
					String publisher = s2.next();
					String publicateDate_temp = s2.next();
					int publicateDate = Integer.parseInt(publicateDate_temp);
					String lang = s2.next();
					String registrationDate_temp =  s2.next();
					int registrationDate = Integer.parseInt(registrationDate_temp);
					String billSymbol = s2.next();
					
					Subject newSubBook = new Subject(sNum, sBook);
					Language newlang = Language.valueOf(lang);
					
					int year, month, day;
					year = registrationDate / 10000;
					month = (registrationDate / 100) % 100;
					day = registrationDate % 100;
					
					Date newDate = SetDateBasic.getDate(year, month, day);
					
					BookBasicInfo newBookInfo = new BookBasicInfo(ISBN, bookTitle, newSubBook, publisher,
							publicateDate, newlang, newDate, billSymbol);
					
					bInfos.add(newBookInfo);
				}
				s2.close();
			}
			s1.close();
			
			WriteFile();
		}
		else if(extension.equals("bin") || extension.equals("ser")) {
			ReadFile();
		}
	}
	
	protected void SetData() {
		System.out.println("책 정보 갱신");
		System.out.print("갱신할 책 제목을 입력해주세요: ");
		String searchTitle = s.nextLine();
		
		BookBasicInfo result = SearchObj(searchTitle);
		
		if(result == null) {
			System.out.println("존재하지 않는 책입니다.");
			return;
		}
		
		System.out.println("1. ISBN");
		System.out.println("2. 책 제목");
		System.out.println("3. 책 분류");
		System.out.println("4. 책 출판사");
		System.out.println("5. 출판 연도");
		System.out.println("6. 언어");
		System.out.println("7. 서버 등록 날짜");
		System.out.println("8. 청구 기호");
		System.out.print("\n갱신할 정보를 선택해주세요: ");
		
		int sel;
		sel = s.nextInt();
		s.nextLine();
		
		switch(sel) {
		case 1:
			System.out.print("갱신할 IBSN: ");
			String ISBN = s.nextLine();
			result.setISBN(ISBN);
			break;
		
		case 2:
			System.out.print("갱신할 책 제목: ");
			String bookTitle = s.nextLine();
			result.setBookTitle(bookTitle);
			break;
			
		case 3:
			System.out.print("갱신할 책 분류 번호: ");
			int sNum = s.nextInt();
			s.nextLine();
			System.out.print("갱신할 책의 세부 주제: ");
			String sBook = s.nextLine();
			result.setBookSubject(new Subject(sNum, sBook));
			break;
			
		case 4:
			System.out.print("갱신할 책의 출판사: ");
			String publisher = s.nextLine();
			result.setPublisher(publisher);
			break;
			
		case 5:
			System.out.print("갱신할 책의 출판 연도: ");
			int publicateDate = s.nextInt();
			s.nextLine();
			result.setPublicateDate(publicateDate);
			break;
			
		case 6:
			System.out.print("갱신할 책의 언어: ");
			String lang = s.nextLine();
			Language newlang = Language.valueOf(lang);
			result.setLang(newlang);
			break;
			
		case 7:
			System.out.print("갱신할 책의 서버등록날짜: ");
			int registrationDate =  s.nextInt();
			s.nextLine();
			
			int year = registrationDate / 10000;
			int month = (registrationDate / 100) % 100;
			int day = registrationDate % 100;
			
			Date newDate = SetDateBasic.getDate(year, month, day);
			
			result.setRegistrationDate(newDate);
			break;
			
		case 8:
			System.out.print("갱신할 청구기호: ");
			String billSymbol = s.nextLine();
			result.setBillSymbol(billSymbol);
			break;
			
		default:
			System.out.println("잘못된 선택입니다.");
			break;
		}
		
		WriteFile();
	}
	
	protected void DelData() {
		System.out.println("책 삭제");
		System.out.print("삭제할 책 제목을 입력해주세요: ");
		String searchTitle = s.nextLine();
		
		BookBasicInfo DelBook = SearchObj(searchTitle);
		
		if(DelBook == null)
			return;
		
		System.out.println("");
		DelBook.printAllInfo();
		System.out.println("\n삭제하는 책이 맞습니까? ");
		System.out.print("[y/n] ");
		char choice = s.next().charAt(0);
		s.nextLine();
		
		if(choice == 'y' || choice == 'Y') {
			bInfos.remove(SearchObj(searchTitle));
		}
		WriteFile();
	}
	
	protected void Search() {
		System.out.print("책 제목을 입력해주세요: ");
		String searchTitle = s.nextLine();
		
		BookBasicInfo sbInfo = SearchObj(searchTitle);
		
		if(sbInfo != null) {
			System.out.println("검색 결과");
			sbInfo.printAllInfo();
		}
		else {
			System.out.println("검색 결과가 없습니다.");
		}
	}
	
	public BookBasicInfo SearchObj(String data) {		
		for(int i = 0; i < bInfos.size(); i++) {
			BookBasicInfo sbInfo = bInfos.get(i);
			if(sbInfo.getBookTitle().indexOf(data) != -1)
				return sbInfo;
		}
		return null;
	}
	
	public boolean SearchFullTitle(String data) {
		for(int i = 0; i < bInfos.size(); i++) {
			if(bInfos.get(i).getBookTitle().equals(data))
				return true;
		}
		return false;
	}
	
	protected void print() {
		if(bInfos == null) {
			System.out.println("등록된 책이 없습니다.");
			return;
		}
		
		for(int i = 0; i < bInfos.size(); i++) {
			BookBasicInfo pbInfo = bInfos.get(i);
			System.out.println(pbInfo);
		}
	}
	
	protected void printAll() {
		if(bInfos == null) {
			System.out.println("등록된 책이 없습니다.");
			return;
		}
		
		for(int i = 0; i < bInfos.size(); i++) {
			BookBasicInfo pbInfo = bInfos.get(i);
			pbInfo.printAllInfo();
		}
	}
	
}