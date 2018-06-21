package lt.baltic.talents.projects.CalendarNoteReminder.daos;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import lt.baltic.talents.projects.CalendarNoteReminder.models.Reminder;
import lt.baltic.talents.projects.CalendarNoteReminder.models.User;

@Repository
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
		
		TypedQuery<Reminder> query;
		
		System.out.println(user.toString());
		
		if (user.getLogin().trim().equalsIgnoreCase("admin")) {
			System.out.println(user.toString());
			 query = sessionFactory.getCurrentSession().createQuery("from Reminder");
			
		} else {
			
			query = sessionFactory.getCurrentSession().createQuery("from Reminder where user = ?1");
			query.setParameter(1, user);
		}
		
		List<Reminder> reminders = query.getResultList();
		
		return reminders;
		
	}

}
