package lt.baltic.talents.projects.CalendarNoteReminder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import lt.baltic.talents.projects.CalendarNoteReminder.daos.ReminderDAO;
import lt.baltic.talents.projects.CalendarNoteReminder.models.Reminder;

public class ReminderServiceImpl implements ReminderService {

	@Autowired
	private ReminderDAO reminderDAO;
	
	public void setReminderDAO(ReminderDAO reminderDAO) {
		this.reminderDAO = reminderDAO;
	}
	
	@Transactional
	@Override
	public boolean set(Reminder reminder) {
		return reminderDAO.set(reminder);
	}
	
	@Transactional
	@Override
	public void delete(Reminder reminder) {
		reminderDAO.delete(reminder);
	}

}
