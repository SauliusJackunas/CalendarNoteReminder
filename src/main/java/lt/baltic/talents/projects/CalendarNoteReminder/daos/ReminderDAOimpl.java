package lt.baltic.talents.projects.CalendarNoteReminder.daos;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import lt.baltic.talents.projects.CalendarNoteReminder.models.Reminder;

public class ReminderDAOimpl implements ReminderDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean set(Reminder reminder) {
		
		Long id = (Long) sessionFactory.getCurrentSession().save(reminder);
		
		if (id != null) {
			return true;
		}
		return false;
	}
	
	@Transactional
	@Override
	public void delete(Reminder reminder) {
		
		sessionFactory.getCurrentSession().delete(reminder);
		
	}

}
