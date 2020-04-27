package com.springjdbctemplete.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springjdbctemplete.dao.ContactDAO;
import com.springjdbctemplete.model.Contact;

@Controller
public class MainController {
	
	@Autowired
	private ContactDAO contactdao;
	
	@RequestMapping(value = "/")
	public ModelAndView listContact(ModelAndView modelandview) {
		List<Contact> listcontact = contactdao.list();
		modelandview.addObject("listcontact", listcontact);
		modelandview.setViewName("index");
		return modelandview;
	}

}
