package com.nexus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nexus.domain.User;
import com.nexus.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	/**
	 * this method is use to list the all user list.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<User> getUsers() {

		try {

			System.out.println("Successfully listed user list with " + userService.findAll().size() + " rows");
			return userService.findAll();

		} catch (Exception e) {
			System.err.println("Error in lising users: " + e.getMessage());
			return null;

		}

	}

	/**
	 * this method is use to add user.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public User addUser(@RequestBody User user) {
		String userId = "";
		try {
			userId = String.valueOf(user.getId());
			System.out.println("Successfully added user  with id: " + userId);
			return userService.save(user);

		} catch (Exception e) {
			System.err.println("Error in added user with id: " + userId);
			return null;
		}
	}

	/**
	 * this method is use to list particular user by id.
	 * 
	 * @return
	 */

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUser(@PathVariable("id") int id) {
		return userService.findByUserId(id);
	}
	
	
	/**
	 * this method is use to list particular user by id to update.
	 * 
	 * @return
	 */

	@RequestMapping(value = "/updateuser", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUserWithId(@RequestParam("id") int id) {
		return userService.findByUserId(id);
	}

	/**
	 * this method is use to update user.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
		try {
			System.out.println("Successfully updated user with id: " + user.getId());
			userService.save(user);
			return user;

		} catch (Exception e) {
			System.err.println("Error in updating user with id: " + user.getId()+"with exception "+e);
			return null;

		}

	}

	/**
	 * this method is use to delete user.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public void updateUser(@PathVariable int id) {
		try {
			System.out.println("Successfully deleted user with id: " + id);
			userService.delete(id);

		} catch (Exception e) {
			System.err.println("Error in updating user with id: " + id);
		}

	}
}
