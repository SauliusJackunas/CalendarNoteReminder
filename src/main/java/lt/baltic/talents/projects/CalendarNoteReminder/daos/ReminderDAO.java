package lt.baltic.talents.projects.CalendarNoteReminder.daos;

import lt.baltic.talents.projects.CalendarNoteReminder.models.Reminder;

public interface ReminderDAO {
	
	boolean set(Reminder reminder);
	void delete(Reminder reminder);
}
