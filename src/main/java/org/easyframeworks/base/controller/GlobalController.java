package org.easyframeworks.base.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/global")
public class GlobalController {

	@RequestMapping(value = "/error")
	public ModelAndView goError(){
		ModelAndView maView = new ModelAndView("common/error");
		return maView;
	}
	
	
	@RequestMapping(value = "/404")
	public ModelAndView go404(){
		ModelAndView maView = new ModelAndView("common/404");
		return maView;
	}
}
