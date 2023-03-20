public class Book {
	String name;
	String author;
	boolean borrowing;
	
	public void bo_book() {
		borrowing = true;
	}
	
	public void re_book() {
		borrowing = false;
	}
	
	public void Display_info() {
		System.out.printf("책 이름: %s, 저자: %s,", name, author);
		
		if(borrowing)
			System.out.println("대출여부: 대출중");
		else
			System.out.println("대출여부: 대출가능");
	}
	
	public static void main(String[] args) {
		Book book = new Book();
		
		book.name = "자바 프로그래밍 개론";
		book.author = "김땡땡";
		book.borrowing = false;
		
		book.Display_info();
		book.bo_book();
		book.Display_info();
	}

}
