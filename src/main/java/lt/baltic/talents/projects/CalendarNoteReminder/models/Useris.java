package lt.baltic.talents.projects.CalendarNoteReminder.models;

public class Useris {

	String name;
	String pass;
	Reminderis reminder;
	int user_ID;
	
	
	public Useris(String name, String pass, Reminderis reminder, int user_ID) {
		super();
		this.name = name;
		this.pass = pass;
		this.reminder = reminder;
		this.user_ID = user_ID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public Reminderis getReminder() {
		return reminder;
	}


	public void setReminder(Reminderis reminder) {
		this.reminder = reminder;
	}


	public int getUser_ID() {
		return user_ID;
	}


	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}


	@Override
	public String toString() {
		return "Useris [name=" + name + ", pass=" + pass + ", reminder=" + reminder + ", userID=" + user_ID + "]";
	}
	
	
	
}
