package com.sm.schoolManagement.wsRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipios.springsearch.anotation.SearchSpec;
import com.sm.schoolManagement.bean.Etudiant;
import com.sm.schoolManagement.service.facade.EtudiantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("school-management-api/etudiant")
@Api(value = "Api concerne les opération crud sur l'étudiant")
public class EtudiantRest {
	@Autowired
	private EtudiantService etudiantService;
	
	@ApiOperation(value = "Chercher un étudiant en se basant sur leur attributs")
	@GetMapping("/etudiants")
	public ResponseEntity<List<Etudiant>> search(@SearchSpec Specification<Etudiant> spec) {
		return etudiantService.search(spec);
	}

	@ApiOperation(value = "Récupérer un étudiant grâçe à son CNE")
	@GetMapping("/cne/{cne}")
	public Etudiant findByCne(@PathVariable String cne) {
		return etudiantService.findByCne(cne);
	}
	
	@ApiOperation(value = "Récupérer la liste des étudiants en se basant sur le cin de parent")
	@GetMapping("/parent/cin/{cin}")
	public List<Etudiant> findByParentCin(@PathVariable String cin) {
		return etudiantService.findByParentCin(cin);
	}
	
	@ApiOperation(value = "Récupérer la liste de tout les étudiants")
	@GetMapping("/")
	public List<Etudiant> findAll() {
		return etudiantService.findAll();
	}
	
	@ApiOperation(value = "Récupérer la liste des étudiants avec la pagination et avec ordre")
	@GetMapping("/page/{page}/size/{size}/sort/{sort}")
	public Page<Etudiant> findAllWithPagination(@PathVariable int page,@PathVariable int size,@PathVariable String sort) {
		return etudiantService.findAllWithPagination(page, size, sort);
	}
	
	@ApiOperation(value = "Pérsister un étudiant")
	@PostMapping("/")
	public ResponseEntity<Etudiant> create(@RequestBody Etudiant etudiant) {
		return etudiantService.create(etudiant);
	}
	
	@ApiOperation(value = "Modifier un étudiant")
	@PutMapping("/")
	public ResponseEntity<Etudiant> update(@RequestBody Etudiant etudiant) {
		return etudiantService.update(etudiant);
	}
	
	@ApiOperation(value = "Supprimer un étudiant suivant le CNE")
	@DeleteMapping("/cne/{cne}")
	public ResponseEntity<Etudiant> deleteByCne(@PathVariable String cne) {
		return etudiantService.deleteByCne(cne);
	}
}
