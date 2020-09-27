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

import com.sm.schoolManagement.bean.Devoir;
import com.sm.schoolManagement.service.facade.DevoirService;
@RequestMapping("schoolManagement-Api/Devoir")
@RestController
public class DevoirRest {
	@Autowired
	private DevoirService coursService;
@GetMapping("findByid/id/{id}")
	public Devoir findByid(@PathVariable Long id) {
		return coursService.findByid(id);
	}
@GetMapping("findAll")
	public List<Devoir> findAll() {
		return coursService.findAll();
	}
@PostMapping("save")
	public int save(@RequestBody Devoir Devoir) {
		return coursService.save(Devoir);
	}
@PostMapping("edit")
	public int edit(Devoir Devoir) {
		return coursService.edit(Devoir);
	}
@DeleteMapping("deleteById/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return coursService.deleteById(id);
	};
	

}
