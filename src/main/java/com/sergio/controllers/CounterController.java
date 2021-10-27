package com.sergio.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CounterController {
	@RequestMapping(value = "/counter", method = RequestMethod.GET)
	public String displayCounter(HttpSession session, Model model) {

		Object sessionContador = session.getAttribute("contador");

		if (sessionContador == null) {
			session.setAttribute("contador", 0);
			session.setAttribute("texto", "times");
			model.addAttribute("contador", session.getAttribute("contador"));
			model.addAttribute("texto", session.getAttribute("texto"));
		} else {
			session.setAttribute("contador", ((int) session.getAttribute("contador") + 1));
			if ((int) session.getAttribute("contador") == 1) {
				session.setAttribute("texto", "time");
				model.addAttribute("contador", session.getAttribute("contador"));
				model.addAttribute("texto", session.getAttribute("texto"));

			} else {
				session.setAttribute("texto", "times");
				model.addAttribute("contador", session.getAttribute("contador"));
				model.addAttribute("texto", session.getAttribute("texto"));
			}
		}

		return "index.jsp";
	}

	@RequestMapping(value = "/destroy_session", method = RequestMethod.POST)
	public String destroySession(HttpSession session, Model model) {

		Object sessionContador = session.getAttribute("contador");
		System.out.println(sessionContador);
		if (sessionContador != null) {
			session.removeAttribute("contador");
			session.removeAttribute("texto");
			model.addAttribute("contador", session.getAttribute("contador"));
			model.addAttribute("texto", session.getAttribute("texto"));
		}

		return "redirect:/counter";
	}

	@RequestMapping(value="/ByTwo", method=RequestMethod.POST)
	public String addTwo(HttpSession session, Model model) {
		
		Object sessionContador = session.getAttribute("contador");

		if (sessionContador == null) {
			session.setAttribute("contador", 0);
			session.setAttribute("texto", "times");
			model.addAttribute("contador", session.getAttribute("contador"));
			model.addAttribute("texto", session.getAttribute("texto"));
		} else {
			session.setAttribute("contador", ((int) session.getAttribute("contador") + 1));
			
			
				session.setAttribute("texto", "times");
				model.addAttribute("contador", session.getAttribute("contador"));
				model.addAttribute("texto", session.getAttribute("texto"));
			}
		

		return "redirect:/counter";
		
	}
	
	@RequestMapping(value="/prefCounterFrm", method=RequestMethod.GET)
	public String addPref(@RequestParam(value="increaseNumber", required=false)String increaseNumber, HttpSession session, Model model) {

		int intValue=0;
		
		if ( increaseNumber == "") {
			intValue =0;
		}else {
			intValue = Integer.parseInt(increaseNumber);
		}
		
		Object sessionContador = session.getAttribute("contador");

		
		
		if (sessionContador == null) {
			session.setAttribute("contador", 0);
			session.setAttribute("texto", "times");
			model.addAttribute("contador", session.getAttribute("contador"));
			model.addAttribute("texto", session.getAttribute("texto"));
		} else {
			session.setAttribute("contador", ((int) session.getAttribute("contador") + intValue-1));
			
			
				session.setAttribute("texto", "times");
				model.addAttribute("contador", session.getAttribute("contador"));
				model.addAttribute("texto", session.getAttribute("texto"));
			}
		

		return "redirect:/counter";
	}
}
