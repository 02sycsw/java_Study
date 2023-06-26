import java.util.*;
import java.io.*;

class BookBorrowedList extends Borrowed {
	User user; //대여한 유저
	Date borrowedDate; //대여 시작 날짜
	Date expiredDate; //대여 만료 날짜
	
	public String toString() {
		return ("대여한 유저: " + user.getUserName() + 
				"\n대출일: " + SetDateBasic.formatDate(borrowedDate) + "  대여 만료일: " + SetDateBasic.formatDate(expiredDate));
	}
}

class eBook {
	private String bookTitle;
	private Subject bookSubject;
	private Language lang;
	private ArrayList<BookBorrowedList> ebList;
	private String overView;
	private String barcord;
	private ArrayList<String> tag;
	
	public eBook(BookBasicInfo book, String overView, String barcord) {
		this.bookTitle = book.getBookTitle();
		this.bookSubject = book.getBookSubject();
		this.lang = book.getLang();
		this.overView = overView;
		this.barcord = barcord;
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

	public Language getLang() {
		return lang;
	}

	public void setLang(Language lang) {
		this.lang = lang;
	}

	public String getOverView() {
		return overView;
	}

	public void setOverView(String overView) {
		this.overView = overView;
	}

	public String getBarcord() {
		return barcord;
	}

	public void setBarcord(String barcord) {
		this.barcord = barcord;
	}
	
	public ArrayList<String> getTag() {
		return tag;
	}
	
	public void setTag(ArrayList<String> tag) {
		this.tag = tag;
	}
	
	public void changeOrigin(BookBasicInfo book) {
		this.bookTitle = book.getBookTitle();
		this.bookSubject = book.getBookSubject();
		this.lang = book.getLang();
	}
	
	public void addBorrowedUser(BookBorrowedList borrowUser) {
		ebList.add(borrowUser);
	}
	
	public void printBorrowedUser() {
		for(int i = 0; i < ebList.size(); i++) {
			System.out.println(ebList.get(i));
		}
	}
	
	public void printTag() {
		for(String Tag: tag) {
			System.out.print("#" + Tag + " ");
		}
		System.out.println();
	}
	
	public void printAllInfo() {
		System.out.println("책 제목: " + bookTitle);
		System.out.println("책 주제: " + bookSubject);
		System.out.println("언어: " + lang);
		System.out.println("개요: " + overView);
		System.out.println("바코드: " + barcord);
		System.out.print("태그: ");
		printTag();
	}
	
	public String toString() {
		String bookstr = ("책 제목: " + bookTitle + "\n");
		bookstr += ("책 주제: " + bookSubject + "\n");
		bookstr += ("등록 언어: " + lang + " ");
		bookstr += ("개요: " + overView + " ");
		
		return bookstr;
	}
}

class EBookManage extends Manage{
	private ArrayList<eBook> eb = new ArrayList<>();
	private BookInfos bInfos = new BookInfos();
	private static Scanner s = new Scanner(System.in);
	
	public void setbInofs(BookInfos bInfos) {
		this.bInfos = bInfos;
	}
	
	public void selectMenu() throws Exception{
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
				System.out.println("파일 이름을 입력해주세요: ");
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
		System.out.println("\n[ eBook 정보 조회 및 관리 ]");
		System.out.println("1. eBook 데이터 등록 - 직접 입력");
		System.out.println("2. eBook 데이터 등록 - 파일 입력");
		System.out.println("3. eBook 데이터 수정");
		System.out.println("4. eBook 데이터 삭제");
		System.out.println("5. eBook 데이터 검색");
		System.out.println("6. eBook 데이터 출력");
		System.out.println("7. eBook 데이터 전체 정보 출력");
		System.out.println("8. 종료");
		System.out.print("\n메뉴 선택: ");
	}
	
	protected void WriteFile() {
		try (FileOutputStream fileOut = new FileOutputStream("c:\\tmp\\eBookTest.ser");
	            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
	            
	        	for(int i = 0; i < eb.size(); i++) {
	        		objectOut.writeObject(eb.get(i));
	        	}
	        } catch (IOException e) {
	            System.out.println("Serialization error: " + e.getMessage());
	        }
	}
	
	protected void ReadFile() {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:\\tmp\\eBookTest.ser"));){
			eb.clear();
			while(true) {
				try {
					eBook newEBook = (eBook)in.readObject();
					if(newEBook != null) {
						eb.add(newEBook);
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
	
	protected void AddData() {
		System.out.println("추가할 책의 제목을 입력해주세요: ");
		String bookTitle = s.nextLine();
		
		if(bInfos.SearchFullTitle(bookTitle)) {
			System.out.println(bookTitle + "은 서버에 존재하지 않는 책입니다.");
			System.out.println("도서 추가를 종료합니다.");
			return;
		}
		
		for(eBook eB:eb) {
			if(eB.getBookTitle().equals(bookTitle)){
				System.out.println(bookTitle + "은 중복된 도서입니다.");
				System.out.println("도서 추가를 취소합니다.");
				return;
			}
		}
		
		System.out.println("추가할 책의 개요를 입력해주세요: ");
		String overview = s.nextLine();
		System.out.println("추가할 책의 바코드를 입력해주세요: ");
		String barcord = s.nextLine();
		
		BookBasicInfo newBook = bInfos.SearchObj(bookTitle);
		eBook newEBook = new eBook(newBook, overview, barcord);
		
		eb.add(newEBook);
		WriteFile();
	}

	protected void AddData(eBook newEBook) {
		eb.add(newEBook);
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
					String bookTitle = s2.next();
					String overview = s2.next();
					String barcord = s2.next();
					
					if(bInfos.SearchFullTitle(bookTitle)) {
						System.out.println(bookTitle + "은 서버에 존재하지 않는 책입니다.");
						System.out.println("도서 추가를 종료합니다.");
						continue;
					}
					
					for(eBook eB:eb) {
						if(eB.getBookTitle().equals(bookTitle)){
							System.out.println(bookTitle + "은 중복된 도서입니다.");
							System.out.println("도서 추가를 취소합니다.");
							continue;
						}
					}
					
					BookBasicInfo newBook = bInfos.SearchObj(bookTitle);
					eBook newEBook = new eBook(newBook, overview, barcord);
					
					eb.add(newEBook);
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
		
		eBook result = SearchEObj(searchTitle);
		
		if(result == null) {
			System.out.println("존재하지 않는 책입니다.");
			return;
		}
		
		System.out.println("1. 개요 수정");
		System.out.println("2. 바코드 수정");
		System.out.println("3. 태그 수정");
		System.out.print("\n갱신할 정보를 선택해주세요: ");
		
		int sel;
		sel = s.nextInt();
		s.nextLine();
		
		switch(sel) {
		case 1:
			System.out.print("갱신할 개요");
			String overview = s.nextLine();
			result.setOverView(overview);
			break;
			
		case 2:
			System.out.print("갱신할 바코드: ");
			String barcord = s.nextLine();
			result.setBarcord(barcord);
			break;
			
		case 4:
			fixTag(result);
			break;
			
		default:
			System.out.println("잘못된 선택입니다.");
			break;
		}
		
		WriteFile();
	}
	
	protected void fixTag(eBook fix_book) {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 태그 추가");
			System.out.println("2. 태그 수정");
			System.out.println("3. 태그 삭제");
			System.out.println("4. 태그 초기화");
			System.out.println("5. 종료");
			System.out.println("\n 메뉴 선택: ");
			
			int sel = s.nextInt();
			s.nextLine();
			
			switch(sel) {
			case 1:
				AddTag(fix_book);
				break;
				
			case 2:
				fixTag(fix_book);
				break;
				
			case 3:
				DelTag(fix_book);
				break;
				
			case 4:
				fix_book.getTag().clear();
				break;
				
			case 5:
				flag = false;
				break;
				
			default:
				System.out.println("잘못된 선택입니다.");
				System.out.println("다시 선택해주세요.");
			}
		}
	}
	
	protected void AddTag(eBook fix_book) {
		if(fix_book.getTag().size() == 5) {
			System.out.println("태그를 더 추가할 수 없습니다.");
			return;
		}
		
		while(fix_book.getTag().size() > 5) {
			System.out.println("추가할 태그를 입력해주세요. ");
			String newTag = s.nextLine();
			
			for(String Tag:fix_book.getTag()) {
				if(Tag.equals(newTag)) {
					System.out.println(newTag + "는 중복된 태그입니다.");
					System.out.println("다른 태그를 입력해주세요.");
				}
			}
			
			fix_book.getTag().add(newTag);
		}
	}
	
	protected void setTag(eBook fix_book) {		
		System.out.println("수정하고 싶은 태그를 입력해주세요.");
		String fixTag = s.nextLine();
		int i;
		
		boolean check = false;
		for(i = 0; i < fix_book.getTag().size(); i++) {
			if(fix_book.getTag().get(i).equals(fixTag)) {
				check = true;
				break;
			}
		}
		
		if(!check) {
			System.out.println("해당하는 태그가 없습니다.");
			System.out.println("수정을 종료합니다.");
			return;
		}
		
		System.out.println("수정할 태그 내용을 입력해주세요.");
		String newTag = s.nextLine();
		
		fix_book.getTag().set(i, newTag);
	}
	
	protected void DelTag(eBook fix_book) {
		if(fix_book.getTag().size() == 0) {
			System.out.println("삭제할 태그가 없습니다.");
			return;
		}
		
		while(fix_book.getTag().size() > 0) {
			System.out.println("삭제할 태그를 입력해주세요. ");
			String delTag = s.nextLine();
			
			for(int i = 0; i < fix_book.getTag().size(); i++) {
				if(fix_book.getTag().get(i).equals(delTag)) {
					System.out.println(delTag + " 태그를 삭제합니다.");
					fix_book.getTag().remove(i);
					return;
				}
			}
			
			System.out.println("해당하는 태그를 찾을 수 없습니다.");
		}
	}
	
	protected void DelData() {
		System.out.println("책 삭제");
		System.out.print("삭제할 책 제목을 입력해주세요: ");
		String searchTitle = s.nextLine();
		
		eBook DelBook = SearchEObj(searchTitle);
		
		if(DelBook == null) {
			System.out.println("삭제할 책이 없습니다.");
			return;	
		}
		
		System.out.println("");
		DelBook.printAllInfo();
		System.out.println("\n삭제하는 책이 맞습니까? ");
		System.out.print("[y/n] ");
		char choice = s.next().charAt(0);
		s.nextLine();
		
		if(choice == 'y' || choice == 'Y') {
			eb.remove(SearchEObj(searchTitle));
		}
		WriteFile();
	}
	
	protected void DelDataView(String data) {
		eBook DelBook = SearchEObj(data);
		
		if(DelBook == null)
			return;
		
		eb.remove(DelBook);
		WriteFile();
	}
	
	protected void Search() {
		System.out.print("책 제목을 입력해주세요: ");
		String searchTitle = s.nextLine();
		
		eBook result = SearchEObj(searchTitle);
		
		if(result != null) {
			System.out.println("검색 결과");
			result.printAllInfo();
		}
		else {
			System.out.println("검색 결과가 없습니다.");
		}
	}
	
	public eBook returnBookforBorrow(String bookTitle) {
		eBook BookforBorrow = SearchEObj(bookTitle);
		return BookforBorrow;
	}
	
	public eBook SearchEObj(String data) {
		for(int i = 0; i < eb.size(); i++) {
			eBook book_temp = eb.get(i);
			if(book_temp.getBookTitle().indexOf(data) != -1)
				return book_temp;
		}
		return null;
	}
	
	public BookBasicInfo SearchObj(String data) {
		BookBasicInfo book_temp = bInfos.SearchObj(data);
		return book_temp;
	}

	protected void print() {
		if(eb == null) {
			System.out.println("등록된 책이 없습니다.");
			return;
		}
		
		for(int i = 0; i < eb.size(); i++) {
			eBook pEbook = eb.get(i);
			System.out.println(pEbook);
		}
	}

	protected void printAll() {
		if(eb == null) {
			System.out.println("등록된 책이 없습니다.");
			return;
		}
		
		for(int i = 0; i < eb.size(); i++) {
			eBook pEbook = eb.get(i);
			pEbook.printAllInfo();
		}
	}
}