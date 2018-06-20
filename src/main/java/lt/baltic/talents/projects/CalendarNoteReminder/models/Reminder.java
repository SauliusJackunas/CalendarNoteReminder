package lt.baltic.talents.projects.CalendarNoteReminder.models;

import java.io.Serializable;
import java.util.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TBL_REMINDERS")
public class Reminder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REMINDER_ID")
	private Long id;

	@Column(name="REMINDER_NOTE")
	private String note;
	
	@Column(name="REMINDER_DATE")
	private LocalDateTime reminderDateTime;
	
	@ManyToOne
    @JoinColumn(name="USER_ID", nullable=false)
	private User user;
	
	public Reminder(String note, LocalDateTime reminderDateTime) {
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

	
	public LocalDateTime getReminderLocalDateTime() {
		return null;
	}


	public void setReminderLocalDateTime(LocalDateTime reminderDateTime) {
		//Date.from(date.atZone(ZoneId.systemDefault()).toInstant())
	}

	@Override
	public String toString() {
		return "Reminder [note=" + note + ", priminimoLaikas=" + reminderDateTime + "]";
	}
	
	
	
}
