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

import com.sm.schoolManagement.bean.Local;
import com.sm.schoolManagement.service.facade.LocalService;
@RequestMapping("schoolManagement-Api/Local")
@RestController
public class LocalRest {
	@Autowired
	private LocalService coursService;
@GetMapping("findByid/id/{id}")
	public Local findByid(@PathVariable Long id) {
		return coursService.findByid(id);
	}
@GetMapping("findAll")
	public List<Local> findAll() {
		return coursService.findAll();
	}
@PostMapping("save")
	public int save(@RequestBody Local Local) {
		return coursService.save(Local);
	}
@PostMapping("edit")
	public int edit(Local Local) {
		return coursService.edit(Local);
	}
@DeleteMapping("deleteById/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return coursService.deleteById(id);
	};
	

}
