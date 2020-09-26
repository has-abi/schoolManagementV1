package com.sm.schoolManagement.wsRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.schoolManagement.bean.User;
import com.sm.schoolManagement.service.facade.UserService;
@RequestMapping("schoolManagement-Api/User")
@RestController
public class UserRest {
	@Autowired
	private UserService coursService;
@GetMapping("findByid/id/{id}")
	public User findByid(@PathVariable Long id) {
		return coursService.findByid(id);
	}
@GetMapping("findAll")
	public List<User> findAll() {
		return coursService.findAll();
	}
@PostMapping("save")
	public int save(@RequestBody User User) {
		return coursService.save(User);
	}
@PostMapping("edit")
	public int edit(User User) {
		return coursService.edit(User);
	}
@DeleteMapping("deleteById/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return coursService.deleteById(id);
	};
	

}
