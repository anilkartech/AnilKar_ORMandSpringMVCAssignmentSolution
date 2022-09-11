package com.greatLearning.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String viewemp() {
		return "redirect:/customer/list";
	}
}
