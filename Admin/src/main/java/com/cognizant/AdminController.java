package com.cognizant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	
	@Autowired
	AdminProxy admin;
	
	@GetMapping("/admin-feign/id/{id}")
	public Menu convertCurrencyFeigh(@PathVariable("id") Integer id)
	{
		Menu response = admin.retrieveExchangeValue(id);
		return response;
	}

	@GetMapping("/admin-feign/all")
	public List<Menu> getAllAdminItems()
	{
		List<Menu> allMenus = admin.getAllMenus();
		return allMenus;
	}
	
	@GetMapping("/admin-feign/edit/{id}/{name}")
	public void editMenu(@PathVariable("id") Integer id, @PathVariable("name") String name)
	{
		admin.editMenu(id, name);
	}
}
