package com.cognizant;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DatabaseInterface extends JpaRepository<Menu, Integer> {
	
	Optional<Menu> findById(Integer i);
	
	List<Menu> findAll();
	
	@Modifying
	@Transactional
	@Query("update Menu u set u.product = :name where u.id = :id")
	void updateMenu(@Param("id") Integer id,@Param("name") String name);
	
	
	@Modifying
	@Transactional
	@Query("delete Menu u where u.id = :id")
	int deleteItem(@Param("id") Integer id);
	
	
}
