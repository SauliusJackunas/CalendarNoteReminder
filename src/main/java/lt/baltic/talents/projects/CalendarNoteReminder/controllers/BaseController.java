package lt.baltic.talents.projects.CalendarNoteReminder.controllers;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lt.baltic.talents.projects.CalendarNoteReminder.helpers.MessageHelper;

@Controller
public class BaseController {
	
	@Autowired
	private MessageHelper helper;

//	@RequestMapping(value = "/base", method = RequestMethod.POST)
//	public String setReminder(@RequestParam(value = "reminderDate", required = false) String reminderDate, Model model) {
//		
//		System.out.println(reminderDate);
//		return "hello/base";
//	}
	
	@RequestMapping(value = "/base", method = RequestMethod.GET)
	public String loggedIn(@RequestParam(value = "user", required = false) String userParam,
			@RequestParam(value = "pwd", required = false) String pwd, Model model) {
		
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
	public String start() {
		return "login/login";
	}
	

}
