package lt.baltic.talents.projects.CalendarNoteReminder.models;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TBL_USERS")
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long id;

	@Column(name = "USER_LOGIN", unique = true)
	private String login;
	
	@Column(name = "USER_PWD")
	private char[] pwd;
	
<<<<<<< HEAD
	@Column(name = "USER_ADMIN")
	private boolean admin;
	
=======
	@Column(name = "USER_REMINDER")
>>>>>>> parent of 0c32f10... Merge branch 'master' of https://github.com/SauliusJackunas/CalendarNoteReminder
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private List<Reminder> reminder;
	
	public User() {}

	public User(String login, char[] pwd ) {
		this.login = login;
		this.pwd = pwd.clone();
		
	}
	
<<<<<<< HEAD
	public User(String login, char[] pwd, boolean admin ) {
		this.login = login;
		this.pwd = pwd.clone();
		this.reminder = new ArrayList<Reminder>();
		this.admin = admin;
		
	}
	
	public User (String login) {
=======
	public User (String login, List<Reminder> reminder) {
>>>>>>> parent of 0c32f10... Merge branch 'master' of https://github.com/SauliusJackunas/CalendarNoteReminder
		this.login = login;
		this.reminder = reminder;
	}

	public List<Reminder> getReminder() {
		return reminder;
	}

	public void setReminder(List<Reminder> reminder) {
		this.reminder = reminder;
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

	
	
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "User [reminder=" + reminder + ", id=" + id + ", login=" + login + ", pwd="
				+ Arrays.toString(pwd) + "]";
	}

}
