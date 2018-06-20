package lt.baltic.talents.projects.CalendarNoteReminder.daos;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import lt.baltic.talents.projects.CalendarNoteReminder.models.Reminder;
import lt.baltic.talents.projects.CalendarNoteReminder.models.User;

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

	@Transactional
	@Override
	public List<Reminder> get(User user) {
		
		TypedQuery<Reminder> query = sessionFactory.getCurrentSession().createQuery("from Reminder where login = ?1");
		
		query.setParameter(1, user.getLogin());
		
		List<Reminder> reminders = query.getResultList();
		
		reminders.stream().forEach(x -> System.out.println(x.toString()));
		
		return reminders;
		
	}

}
