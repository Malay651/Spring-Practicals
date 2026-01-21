package com.rays.ctl;

import javax.servlet.http.HttpSession;

import org.hibernate.annotations.AttributeAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "Login")
public class LoginCtl {

	@Autowired
	public UserService service;
	
	public String display(@ModelAttribute("form") LoginForm form,@RequestParam(required = false) String operation,HttpSession session,
			Model model) {
		
	}
}
