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

import com.sm.schoolManagement.bean.Maitre;
import com.sm.schoolManagement.service.facade.MaitreService;
@RequestMapping("schoolManagement-Api/Maitre")
@RestController
public class MaitreRest {
	@Autowired
	private MaitreService coursService;
@GetMapping("findByid/id/{id}")
	public Maitre findByid(@PathVariable Long id) {
		return coursService.findByid(id);
	}
@GetMapping("findAll")
	public List<Maitre> findAll() {
		return coursService.findAll();
	}
@PostMapping("save")
	public int save(@RequestBody Maitre Maitre) {
		return coursService.save(Maitre);
	}
@PostMapping("edit")
	public int edit(Maitre Maitre) {
		return coursService.edit(Maitre);
	}
@DeleteMapping("deleteById/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return coursService.deleteById(id);
	};
	

}
