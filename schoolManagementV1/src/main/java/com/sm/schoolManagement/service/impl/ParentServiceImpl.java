package com.sm.schoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sm.schoolManagement.bean.Parent;
import com.sm.schoolManagement.dao.ParentDao;
import com.sm.schoolManagement.exception.AlreadyExistsException;
import com.sm.schoolManagement.exception.EmptyElementException;
import com.sm.schoolManagement.exception.NotDeletedException;
import com.sm.schoolManagement.exception.NotFoundException;
import com.sm.schoolManagement.exception.NotPersistedException;
import com.sm.schoolManagement.service.facade.EtudiantService;
import com.sm.schoolManagement.service.facade.ParentService;

/**
 * 
 * @author Abida Hassan
 * @version 1.0
 *
 */
@Service
public class ParentServiceImpl implements ParentService {
	@Autowired
	private ParentDao parentDao;
	@Autowired
	private EtudiantService etudiantService;

	@Override
	public Parent findByCin(String cin) {
		return parentDao.findByCin(cin);
	}

	@Override
	public List<Parent> findAll() {
		return parentDao.findAll();
	}

	@Override
	public Page<Parent> findAllWithPagination(int page, int size, String sort) {
		if (sort == "desc") {
			return parentDao.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")));
		} else {
			return parentDao.findAll(PageRequest.of(page, size));
		}
	}

	@Override
	public ResponseEntity<Parent> Create(Parent parent) {
		if (parent.getCin() == null || parent.getCin() == "")
			throw new EmptyElementException("CIN est obligatoire!");
		else {
			Parent foundedParent = findByCin(parent.getCin());
			if (foundedParent != null)
				throw new AlreadyExistsException("il existe un autre personne avec ce CIN");
			else {
				Parent inserted = parentDao.save(parent);
				if (inserted == null)
					throw new NotPersistedException("On ne peut pas enregistrer le parent!");
				else {
					parent.getEtudiants().forEach(e -> {
						e.setParent(inserted);
						etudiantService.create(e);
					});
					return new ResponseEntity<Parent>(inserted, HttpStatus.OK);
				}
			}
		}
	}

	@Override
	public ResponseEntity<Parent> update(Parent parent) {
		if (parent.getCin() == null || parent.getCin() == "")
			throw new EmptyElementException("CIN est obligatoire!");
		else {

		}
		return null;
	}

	@Override
	public ResponseEntity<Parent> deleteByCin(String Cin) {
		Parent foudedParent = findByCin(Cin);
		if (foudedParent == null)
			throw new NotFoundException("Auccun parent trouvée!");
		else {
			parentDao.delete(foudedParent);
			if (parentDao.existsById(foudedParent.getId()))
				throw new NotDeletedException("On ne peut supprimé le parent!");
			else {
				return new ResponseEntity<Parent>(foudedParent, HttpStatus.OK);
			}
		}

	}

	@Override
	public ResponseEntity<List<Parent>> search(Specification<Parent> spec) {
		return new ResponseEntity<List<Parent>>(parentDao.findAll(Specification.where(spec)), HttpStatus.OK);
	}

}
