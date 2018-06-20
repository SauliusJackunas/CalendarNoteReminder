package lt.baltic.talents.projects.CalendarNoteReminder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lt.baltic.talents.projects.CalendarNoteReminder.models.User;
import lt.baltic.talents.projects.CalendarNoteReminder.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
    private UserService userService;
	
//-----------------------------SIGN_UP_NEW_USER--------------------------------------------------
//	@RequestMapping(value = "/signup", method = RequestMethod.GET)
//	public String login(Model model) {
//		return "login/signup";
//	}
//
//	@RequestMapping(value = "/signup", method = RequestMethod.POST)
//	public String signup(Model model) {
//		userService.create(new User());
//		
//		return "login/login";
//	}
	
//-------------------------------------------------------------------------------------	
//	@RequestMapping(value = "testCreate", method = RequestMethod.GET)
//	public String login(Model model) {
//		userService.create(new User("OOOOO", "xzxzcxzcxzc".toCharArray()));
//		return "login/failure";
//	}
//-------------------------------------------------------------------------------------
	
//-------------------------------LOG_IN_USER-------------------------------------------
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, 
			@RequestParam(value = "user", required = false) String userParam,
			@RequestParam(value = "pwd", required = false) String pwd, RedirectAttributes redirectAttributes) {
		
		if (userParam == null || pwd == null) { 
			return "login/login"; 
		}
		
		User user = userService.login(new User(userParam, pwd.toCharArray()));
		
		if (user != null) {
			redirectAttributes.addFlashAttribute("user", user);
			return "redirect:/base";
		}
		
		return "login/failure";
	}
	
}
