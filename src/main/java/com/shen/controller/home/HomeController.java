package com.shen.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(path = "/")
	public String init() {
		return "home";
	}

	@RequestMapping(path = "/hello")
	public String hello() {
		return "hello";
	}

}
