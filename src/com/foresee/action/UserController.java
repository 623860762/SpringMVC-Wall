package com.foresee.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;


	@Controller
	@RequestMapping("/user")
	public class UserController  {
		@RequestMapping("/register.do")
		public String register(HttpServletRequest request,HttpServletResponse response) {
		    String name = (String)request.getParameter("name");
		    System.out.println("ssss");
			request.setAttribute("user", "ÕÅÄþ");
			return "/register";
		}
		
		@RequestMapping("/createSuccess.do")
		public String createSuccess(HttpServletRequest request,HttpServletResponse response) {
		    String username = (String)request.getParameter("username");
		    String password = (String)request.getParameter("password");
		    System.out.println(username);
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			return "/createSuccess";
		}
		
	 
	 @RequestMapping(value = "/gotoRegister.do")
	 public String gotoRegister(WebRequest request){
		 String userName = request.getParameter("userName");
		 return "success";
	 }
}
