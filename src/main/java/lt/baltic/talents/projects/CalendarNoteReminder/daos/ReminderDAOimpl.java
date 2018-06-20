package lt.baltic.talents.projects.CalendarNoteReminder.daos;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import lt.baltic.talents.projects.CalendarNoteReminder.models.Reminder;

public class ReminderDAOimpl implements ReminderDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean set(Reminder reminder) {
		
		Long id = (Long) sessionFactory.getCurrentSession().save(reminder);
		
		if (id != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public void delete(Reminder reminder) {
		
		sessionFactory.getCurrentSession().delete(reminder);
		
	}

	@Override
	public List<Reminder> get(User user) {
		
		TypedQuery<Reminder> query = sessionFactory.getCurrentSession().createQuery("from Reminder where id = ?1");
		
		query.setParameter(1, user.getId());
		
		List<Reminder> reminders = query.getResultList();
		
		return reminders;
		
	}

}
