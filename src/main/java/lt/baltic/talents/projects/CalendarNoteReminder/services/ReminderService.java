package lt.baltic.talents.projects.CalendarNoteReminder.services;

import java.util.List;

import lt.baltic.talents.projects.CalendarNoteReminder.models.Reminder;
import lt.baltic.talents.projects.CalendarNoteReminder.models.User;

public interface ReminderService {
	
	boolean set(Reminder reminder);
	
	void delete(Reminder reminder);
	
	List<Reminder> get(User user);
}
