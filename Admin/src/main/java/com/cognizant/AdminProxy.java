package com.cognizant;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="database-service",url="localhost:8000")
public interface AdminProxy {
	
	@GetMapping("/database/id/{i}")
	public Menu retrieveExchangeValue(@PathVariable("i") Integer id);
	
	@GetMapping("/database/all")
	public List<Menu> getAllMenus();
	
	@GetMapping("/database/edit/{id}/{name}")
	public void editMenu(@PathVariable("id") Integer id, @PathVariable("name") String name);

}
