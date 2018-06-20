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
@Table(name = "TBL_REMINDER")
public class Reminder implements Serializable {

	/**
	 * 
	 */
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
    @JoinColumn(name="login")
	User user;
	
	public Reminder(String note, LocalDateTime reminderDateTime) {
		super();
		this.note = note;
		this.reminderDateTime = reminderDateTime;
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
		return "Reminder [note=" + note + ", priminimoLaikas=" + reminderDateTime + "]";
	}
	
	
	
}
