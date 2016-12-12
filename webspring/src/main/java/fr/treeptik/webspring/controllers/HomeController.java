package fr.treeptik.webspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("homeController")
public class HomeController {

	@RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)
	protected ModelAndView homePage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "SpringWEB - Home");
		model.addObject("message", "This is the welcome page!");
		model.setViewName("home");
		return model;
	}
	
}
