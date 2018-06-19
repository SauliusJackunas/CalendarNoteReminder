package lt.baltic.talents.projects.CalendarNoteReminder.models;

import java.time.LocalDateTime;

public class Reminder {


	String note;
	LocalDateTime priminimoLaikas;
	
	
	public Reminder(String note, LocalDateTime priminimoLaikas) {
		super();
		this.note = note;
		this.priminimoLaikas = priminimoLaikas;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public LocalDateTime getPriminimoLaikas() {
		return priminimoLaikas;
	}


	public void setPriminimoLaikas(LocalDateTime priminimoLaikas) {
		this.priminimoLaikas = priminimoLaikas;
	}


	@Override
	public String toString() {
		return "Reminder [note=" + note + ", priminimoLaikas=" + priminimoLaikas + "]";
	}
	
	
	
}
