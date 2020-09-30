package com.sm.schoolManagement.service.facade;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.sm.schoolManagement.bean.MatiereItem;

public interface MatiereItemService {
	MatiereItem findByid(Long id);
	List<MatiereItem> findAll();
	public ResponseEntity<MatiereItem> edit(MatiereItem niveau);
	int deleteById(Long id);
	public Page<MatiereItem> findAllWithPagination(int page, int size, String sort);
	public ResponseEntity<MatiereItem> save(MatiereItem niveau);
	List<MatiereItem> findByMatiereNiveauLibelle(String libelle);
}
