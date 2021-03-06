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

import com.sm.schoolManagement.bean.MatiereItem;
import com.sm.schoolManagement.service.facade.MatiereItemService;
@RequestMapping("schoolManagement-Api/MatiereItem/")
@RestController
public class MatiereItemRest {
	@Autowired
	private MatiereItemService coursService;
public Page<MatiereItem> findAllWithPagination(int page, int size, String sort) {
		return coursService.findAllWithPagination(page, size, sort);
	}
	public List<MatiereItem> findByMatiereNiveauLibelle(String libelle) {
		return coursService.findByMatiereNiveauLibelle(libelle);
	}
@GetMapping("findByid/id/{id}")
	public MatiereItem findByid(@PathVariable Long id) {
		return coursService.findByid(id);
	}
@GetMapping("findAll")
	public List<MatiereItem> findAll() {
		return coursService.findAll();
	}
@PostMapping("save")
	public ResponseEntity<MatiereItem> save(@RequestBody MatiereItem MatiereItem) {
		return coursService.save(MatiereItem);
	}
@PostMapping("edit")
	public ResponseEntity<MatiereItem> edit(MatiereItem MatiereItem) {
		return coursService.edit(MatiereItem);
	}
@DeleteMapping("deleteById/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return coursService.deleteById(id);
	};
	

}
