package lt.baltic.talents.projects.CalendarNoteReminder.services;

import lt.baltic.talents.projects.CalendarNoteReminder.models.User;

public interface UserService {

	boolean login(User user);
	
	boolean create(User user);

}
