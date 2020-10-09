package com.mini.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mini.proj.dao.Contact;
import com.mini.proj.service.ContactService;



@Controller
public class ViewController {
	
	@Autowired
    private ContactService cntctSrvc;
	
	public String handleAddCntctHyprLnk(Model model) {
		
		return null;
	}
	
	@RequestMapping("/editCntct")
	public String editContactDtls(@RequestParam("cid") Integer cid,Model model) {
		Contact cntct = cntctSrvc.getContactById(cid);
		model.addAttribute("contact",cntct);
		return "index";
	}
	@RequestMapping("/deleteCntct")
    public String deleteContact(@RequestParam("cid")Integer cid, RedirectAttributes rdrctAtrbt) {
		cntctSrvc.deleteContact(cid);
		rdrctAtrbt.addFlashAttribute("dltdMsg","delete Message Sucessfully");
    	return "redirect:/viewContacts";
    }
    

}
