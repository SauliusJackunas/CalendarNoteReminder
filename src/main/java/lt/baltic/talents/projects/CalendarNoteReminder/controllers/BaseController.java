package lt.baltic.talents.projects.CalendarNoteReminder.controllers;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

//	private User oldUser;
	
	@RequestMapping(value = "/base", method = RequestMethod.POST)
	public String setReminder(Model model,
//<<<<<<< HEAD
			@RequestParam(value = "reminderDate", required = false) String reminderDate,
			@RequestParam(value = "reminderNote", required = false) String reminderNote, RedirectAttributes redirectAttributes) {
//=======
//			@RequestParam(value = "reminderDate", required = true) String reminderDate,
//			@RequestParam(value = "reminderNote", required = true) String reminderNote) {
		
		if ((reminderDate == null || reminderDate.length() == 0) || (reminderNote == null || reminderNote.length() == 0)) {
			model.addAttribute("user", user);
			return "hello/base";
		}
//>>>>>>> aa99a59822b039bd7aa6b5d6e9828c131e153eb4
		
		String formatedDate = reminderDate.toString().replace(' ', 'T');
		LocalDateTime reminderTime = LocalDateTime.parse(formatedDate);
		
		Reminder reminder = new Reminder(reminderNote, reminderTime, user);
		
		boolean setReminder = reminderService.set(reminder);
		
		List<Reminder> updatedReminders = reminderService.get(user);
		
		user.setReminders(updatedReminders);
		
		model.addAttribute("user", user);
	
		if (setReminder) {
			System.out.println(user.toString());
		}
		redirectAttributes.addFlashAttribute("user", user);
//		return "redirect:/base";
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
	public String start(Model model) throws ParseException{
		
//---------------------------------------------Karoliui-------------------------------------
//		User user = null;
//		if(!model.containsAttribute("user")) {
//			model.addAttribute("user", oldUser);
//		}else {
		user = (User) model.asMap().get("user");
//		}
//		oldUser = new User();
//		oldUser = (User) user.clone();
		
		List<Reminder> reminders = user.getReminders();
		
//		System.out.println(helper.getMessage("message.hello"));
	
		for(Reminder rem : reminders) {
//			if(rem.getReminderDateTime().isAfter(LocalDateTime.now())){
				class MyTimerTask extends TimerTask{
					@Override
				    public void run(){
						System.out.println(rem.getNote());
//						model.addAttribute("alert", true);
					}
				}
				DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			    String formatedDate = rem.getReminderDateTime().toString().replace('T', ' ');
			    Date date = (Date) dateFormatter.parse(formatedDate);
			    Timer timer = new Timer();
			    timer.schedule(new MyTimerTask(), date);
//			}
		}
		
//		redirectAttributes.addFlashAttribute("user", user);
		return "hello/base";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String start() {
		return "/login/login";
	}
	

}
