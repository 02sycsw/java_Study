import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

import java.util.ArrayList;

class Admin implements Serializable{
	private static final long serialVersionUID = 1L;
	private String adminName; //관리자 계정 이름
	private String adminID; //관리자 id
	private String adminPassword; //관리자 패스워드

	public Admin(String adminName, String adminID, String adminPassword) {
		this.adminName = adminName;
		this.adminID = adminID;
		this.adminPassword = adminPassword;
	}
	
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	
	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	protected void printAllInfo() {
		System.out.println("관리자 계정 ID: " + adminID);
		System.out.println("관리자 계정 이름: " + adminName);
		System.out.println("관리자 계정 비밀번호: " + adminPassword);
	}
	
	public String toString() {
		return ("관리자 이름: " + adminName + "  관리자 ID: " + adminID);
	}
}

class AdminManage extends Manage{
	private ArrayList<Admin> ad = new ArrayList<>();
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
		System.out.println("\n[ 관리자 정보 조회 및 관리 ]");
		System.out.println("1. 관리자 데이터 등록 - 직접 입력");
		System.out.println("2. 관리자 데이터 등록 - 파일 입력");
		System.out.println("3. 관리자 데이터 수정");
		System.out.println("4. 관리자 데이터 삭제");
		System.out.println("5. 관리자 데이터 검색");
		System.out.println("6. 관리자 데이터 출력");
		System.out.println("7. 관리자 데이터 전체 정보 출력");
		System.out.println("8. 종료");
		System.out.print("\n메뉴 선택: ");
	}
	
	protected void WriteFile() {
		try (FileOutputStream fileOut = new FileOutputStream("c:\\tmp\\adminTest.ser");
	            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
	            
	        	for(int i = 0; i < ad.size(); i++) {
	        		objectOut.writeObject(ad.get(i));
	        	}
	        } catch (IOException e) {
	            System.out.println("Serialization error: " + e.getMessage());
	        }
	}
	
	protected void ReadFile() {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:\\tmp\\adminTest.ser"));){
			ad.clear();
			while(true) {
				try {
					Admin account = (Admin)in.readObject();
					if(account != null) {
						ad.add(account);
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
		System.out.print("추가할 관리자 이름을 입력해주세요: ");
		String name = s.nextLine();
		System.out.print("추가할 관리자 ID를 입력해주세요: ");
		String id = s.nextLine();
		System.out.print("추가할 관리자 비밀번호를 입력해주세요: ");
		String password = s.nextLine();
		
		boolean check = false;
		for(Admin admin:ad) {
			if(admin.getAdminID().equals(id)) {
				check = true;
				break;
			}
		}
		
		if(check) {
			System.out.println(id + "는 중복된 ID입니다.");
			System.out.println("해당 관리자 계정 추가를 취소합니다.");
			return;
		}
		
		ad.add(new Admin(name, id, password));
		WriteFile();
	}
	
	protected void AddData(Admin newAd) {
		ad.add(newAd);
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
					String temp_id = s2.next();
					String temp_name = s2.next();
					String temp_password = s2.next();
					
					boolean check = false;
					for(Admin admin:ad) {
						if(admin.getAdminID().equals(temp_id)) {
							check = true;
							break;
						}
					}
					
					if(check) {
						System.out.println(temp_id + "는 중복된 ID입니다.");
						System.out.println("해당 관리자 계정 추가를 취소합니다.");
						continue;
					}
					
					Admin inputAd = new Admin(temp_name, temp_id, temp_password);
					ad.add(inputAd);
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
		System.out.println("관리자 갱신");
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
		
		Admin result = SearchObj(sel, data);
		
		if(result == null) {
			System.out.println("존재하지 않는 계정입니다.");
			return;
		}
		
		System.out.println(result.getAdminID() + "의 계정 정보를 갱신하고 싶으시면 비밀번호를 입력해주세요.");
		String password_temp = s.nextLine();
		
		if(!result.getAdminPassword().equals(password_temp)) {
			System.out.println("비밀번호가 틀렸습니다.");
			System.out.println("계정 수정이 종료됩니다.");
			return;
		}
		
		System.out.println("1. 관리자 이름");
		System.out.println("2. 관리자 계정 ID");
		System.out.println("3. 관리자 계정 비밀번호");
		System.out.println("\n갱신할 정보를 선택해주세요.");
		
		sel = s.nextInt();
		s.nextLine();
		
		switch(sel) {
		case 1:
			System.out.print("갱신할 관리자 이름: ");
			String name = s.nextLine();
			result.setAdminName(name);
			break;
			
		case 2:
			System.out.print("갱신할 관리자 ID: ");
			String ID = s.nextLine();
			result.setAdminID(ID);
			break;
			
		case 3:
			System.out.print("갱신할 관리자 비밀번호: ");
			String password = s.nextLine();
			result.setAdminPassword(password);
			break;
			
		default:
			System.out.println("잘못된 선택입니다.");
			break;
		}
		
		WriteFile();
	}
	
	protected void DelData() {
		System.out.println("관리자 삭제");
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
		
		Admin result = SearchObj(sel, data);
		
		System.out.println(result.getAdminID() + "의 계정 정보를 삭제하고 싶으시면 비밀번호를 입력해주세요.");
		String password_temp = s.nextLine();
		
		if(!result.getAdminPassword().equals(password_temp)) {
			System.out.println("비밀번호가 틀렸습니다.");
			System.out.println("계정 삭제가 종료됩니다.");
			return;
		}
		
		ad.remove(result);
		WriteFile();
	}
	
	protected void Search() {
		System.out.println("관리자 검색");
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
		
		Admin result = SearchObj(sel, data);
		
		if(result != null)
			System.out.println("[ 검색 결과 ]\n" + result);
		else
			System.out.println("존재하지 않는 계정입니다.");
		
	}
	
	public Admin SearchObj(int sel, String data) {
		if (sel != 1 && sel != 2) {
			System.out.println("잘못된 선택입니다.");
			return null;
		}
		
		if(sel == 1) {
			for(Admin ads: ad) {
				if(ads.getAdminName().equals(data)) {
					return ads;
				}
			}
			return null;
		}
		else {
			for(Admin ads: ad) {
				if(ads.getAdminID().equals(data)) {
					return ads;
				}
			}
			return null;
		}
	}

	protected void print() {
		if(ad == null) {
			System.out.println("등록된 관리자가 없습니다.");
			return;
		}
		
		for(int i = 0; i < ad.size(); i++) {
			Admin pAdmin = ad.get(i);
			System.out.println(pAdmin);
		}
	}

	protected void printAll() {
		if(ad == null) {
			System.out.println("등록된 관리자가 없습니다.");
			return;
		}
		
		System.out.println("관리자의 정보를 열람하려면 권한이 필요합니다.");
		System.out.print("관리자 계정 ID를 입력해주세요: ");
		
		String ID_temp = s.nextLine();
		Admin admin_temp = SearchObj(2, ID_temp);
		
		System.out.println(admin_temp.getAdminID() + "의 비밀번호를 입력해주세요.");
		String password_temp = s.nextLine();
		
		if(!admin_temp.getAdminPassword().equals(password_temp)) {
			System.out.println("비밀번호가 틀렸습니다.");
			System.out.println("계정 정보 열람이 종료됩니다.");
			return;
		}
		
		for(int i = 0; i < ad.size(); i++) {
			Admin pAdmin = ad.get(i);
			pAdmin.printAllInfo();
		}
	}
}
