package com.mini.proj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mini.proj.dao.Contact;
import com.mini.proj.error.UserDefinedException;
import com.mini.proj.service.ContactService;

@Controller
public class ContactInfoController {

	@Autowired
	private ContactService cntctSrvc;

	@RequestMapping(value = { "/", "cntctCrtnSuces" }, method = RequestMethod.GET)
	public String index(Model model) {

		model.addAttribute("contact", new Contact());

		return "index";
	}

	@PostMapping("/saveContact")
	public String handleSubmtBtn(@ModelAttribute("contact") Contact c, RedirectAttributes redrctAtrb) {
		boolean isSaved = false;

		isSaved = cntctSrvc.saveContact(c);
		if (isSaved) {
		    if(c.getCid()!=null) {
		    	redrctAtrb.addFlashAttribute("updtMsg", "Contact updated sucessfully");
		    }
		    else {
			    redrctAtrb.addFlashAttribute("sucssMsg", "Contact saved  sucessfully");
		    }
		} else {
			redrctAtrb.addFlashAttribute("errMsg", "failed to save , please try agin later");
		}

		return "redirect:/cntctCrtnSuces";
	}

	@RequestMapping("/viewContacts")
	public String handleViewCntctHyprLnk(Model model) {
		List<Contact> cntcts = null;
		cntcts = cntctSrvc.getAllContacts();
		model.addAttribute("cntcts", cntcts);
		return "viewContacts";
	}
}
