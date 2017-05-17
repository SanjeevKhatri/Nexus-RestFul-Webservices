package com.nexus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nexus.domain.User;
import com.nexus.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome() {
		return "index";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAdmin() {
		return "admin";
	}

	@RequestMapping(value = "/admin/listUsers", method = RequestMethod.GET)
	public String getUserList() {
		return "user";
	}

	@RequestMapping(value = "/admin/addUser", method = RequestMethod.GET)
	public String getAddUserForm() {
		return "addUser";
	}

	@RequestMapping(value = "/admin/updateForm", method = RequestMethod.GET)
	public String getupdateForm(Model model, User user) {
		User finedUser = userService.findByUserId(user.getId());
		model.addAttribute("user", finedUser);
		return "updateForm";
	}

	@RequestMapping(value = "/admin/updateForm/{id}", method = RequestMethod.GET)
	public String getUpdateUserForm(Model model, @PathVariable("id") int id, User user) {
		User finedUser = userService.findByUserId(id);
		model.addAttribute("user", finedUser);
		return "updateForm";
	}
}
