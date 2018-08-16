package com.shen.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shen.controller.home.LoginBean;

@Controller
public class LoginController {
	
	@Autowired
	RestAuthenticationProvider restAuthenticationProvider;
	
	@RequestMapping("/login")
	public String init(Model model, @ModelAttribute("loginBean") LoginBean loginBean, BindingResult result) {
//		if(null == loginBean) {
//			loginBean = new LoginBean();
//		}
//		if(result.hasErrors()) {
//			return "login";
//		}
//		UserDetails user = restAuthenticationProvider.retrieveUser(loginBean.getUsername(), loginBean.getPassword());
//		if ("wrongPass".equals(user.getPassword())) {
//			return "login";
//		}
		
		model.addAttribute("loginBean", loginBean);
		return "login";
	}

}
