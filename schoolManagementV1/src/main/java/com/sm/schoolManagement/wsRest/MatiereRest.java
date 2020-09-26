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

import com.sm.schoolManagement.bean.Matiere;
import com.sm.schoolManagement.service.facade.MatiereService;
@RequestMapping("schoolManagement-Api/Matiere")
@RestController
public class MatiereRest {
	@Autowired
	private MatiereService coursService;
@GetMapping("findByid/id/{id}")
	public Matiere findByid(@PathVariable Long id) {
		return coursService.findByid(id);
	}
@GetMapping("findAll")
	public List<Matiere> findAll() {
		return coursService.findAll();
	}
@PostMapping("save")
	public int save(@RequestBody Matiere Matiere) {
		return coursService.save(Matiere);
	}
@PostMapping("edit")
	public int edit(Matiere Matiere) {
		return coursService.edit(Matiere);
	}
@DeleteMapping("deleteById/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return coursService.deleteById(id);
	};
	

}
