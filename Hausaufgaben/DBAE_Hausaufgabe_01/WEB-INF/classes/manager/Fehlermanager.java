package manager;

public class Fehlermanager {
	public Boolean weiterleitung = false;
	
	public Fehlermanager(String mail, String pw, String type) {
		String myMail = mail;
		String myPw = pw;
		String myType = type;
		
		
		if (myType.contains("admin")){
				weiterleitung = checkAdmin(myMail, myPw);
		} else if(myType.contains("user")) {
				weiterleitung = checkUser(myMail);
		} else {
			System.out.println(myType);
			System.out.println(myMail);
			System.out.println(myPw);
			System.out.println("User cannot be checked. ERROR!");
		}
	}
	
	Boolean checkAdmin(String myMail, String myPw) {
		int myMailCount = myMail.length();
		int myPwCount = myPw.length();
				
		if(myMailCount % myPwCount == 0) 
		{
			System.out.println("Admin Login successful!");
			return true;
		}else {
			System.out.println("Admin Login not successful!");
			return false;
		}
	}
	Boolean checkUser(String myMail) {
		int myMailCount = myMail.length();
		
		if (myMailCount % 3 == 0) {
			System.out.println("User Login successful!");
			return true;
		} else {
			System.out.println("User Login not successful!");
			return false;
		}
		
	}
	
	
	
}
