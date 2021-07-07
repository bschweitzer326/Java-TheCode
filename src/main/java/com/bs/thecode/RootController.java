package com.bs.thecode;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RootController {
	@RequestMapping("/")
	public String home() {
		return "root.jsp";
	}
	
	@RequestMapping(value="/code", method=RequestMethod.POST)
    public String secret(@RequestParam(value="sword") String sword, HttpSession session) {
		session.setAttribute("code", sword);
		if(sword.equals("bushido")) {
			return "redirect:/code";
		} else {
			return "redirect:/createError";
		}

	}
	
	@RequestMapping("/code")
	public String code() {
		return "code.jsp";
	}
	
	 @RequestMapping("/createError")
	    public String flashMessages(RedirectAttributes redirectAttributes) {
	        redirectAttributes.addFlashAttribute("wrong", "You must train harder!");
	        return "redirect:/";
	    }
	 
}
