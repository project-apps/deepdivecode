package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.ModelAndView;

import com.app.entity.dto.AppProperties;
import com.app.entity.dto.UserDto;
import com.app.service.AuthServiceImpl;

@Controller
@RequestMapping(path="/")
public class HomeController extends AbstractGenericController {

	@Autowired
	protected AuthServiceImpl authService;
	
	@GetMapping(path = { "/", "/home"})
	public ModelAndView home(HttpSession session) {
		ModelAndView mv = new ModelAndView("home"); 
		return mv;
	}
	
	@GetMapping(path = { "/contactus" })
	public ModelAndView contactus(HttpSession session) {
		ModelAndView mv = new ModelAndView("contactus"); 
		return mv;
	}
	@GetMapping(path = { "/writewithus" })
	public ModelAndView writeWithUs(HttpSession session) {
		ModelAndView mv = new ModelAndView("writewithus"); 
		return mv;
	}
	@GetMapping(path = { "/loginReg" })
	public ModelAndView showSigninupForm(HttpServletRequest request, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.addObject(new UserDto());
		mv.setViewName("loginReg");
		return mv;
	}

	@GetMapping(path= {"/error"})
	public ModelAndView error() {
		ModelAndView mv = new ModelAndView("error"); 
		return mv;
	}
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse resposne, HttpSession session) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.AUTHORIZATION, session.getAttribute(HttpHeaders.AUTHORIZATION).toString());
			HttpEntity<?> httpEntity = new HttpEntity<>(headers);
			authService.requestLogout();
		} catch (HttpClientErrorException httpEx) {
			httpEx.printStackTrace();
		} catch (Exception ex) {
			if (ex instanceof ResourceAccessException) {
				System.out.println(ex.getMessage());
			}
			ex.printStackTrace();
		}
		finally {
			session.removeAttribute(AppProperties.AUTH_USER.value());
			session.invalidate();
		}
		return new ModelAndView("home");
	}
	
}
