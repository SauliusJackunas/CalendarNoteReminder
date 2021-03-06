package lt.baltic.talents.projects.CalendarNoteReminder.daos;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lt.baltic.talents.projects.CalendarNoteReminder.models.Reminder;
import lt.baltic.talents.projects.CalendarNoteReminder.models.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean create(User user) {

		Long id = (Long) sessionFactory.getCurrentSession().save(user);
		
		if (id != null) {
			return true;
		}
		return false;
	}

	@Override
	public User login(User user) {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where login = ?1 and pwd = ?2");
		
		query.setParameter(1, user.getLogin());
		query.setParameter(2, user.getPwd());
		
		List<User> users = query.getResultList();
		
		if (users != null && users.size() == 1) {
			User temp = users.get(0); 
			if (temp.getLogin().trim().equalsIgnoreCase("admin")) {
				TypedQuery<Reminder> queryReminder = sessionFactory.getCurrentSession().createQuery("from Reminder");
				List<Reminder> reminders = queryReminder.getResultList();
				temp.setReminders(reminders);
			}
			return temp;
		}
		
		return null;
	}

}
