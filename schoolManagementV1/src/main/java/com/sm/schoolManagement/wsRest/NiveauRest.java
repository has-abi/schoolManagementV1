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

import com.sm.schoolManagement.bean.Niveau;
import com.sm.schoolManagement.service.facade.NiveauService;
@RequestMapping("schoolManagement-Api/Niveau")
@RestController
public class NiveauRest {
	@Autowired
	private NiveauService coursService;
@GetMapping("findByid/id/{id}")
	public Niveau findByid(@PathVariable Long id) {
		return coursService.findByid(id);
	}
@GetMapping("findAll")
	public List<Niveau> findAll() {
		return coursService.findAll();
	}
@PostMapping("save")
	public int save(@RequestBody Niveau Niveau) {
		return coursService.save(Niveau);
	}
@PostMapping("edit")
	public int edit(Niveau Niveau) {
		return coursService.edit(Niveau);
	}
@DeleteMapping("deleteById/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return coursService.deleteById(id);
	};
	

}
