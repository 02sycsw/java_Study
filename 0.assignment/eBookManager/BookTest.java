import java.util.*;
import java.text.SimpleDateFormat;
import java.io.File;

class SetDateBasic{
	public static Date getDate(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		
		return new Date(cal.getTimeInMillis());
	}
	
	public static Date addDate(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);

        return new Date(cal.getTimeInMillis());
    }
	
	public static String formatDate(Date date) {
		SimpleDateFormat fDate = new SimpleDateFormat("yyyy.MM.dd");
		String sfDay = fDate.format(date);
		
		return sfDay;
	}
}

class Subject {
	int subjectNum; //000~900
	String subjectBook; //주제
	
	public Subject(int subjectNum , String subjectBook){
		this.subjectNum = subjectNum;
		this.subjectBook = subjectBook;
	}
	
	public String toString() {
		if(subjectNum >= 100)
			return subjectNum + ", " + subjectBook;
		else {
			String subjectNumchange;
			if(subjectNum >= 10)
				subjectNumchange = "0" + subjectNum;
			else
				subjectNumchange = "00" + subjectNum;
			return subjectNumchange + ", " + subjectBook;
		}			
	}
}

abstract class Manage{
	abstract protected void PrintMenu();
	
	abstract protected void WriteFile();
	abstract protected void ReadFile();
	
	abstract protected void AddData();
	abstract protected void AddData(File file) throws Exception;
	abstract protected void SetData();
	abstract protected void DelData();
	abstract protected void Search();
	
	abstract protected void print();
	abstract protected void printAll();
}

abstract class Borrowed {
	Date borrowedDate; //대여 시작 날짜
	Date expiredDate; //대여 만료 날짜
}