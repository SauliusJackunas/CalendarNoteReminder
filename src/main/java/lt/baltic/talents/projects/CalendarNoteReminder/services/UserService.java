package lt.baltic.talents.projects.CalendarNoteReminder.services;

import lt.baltic.talents.projects.CalendarNoteReminder.models.User;

public interface UserService {

	User login(User user);
	
	boolean create(User user);
	
	boolean signup(User user);
	
}
