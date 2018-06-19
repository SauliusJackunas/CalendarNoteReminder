package lt.baltic.talents.projects.CalendarNoteReminder.daos;

import lt.baltic.talents.projects.CalendarNoteReminder.models.User;

public interface UserDao {
	
	boolean login(User user);
	boolean create(User user);

}
