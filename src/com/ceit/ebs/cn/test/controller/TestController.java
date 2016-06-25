package com.ceit.ebs.cn.test.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ceit.ebs.cn.test.entity.Test;
import com.ceit.ebs.cn.test.services.ITestService;


	@Controller
	@RequestMapping("/testController")
	public class TestController  {
		
		private ITestService testService;
		
		public ITestService getTestService() {
			return testService;
		}

		public void setTestService(ITestService testService) {
			this.testService = testService;
		}

		@RequestMapping("/register.do")
		public String register(HttpServletRequest request,HttpServletResponse response) {
		    String name = (String)request.getParameter("name");
		    System.out.println("ssss");
			request.setAttribute("user", "aaaaa");
			return "/register";
		}
		
		@RequestMapping("/createSuccess.do")
		public String createSuccess(HttpServletRequest request,HttpServletResponse response) {
		    String username = (String)request.getParameter("username");
		    String password = (String)request.getParameter("password");
		    try {
				List<Test> list = testService.getAll();
				request.setAttribute("list", list);
				for(int i=0; i<list.size(); i++){
					System.out.println(list.get(i).getName()+list.get(i).getAge());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println(username);
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			return "/createSuccess";
		}
		
}
