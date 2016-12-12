package fr.treeptik.webspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("helloController")
public class HelloWordController {

	@RequestMapping("/hello")
	public ModelAndView helloWorld() {
		String msg = "Hello Word !!!   :)";
		System.out.println(msg);
		return new ModelAndView("hello", "message", msg);
	}
}
