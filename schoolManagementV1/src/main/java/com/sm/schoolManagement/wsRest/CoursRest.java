package com.sm.schoolManagement.wsRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.schoolManagement.bean.Cours;
import com.sm.schoolManagement.service.facade.CoursService;
@RequestMapping("schoolManagement-Api/Cours/")
@RestController
public class CoursRest {
	@Autowired
	private CoursService coursService;
public Page<Cours> findAllWithPagination(int page, int size, String sort) {
		return coursService.findAllWithPagination(page, size, sort);
	}
@GetMapping("findByid/id/{id}")
	public Cours findByid(@PathVariable Long id) {
		return coursService.findByid(id);
	}
@GetMapping("findAll")
	public List<Cours> findAll() {
		return coursService.findAll();
	}
@PostMapping("save")
	public ResponseEntity<Cours> save(@RequestBody Cours Cours) {
		return coursService.save(Cours);
	}
@PostMapping("edit")
	public ResponseEntity<Cours> edit(Cours Cours) {
		return coursService.edit(Cours);
	}
@DeleteMapping("deleteById/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return coursService.deleteById(id);
	};
	

}
