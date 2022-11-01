package com.springmvc.Controller.Web.Api;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.Controller.Web.UserController;
import com.springmvc.Entity.UserEntity;
import com.springmvc.Service.UserService;

@Controller(value="controller")
public class UserApi {
	final static Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@PostMapping("/checkUsername")
	@ResponseBody
	public String checkUsername(HttpServletRequest req, @ModelAttribute("user") UserEntity user) throws Exception {
		String res = "";
		try {
			 res = userService.checkUserName(user.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return res;
	}
}
