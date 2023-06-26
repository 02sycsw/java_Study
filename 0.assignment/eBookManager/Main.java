import java.util.Scanner;

public class Main {
	private static Scanner s = new Scanner(System.in);
	private static AdminManage adminM = new AdminManage();
	private static UserManage userM = new UserManage();
	private static BookInfos bookM = new BookInfos();
	private static EBookManage eBookM = new EBookManage(); 
	
	public static void main(String[] args) {
		Admin first = new Admin("Admin01", "Admin1234567890", "pass1");
		adminM.AddData(first);
		login();
	}
	
	public static void login() {
		System.out.println("로그인 창");
		System.out.print("ID: ");
		String ID_temp = s.nextLine();
		System.out.print("비밀번호: ");
		String password_temp = s.nextLine();
		
		Admin result1 = adminM.SearchObj(2, ID_temp);
		User result2 = userM.SearchObj(2, ID_temp);
		
		if(result1 == null && result2 == null) {
			System.out.println("계정을 찾을 수 없습니다.");
			return;
		}
		
		if(result1 != null) {
			if(!result1.getAdminPassword().equals(password_temp)) {
				System.out.println("비밀번호가 일치하지 않습니다.");
				return;
			}
			
			try{
				System.out.println("\n1. 관리자용 메뉴");
				System.out.println("2. 유저 관리 메뉴");
				System.out.println("3. 도서 관리 메뉴");
				System.out.println("4. eBook 관리 메뉴");
				System.out.print("\n메뉴 선택: ");
				int sel = s.nextInt();
				
				switch(sel) {
				case 1:
					adminM.selectMenu();
					break;
				case 2:
					userM.selectMenu(adminM);
					break;
				case 3:
					bookM.selectMenu();
					break;
				case 4:
					eBookM.selectMenu();
					break;
				default:
					System.out.println("메뉴를 다시 선택해주세요.");
				}
			}catch(Exception e) {
				System.out.println("에러가 발생했습니다.");
				System.out.println("프로그램을 종료합니다.");
			}
		}
		else {
			if(!result2.getUserPassword().equals(password_temp)) {
				System.out.println("비밀번호가 일치하지 않습니다.");
				return;
			}
			
			try {
				userM.selectMenuforUser(result2, eBookM);
			}catch(Exception e) {
				System.out.println("에러가 발생했습니다.");
				System.out.println("프로그램을 종료합니다.");
			}
		}
	}
}
