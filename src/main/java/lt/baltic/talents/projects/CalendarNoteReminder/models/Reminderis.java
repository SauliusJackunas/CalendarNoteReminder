package lt.baltic.talents.projects.CalendarNoteReminder.models;

import java.time.LocalDateTime;

public class Reminderis {
	
	LocalDateTime eventoPradzia;
	LocalDateTime eventoPabaiga;
	String note;
	LocalDateTime priminimoLaikas;
	
	public Reminderis(LocalDateTime eventoPradzia, LocalDateTime eventoPabaiga, String note,
			LocalDateTime priminimoLaikas) {
		super();
		this.eventoPradzia = eventoPradzia;
		this.eventoPabaiga = eventoPabaiga;
		this.note = note;
		this.priminimoLaikas = priminimoLaikas;
	}

	public LocalDateTime getEventoPradzia() {
		return eventoPradzia;
	}

	public void setEventoPradzia(LocalDateTime eventoPradzia) {
		this.eventoPradzia = eventoPradzia;
	}

	public LocalDateTime getEventoPabaiga() {
		return eventoPabaiga;
	}

	public void setEventoPabaiga(LocalDateTime eventoPabaiga) {
		this.eventoPabaiga = eventoPabaiga;
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
		return "Reminderis [eventoPradzia=" + eventoPradzia + ", eventoPabaiga=" + eventoPabaiga + ", note=" + note
				+ ", priminimoLaikas=" + priminimoLaikas + "]";
	}
	
	

}
