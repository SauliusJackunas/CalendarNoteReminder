package lt.baltic.talents.projects.CalendarNoteReminder.controllers;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lt.baltic.talents.projects.CalendarNoteReminder.helpers.MessageHelper;
import lt.baltic.talents.projects.CalendarNoteReminder.models.Reminder;
import lt.baltic.talents.projects.CalendarNoteReminder.models.User;
import lt.baltic.talents.projects.CalendarNoteReminder.services.ReminderService;
import lt.baltic.talents.projects.CalendarNoteReminder.services.ReminderServiceImpl;

@Controller
public class BaseController {
	
	@Autowired
	private MessageHelper helper;
	
	@Autowired
	private ReminderService reminderService;
	
	private User user;

	@RequestMapping(value = "/base", method = RequestMethod.POST)
	public String setReminder(Model model,
			@RequestParam(value = "reminderDate", required = false) String reminderDate,
			@RequestParam(value = "reminderNote", required = false) String reminderNote) {
		
		LocalDateTime reminderTime = LocalDateTime.parse(reminderDate);
		
		Reminder reminder = new Reminder(reminderNote, reminderTime, user);
		
		boolean setReminder = reminderService.set(reminder);
		
		List<Reminder> updatedReminders = reminderService.get(user);
		
		user.setReminders(updatedReminders);
		
		model.addAttribute("user", user);
	
		if (setReminder) {
			System.out.println(user.toString());
		}
		
		return "hello/base";
	}
	
//	@RequestMapping(value = "/base", method = RequestMethod.GET)
//	public String loggedIn(@RequestParam(value = "user", required = false) String userParam,
//			@RequestParam(value = "pwd", required = false) String pwd, Model model) {
//		
//		if(userParam != null) {
//			return "hello/base";
//		}
//			return "login/failure";
//		
//	}
	
	@RequestMapping(value = "/base", method = RequestMethod.GET)
	public String start(Model model) {
		
		user = (User) model.asMap().get("user");
		
		System.out.println(helper.getMessage("message.hello"));
		
		return "hello/base";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String start() {
		return "/login/login";
	}
	

}
