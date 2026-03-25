package com.coforge.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody
public class LoginController {
	
	@RequestMapping("/login")
	public ModelAndView doLogin()
	{
		ModelAndView mView = new ModelAndView("login");
		return mView;
		
	}
	@RequestMapping("/authenticate")
	public ModelAndView doAuthentication(@RequestParam("uname")String uname,@RequestParam("pwd")String password)
	{
		System.out.println("do authenticate");
		String unameString = uname;
		String passString = password;
		ModelAndView mView=null ;
		if(unameString.equals("Ashu") && passString.equals("ashu123"))
		{   mView.addObject("uname",unameString);
			mView = new ModelAndView("welcome");
			
		}
		else {
			mView = new ModelAndView("error");
		}
		return mView;
	}
	
	

}
