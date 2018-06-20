package lt.baltic.talents.projects.CalendarNoteReminder.daos;

import lt.baltic.talents.projects.CalendarNoteReminder.models.User;

public interface UserDao {
	
	User login(User user);
	boolean create(User user);

}
