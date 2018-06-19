package lt.baltic.talents.projects.CalendarNoteReminder.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.baltic.talents.projects.CalendarNoteReminder.daos.UserDao;
import lt.baltic.talents.projects.CalendarNoteReminder.models.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Transactional(readOnly = true)
	@Override
	public boolean login(User user) {
		return userDao.login(user);
	}
	
	@Transactional
	@Override
	public boolean create(User user) {
		return userDao.create(user);
	}
	
	@Transactional
	@Override
	public boolean signup(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
