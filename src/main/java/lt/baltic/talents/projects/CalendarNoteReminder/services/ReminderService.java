package lt.baltic.talents.projects.CalendarNoteReminder.services;

import lt.baltic.talents.projects.CalendarNoteReminder.models.Reminder;

public interface ReminderService {
	
	boolean set(Reminder reminder);
	void delete(Reminder reminder);

}
