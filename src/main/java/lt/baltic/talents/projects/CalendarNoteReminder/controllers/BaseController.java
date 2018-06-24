package lt.baltic.talents.projects.CalendarNoteReminder.controllers;

import java.util.Date;
import java.awt.Color;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.AlternativeJdkIdGenerator;
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

	private User oldUser;
	
	@RequestMapping(value = "/base", method = RequestMethod.POST)
	public String setReminder(Model model,
			@RequestParam(value = "reminderDate", required = false) String reminderDate,
			@RequestParam(value = "reminderNote", required = false) String reminderNote, RedirectAttributes redirectAttributes) {
		
		if ((reminderDate == null || reminderDate.length() == 0) || (reminderNote == null || reminderNote.length() == 0)) {
			model.addAttribute("user", user);
			return "hello/base";
		}
		
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
		return "redirect:/base";
//		return "hello/base";
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
	public String start(Model model, RedirectAttributes redirectAttributes) throws ParseException, CloneNotSupportedException{
		
//---------------------------------------------Karoliui-------------------------------------
//		User user = null;
		if(!model.containsAttribute("user")) {
			model.addAttribute("user", oldUser);
		}else {
			user = (User) model.asMap().get("user");
		}
		oldUser = new User();
		oldUser = (User) user.clone();
		
		List<Reminder> reminders = user.getReminders();
		
		for(Reminder rem : reminders) {
			if(rem.getReminderDateTime().isAfter(LocalDateTime.now())){
				class MyTimerTask extends TimerTask{
					@Override
				    public void run(){
						System.out.println(rem.getNote());
						JLabel label =new JLabel(rem.getNote());
						label.setForeground(Color.RED);
						label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 22));
						JDialog dialog = new JDialog();
						dialog.setAlwaysOnTop(true);    
						JOptionPane.showMessageDialog(dialog, label, "THE PRINCESS NEEDS YOU!", JOptionPane.WARNING_MESSAGE, new ImageIcon("C:\\Users\\Domantas\\Desktop/QGo5isT.gif"));
					}
				}
				DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			    String formatedDate = rem.getReminderDateTime().toString().replace('T', ' ');
			    Date date = (Date) dateFormatter.parse(formatedDate);
			    Timer timer = new Timer();
			    timer.schedule(new MyTimerTask(), date);
			}
		}
		
		return "hello/base";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String start() {
		return "/login/login";
	}
	

}
