import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class UserBorrowed extends Borrowed {
	private eBook ebBorrowed; //대여한 책
	private Date borrowedDate; //대여 시작 날짜
	private Date expiredDate; //대여 만료 날짜
	
	public UserBorrowed(eBook ebBorrowed, Date borrowedDate, Date expiredDate) {
		this.ebBorrowed = ebBorrowed;
		this.borrowedDate = borrowedDate;
		this.expiredDate = expiredDate;
	}
	
	public eBook getEbBorrowed() {
		return ebBorrowed;
	}


	public void setEbBorrowed(eBook ebBorrowed) {
		this.ebBorrowed = ebBorrowed;
	}
	
	public Date getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String toString() {
		return ("책 제목: " + ebBorrowed.getBookTitle() + "\n대출일: " +
				SetDateBasic.formatDate(borrowedDate) + "  대여만료일: " + SetDateBasic.formatDate(expiredDate));
	}
}

class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private static Scanner s = new Scanner(System.in);
	private String userName; //사용자, 계정 이름
	private String userID; //사용자 id
	private String userPassword; //사용자 비밀번호
	private int userAge; //사용자 나이
	private ArrayList<UserBorrowed> bList;	//사용자가 대여한 책 목록
	
	public User(String userName, String userID, String userPassword, int userAge) {
		this.userName = userName;
		this.userID = userID;
		this.userPassword = userPassword;
		this.userAge = userAge;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	
	public void UserBorrow(eBook ebBorrowed, int borrowedDate) {
		System.out.println("대출하려는 책의 제목이 \'" + ebBorrowed.getBookTitle() + "\'이 맞습니까?");
		System.out.print("틀리다면 n를, 맞다면 계정의 비밀번호를 입력해주세요: ");
		String password = s.nextLine();
		
		if(password.equals("n")) {
			System.out.println("대출을 종료합니다.");
			return;
		}
		
		if(!getUserPassword().equals(password)) {
			System.out.println("비밀번호가 맞지 않습니다.");
			System.out.println("대출을 종료합니다.");
			return;
		}
		
		int year, month, day;
		year = borrowedDate / 10000;
		month = (borrowedDate / 100) % 100;
		day = borrowedDate % 100;
		
		Date bDate = SetDateBasic.getDate(year, month, day);
		Date exDate = SetDateBasic.getDate(year, month, day + 14);
		
		UserBorrowed newbBook = new UserBorrowed(ebBorrowed, bDate, exDate);
		bList.add(newbBook);
		
		System.out.println("책 대출이 완료되었습니다.");
		System.out.println("반납일은 " + SetDateBasic.formatDate(exDate) + " 입니다.");
	}
	
	public void UserDelayExpire() {
		System.out.println("\n[ 대출한 책 목록 ]");
		printBook();
		UserBorrowed book_temp = SearchBorrowBook();
		
		System.out.println("\n" + book_temp.getEbBorrowed().getBookTitle()
				+"의 대여만료일은 " + book_temp.getExpiredDate() + " 입니다.");
		System.out.println("대여만료일을 연장하시겠습니까?");
		
		System.out.print("[y/n] ");
		char choice = s.next().charAt(0);
		s.nextLine();
		
		if(choice == 'y' || choice == 'Y') {
			Date date_temp = book_temp.getExpiredDate();
			Date newDate = SetDateBasic.addDate(date_temp, 14);
			book_temp.setExpiredDate(newDate);
			
			System.out.println("대출 기한이 연장되었습니다.");
			System.out.println("대여만료일은 " + SetDateBasic.formatDate(newDate) + "입니다.");
		}
	}
	
	private UserBorrowed SearchBorrowBook() {
		System.out.print("책 제목 입력: ");
		String title_temp = s.nextLine();
		
		for(int i = 0; i < bList.size(); i++) {
			UserBorrowed book_temp = bList.get(i);
			String bookTitle_temp = book_temp.getEbBorrowed().getBookTitle();
			if(bookTitle_temp.indexOf(title_temp) != -1) {
				return book_temp;
			}
		}
		return null;
	}
	
	protected void SetData() {		
		System.out.println("계정 정보를 갱신하려면 비밀번호를 입력해주세요.");
		String password_temp = s.nextLine();
		
		if(!getUserPassword().equals(password_temp)) {
			System.out.println("비밀번호가 틀렸습니다.");
			System.out.println("계정 수정이 종료됩니다.");
			return;
		}
		
		System.out.println("1. 이름");
		System.out.println("2. 계정 비밀번호");
		System.out.println("3. 유저 나이");
		System.out.println("\n갱신할 정보를 선택해주세요.");
		
		int sel = s.nextInt();
		s.nextLine();
		
		switch(sel) {
		case 1:
			System.out.print("갱신할 이름: ");
			String name = s.nextLine();
			userName = name;
			break;
				
		case 2:
			System.out.print("갱신할 비밀번호: ");
			String password = s.nextLine();
			userPassword = password;
			break;
			
		case 3:
			System.out.print("갱신할 나이: ");
			int age = s.nextInt();
			s.nextLine();
			userAge = age;
			break;
			
		default:
			System.out.println("잘못된 선택입니다.");
			break;
		}
	}
		
	protected void printBook() {
		for(int i = 0; i < bList.size(); i++) {
			UserBorrowed pBook = bList.get(i);
			System.out.println(pBook);
		}
	}

	protected void printAllInfo() {
		System.out.println("유저 계정 이름: " + userName);
		System.out.println("유저 계정 ID: " + userID);
		System.out.println("유저 계정 비밀번호: " + userPassword);
		System.out.println("유저 나이: " + userAge);
	}
	
	public String toString() {
		return ("유저 이름: " + userName + "  유저 ID: " + userID + "  유저 나이: " + userAge);
	}
}

class UserManage extends Manage{
	private ArrayList<User> user = new ArrayList<>();
	private static Scanner s = new Scanner(System.in);
	
	public void selectMenuforUser(User userLogin, EBookManage ebM) {
		boolean flag = true;
		
		while(flag) {
			printMenuforUser();
			int sel = s.nextInt();
			s.nextLine();
			
			switch(sel) {
			case 1:
				userLogin.printAllInfo();
				break;
				
			case 2:
				userLogin.SetData();
				break;
				
			case 3:
				DelData(userLogin);
				break;
				
			case 4:
				System.out.println("");
				String title_temp = s.nextLine();
				eBook ebook = ebM.returnBookforBorrow(title_temp);
				userLogin.UserBorrow(ebook, sel);
				break;
				
			case 5:
				userLogin.UserDelayExpire();
				break;
				
			case 6:
				flag = false;
				break;
				
			default:
				System.out.println("잘못된 선택입니다.");
				System.out.println("다시 선택해주세요.");
			}
		}
	}
	
	protected void printMenuforUser() {
		System.out.println("\n[ 유저 메뉴 ]");
		System.out.println("1. 개인정보 조회");
		System.out.println("2. 개인정보 수정");
		System.out.println("3. 계정 탈퇴");
		System.out.println("4. e-book 대출");
		System.out.println("5. 대출 연장");
		System.out.println("6. 종료");
		System.out.print("\n메뉴 선택: ");
	}
	
	public void selectMenu(AdminManage ad) throws Exception {
		boolean flag = true;
		
		while(flag) {
			PrintMenu();
			int sel = s.nextInt();
			s.nextLine();
			
			if(!checkAdmin(ad))
				return;
			
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
		System.out.println("\n[ 유저 정보 조회 및 관리 ]");
		System.out.println("1. 유저 데이터 등록 - 직접 입력");
		System.out.println("2. 유저 데이터 등록 - 파일 입력");
		System.out.println("3. 유저 데이터 수정");
		System.out.println("4. 유저 데이터 삭제");
		System.out.println("5. 유저 데이터 검색");
		System.out.println("6. 유저 데이터 출력");
		System.out.println("7. 유저 데이터 전체 정보 출력");
		System.out.println("8. 종료");
		System.out.print("\n메뉴 선택: ");
	}
	
	protected void WriteFile() {
		try (FileOutputStream fileOut = new FileOutputStream("c:\\tmp\\UserTest.ser");
	            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
	            
	        	for(int i = 0; i < user.size(); i++) {
	        		objectOut.writeObject(user.get(i));
	        	}
	        } catch (IOException e) {
	            System.out.println("Serialization error: " + e.getMessage());
	        }
	}
	
	protected void ReadFile() {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:\\tmp\\adminTest.ser"));){
			user.clear();
			while(true) {
				try {
					User account = (User)in.readObject();
					if(account != null) {
						user.add(account);
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
		System.out.print("추가할 유저 계정 이름을 입력해주세요: ");
		String name = s.nextLine();
		System.out.print("추가할 유저 계정 ID를 입력해주세요: ");
		String id = s.nextLine();
		System.out.print("추가할 유저 계정의 비밀번호를 입력해주세요: ");
		String password = s.nextLine();
		System.out.print("추가할 유저 나이를 입력해주세요: ");
		int age = s.nextInt();
		s.nextLine();
		
		user.add(new User(name, id, password, age));
		WriteFile();
	}
	
	protected void AddData(User newUser) {
		user.add(newUser);
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
					String temp_name = s2.next();
					String temp_id = s2.next();
					String temp_password = s2.next();
					String temp_age = s2.nextLine();
					int age = Integer.parseInt(temp_age);
					User inputUser = new User(temp_name, temp_id, temp_password, age);
					user.add(inputUser);
				}
				s2.close();
			}
			s1.close();
			
			WriteFile();
		}
		else if(extension.equals("bin") || extension.equals("ser")) {
			ReadFile();
			//WriteFile();
		}
	}
	
	protected void SetData() {
		System.out.println("유저 갱신");
		System.out.println("1. 이름으로 검색");
		System.out.println("2. ID로 검색");
		System.out.print("선택: ");
		
		int sel = s.nextInt();
		s.nextLine();
		
		if (sel != 1 && sel != 2) {
			System.out.println("잘못된 선택입니다.");
			return;
		}
		
		System.out.print("검색어를 입력하세요: ");
		String data = s.nextLine();
		
		User result = SearchObj(sel, data);
		
		if(result == null) {
			System.out.println("존재하지 않는 계정입니다.");
			return;
		}
		
		System.out.println(result.getUserID() + "의 정보를 갱신하려면 비밀번호를 입력해주세요.");
		String password_temp = s.nextLine();
		
		if(!result.getUserPassword().equals(password_temp)) {
			System.out.println("비밀번호가 틀렸습니다.");
			System.out.println("계정 수정이 종료됩니다.");
			return;
		}
		
		System.out.println("1. 유저 이름");
		System.out.println("2. 유저 계정 ID");
		System.out.println("3. 유저 계정 비밀번호");
		System.out.println("4. 유저 나이");
		System.out.println("\n갱신할 정보를 선택해주세요.");
		
		sel = s.nextInt();
		s.nextLine();
		
		switch(sel) {
		case 1:
			System.out.print("갱신할 유저 이름: ");
			String name = s.nextLine();
			result.setUserName(name);
			break;
			
		case 2:
			System.out.print("갱신할 유저 ID: ");
			String ID = s.nextLine();
			result.setUserID(ID);
			break;
			
		case 3:
			System.out.print("갱신할 유저 비밀번호: ");
			String password = s.nextLine();
			result.setUserPassword(password);
			break;
			
		case 4:
			System.out.print("갱신할 유저 나이: ");
			int age = s.nextInt();
			s.nextLine();
			result.setUserAge(age);
			break;
			
		default:
			System.out.println("잘못된 선택입니다.");
			break;
		}
		
		WriteFile();
	}
	
	protected void DelData() {
		System.out.println("유저 삭제");
		System.out.println("1. 이름으로 삭제");
		System.out.println("2. ID로 삭제");
		System.out.print("선택: ");
		
		int sel = s.nextInt();
		s.nextLine();
		
		if (sel != 1 && sel != 2) {
			System.out.println("잘못된 선택입니다.");
			return;
		}
		
		System.out.print("데이터를 입력하세요: ");
		String data = s.nextLine();
		
		User result = SearchObj(sel, data);
		
		System.out.println(result.getUserID() + "의 계정 정보를 삭제하고 싶으시면 비밀번호를 입력해주세요.");
		String password_temp = s.nextLine();
		
		if(!result.getUserPassword().equals(password_temp)) {
			System.out.println("비밀번호가 틀렸습니다.");
			System.out.println("계정 삭제가 종료됩니다.");
			return;
		}
		
		user.remove(result);
		WriteFile();
	}
	
	protected void DelData(User delUser) {
		User result = SearchObj(2, delUser.getUserID());
		
		System.out.println("계정을 탈퇴하시려면 비밀번호를 입력해주세요.");
		String password_temp = s.nextLine();
		
		if(!result.getUserPassword().equals(password_temp)) {
			System.out.println("비밀번호가 틀렸습니다.");
			System.out.println("계정 탈퇴가 종료됩니다.");
			return;
		}
		
		user.remove(result);
	}
	
	protected void Search() {
		System.out.println("유저 검색");
		System.out.println("1. 이름으로 검색");
		System.out.println("2. ID로 검색");
		System.out.print("선택: ");
		
		int sel = s.nextInt();
		s.nextLine();
		
		if (sel != 1 && sel != 2) {
			System.out.println("잘못된 선택입니다.");
			return;
		}
		
		System.out.print("검색어를 입력하세요: ");
		String data = s.nextLine();
		
		User result = SearchObj(sel, data);
		
		if(result != null)
			System.out.println("[검색 결과]\n" + result);
		else
			System.out.println("존재하지 않는 계정입니다.");
	}
	
	public User SearchObj(int sel, String data) {
		if (sel != 1 && sel != 2) {
			System.out.println("잘못된 선택입니다.");
			return null;
		}
		
		if(sel == 1) {
			for(User users: user) {
				if(users.getUserName().equals(data)) {
					return users;
				}
			}
			return null;
		}
		else {
			for(User users: user) {
				if(users.getUserID().equals(data)) {
					return users;
				}
			}
			return null;
		}
	}
	
	protected void print() {
		if(user == null) {
			System.out.println("등록된 유저가 없습니다.");
			return;
		}
		
		for(int i = 0; i < user.size(); i++) {
			User pUser = user.get(i);
			System.out.println(pUser);
		}
	}
	
	protected void printAll() {		
		if(user == null) {
			System.out.println("등록된 유저가 없습니다.");
			return;
		}
		
		for(int i = 0; i < user.size(); i++) {
			User pUser = user.get(i);
			pUser.printAllInfo();
		}
	}
	
	private boolean checkAdmin(AdminManage ad) {
		if(ad == null) {
			System.out.println("관리할 수 있는 관리자가 없습니다.");
			return false;
		}
		
		System.out.println("유저의 정보를 관리하려면 관리자 권한 재확인이 필요합니다.");
		System.out.println("관리자 계정 ID를 입력해주세요: ");
	
		String ID_temp = s.nextLine();
		Admin admin_temp = ad.SearchObj(2, ID_temp);
		System.out.println(admin_temp.getAdminID() + "의 비밀번호를 입력해주세요.");
		String password_temp = s.nextLine();
		
		if(!admin_temp.getAdminPassword().equals(password_temp)) {
			System.out.println("비밀번호가 틀렸습니다.");
			System.out.println("유저 계정 관리가 종료됩니다.");
			return false;
		}
		
		return true;
	}

}
