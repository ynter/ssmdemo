package com.ynter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试controller类
 * 
 * @author Ynter.H
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {

	/**
	 * 测试展示页面
	 * 
	 * @param request
	 *            - 页面request
	 * @return 展示页面
	 */
	@PostMapping("/showMessage")
	public ModelAndView showMessage(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("test/showMessage");
		mv.addObject("message", "Hello ssm demo!");

		return mv;
	}
}
