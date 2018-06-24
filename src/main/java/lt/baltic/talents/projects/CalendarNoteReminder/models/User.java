package lt.baltic.talents.projects.CalendarNoteReminder.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TBL_USERS")
public class User implements Serializable, Cloneable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long id;

	@Column(name = "USER_LOGIN", unique = true)
	private String login;
	
	@Column(name = "USER_PWD")
	private char[] pwd;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="user", cascade = CascadeType.ALL)
	private List<Reminder> reminders;
	
	public User() {}

	public User(String login, char[] pwd ) {
		this.login = login;
		this.pwd = pwd.clone();
		this.reminders = new ArrayList<>();
	}
	
	public User (String login) {
		this.login = login;
	}

	public List<Reminder> getReminders() {
		return reminders;
	}
	
	public Reminder getReminder(int id) {
		return reminders.get(id);
		
	}

	public void setReminders(List<Reminder> reminders) {
		this.reminders = reminders;
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

	public Object clone()throws CloneNotSupportedException{
	return super.clone();
	}
	
	@Override
	public String toString() {
		return "User [reminder=" + reminders + ", id=" + id + ", login=" + login + ", pwd="
				+ Arrays.toString(pwd) + "]";
	}

}
