package lt.baltic.talents.projects.CalendarNoteReminder.models;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_USERS")
public class User implements Serializable {
	
	
	@Column(name = "USER_REMINDER")
	private List<Reminder> reminder;
	
	@Column(name = "USER_NOTE")
	private String note;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long id;

	@Column(name = "USER_LOGIN", unique = true)
	private String login;
	
	@Column(name = "USER_PWD")
	private char[] pwd;
	
	public User() {}

	public User(String login, char[] pwd ) {
		this.login = login;
		this.pwd = pwd.clone();
		
	}
	
	public User (String login, String note, List<Reminder> reminder) {
		this.login = login;
		this.note = note;
		this.reminder = reminder;
	}
	



	public List<Reminder> getReminder() {
		return reminder;
	}

	public void setReminder(List<Reminder> reminder) {
		this.reminder = reminder;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public char[] getPwd() {
		return pwd;
	}

	public void setPwd(char[] pwd) {
		this.pwd = pwd;
	}

	
	@Override
	public String toString() {
		return "User [reminder=" + reminder + ", note=" + note + ", id=" + id + ", login=" + login + ", pwd="
				+ Arrays.toString(pwd) + "]";
	}

}
