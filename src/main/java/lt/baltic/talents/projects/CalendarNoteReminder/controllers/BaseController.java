package lt.baltic.talents.projects.CalendarNoteReminder.controllers;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lt.baltic.talents.projects.CalendarNoteReminder.helpers.MessageHelper;
import lt.baltic.talents.projects.CalendarNoteReminder.models.Reminder;
import lt.baltic.talents.projects.CalendarNoteReminder.services.ReminderService;

@Controller
public class BaseController {
	
	@Autowired
	private MessageHelper helper;
	private ReminderService reminderService;

	@RequestMapping(value = "/base", method = RequestMethod.POST)
	public String setReminder(Model model,
			@RequestParam(value = "reminderDate", required = false) String reminderDate,
			@RequestParam(value = "reminderNote", required = false) String reminderNote) {
		
		LocalDateTime reminderTime = LocalDateTime.parse(reminderDate);
		
		Reminder reminder = new Reminder(reminderNote, reminderTime);
		
		boolean setReminder = reminderService.set(reminder);
		
		System.out.println(setReminder);
		
		return "hello/base";
	}
	
	@RequestMapping(value = "/base", method = RequestMethod.GET)
	public String loggedIn(@RequestParam(value = "user", required = false) String userParam,
			@RequestParam(value = "pwd", required = false) String pwd, Model model) throws ParseException {
		
				class MyTimerTask extends TimerTask{
					@Override
				    public void run(){
						JOptionPane.showMessageDialog(null, "You have an event!");
				    }
				}
		
				DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date setDate = (Date)dateFormatter.parse("2018-06-20 12:06");
				Timer timer = new Timer();
				timer.schedule(new MyTimerTask(), setDate);
		
				if(userParam != null) {
					return "hello/base";
				}
					return "login/failure";
	}
	
	
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String start(@RequestParam(value = "name", required = false) String name, Model model) {
//		LocalDateTime date = LocalDateTime.now();
//		model.addAttribute("now", Date.from(date.atZone(ZoneId.systemDefault()).toInstant()));
//
//		String operatingSystem = System.getProperty("os.name");
//		model.addAttribute("operatingSystem", operatingSystem);
//		
//		String javaVersion = System.getProperty("java.version");
//		model.addAttribute("javaVersion", javaVersion);
//		
//		System.out.println(helper.getMessage("message.hello"));
//		
//		return "login/login";
//	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String start(@RequestParam(value = "name", required = false) String name, Model model) {
		LocalDateTime date = LocalDateTime.now();
		model.addAttribute("now", Date.from(date.atZone(ZoneId.systemDefault()).toInstant()));

		String operatingSystem = System.getProperty("os.name");
		model.addAttribute("operatingSystem", operatingSystem);
		
		String javaVersion = System.getProperty("java.version");
		model.addAttribute("javaVersion", javaVersion);
		
		System.out.println(helper.getMessage("message.hello"));
		
		return "hello/base";
	}

	public String start() {
		return "login/login";
	}
	
//--------------------------------------------------------------------
//	public class getReminder {
//		
//		private class MyTimerTask extends TimerTask{
//			
//			@Override
//		    public void run(){
//				JOptionPane.showMessageDialog(null, "You have an event!");
//		    }
//		}
//
//		public void main(String[] args) throws ParseException {
//			
//		    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		    Date setDate = (Date)dateFormatter.parse("2018-06-19 21:37");
//		    Timer timer = new Timer();
//		    timer.schedule(new MyTimerTask(), setDate);
//		}
//	}
//
}


