package com.cognizant;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Autowired
	private Environment environment;

	@Autowired
	private DatabaseInterface db;

	@GetMapping("/database/id/{i}")
	public Optional<Menu> getMenu(@PathVariable Integer i) {
		Optional<Menu> menu = db.findById(i);

		System.out.println("Menu -> " + menu);
		return menu;
	}

	@GetMapping("/database/all")
	public List<Menu> getMenus() {
		List<Menu> findAll = db.findAll();

		System.out.println("Menu -> " + findAll);
		return findAll;
	}

	@GetMapping("/database/edit/{id}/{name}")
	public void editMenu(@PathVariable("id") Integer id, @PathVariable("name") String name) {
		db.updateMenu(id, name);
	}

	@GetMapping("database/delete/{id}")
	public void deleteItem(@PathVariable("id") Integer id) {
		db.deleteItem(id);
	}

	@GetMapping("database/add/{product}/{price}/{category}")
	public String addItem(@PathVariable("product") String product,@PathVariable("price") int price,@PathVariable("category") String category)
	{
		
			Menu m = new Menu();
			m.setProduct(product);
			m.setPrice(price);
			m.setCategory(category);
			System.out.println(m);
			db.save(m);
			return "Saved";
	}
	


}

