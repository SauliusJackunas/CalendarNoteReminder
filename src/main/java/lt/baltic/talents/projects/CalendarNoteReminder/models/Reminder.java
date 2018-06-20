package lt.baltic.talents.projects.CalendarNoteReminder.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_REMINDERS")
public class Reminder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REMINDER_ID")
	private Long id;

	@Column(name="REMINDER_NOTE")
	String note;
	
	@Column(name="REMINDER_DATE")
	LocalDateTime reminderDateTime;
	
	@ManyToOne
    @JoinColumn(name="USER_ID")
	User user;
	
	public Reminder() {}
	
	public Reminder(String note, LocalDateTime reminderDateTime, User user) {
		this.note = note;
		this.reminderDateTime = reminderDateTime;
		this.user = user;
	}
	
	public Long getId() {
		return id;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public LocalDateTime getReminderDateTime() {
		return reminderDateTime;
	}

	public void setReminderDateTime(LocalDateTime reminderDateTime) {
		this.reminderDateTime = reminderDateTime;
	}

	@Override
	public String toString() {
		return "Reminder [note=" + note + ", priminimoLaikas=" + reminderDateTime + "Username:" + user.getLogin() + "]";
	}
	
	
	
}
