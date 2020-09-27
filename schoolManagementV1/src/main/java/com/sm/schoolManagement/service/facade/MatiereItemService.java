package com.sm.schoolManagement.service.facade;

import java.util.List;

import com.sm.schoolManagement.bean.MatiereItem;

public interface MatiereItemService {
	MatiereItem findByid(Long id);
	List<MatiereItem> findAll();
	int save(MatiereItem matiereItem);
	int edit(MatiereItem matiereItem);
	int deleteById(Long id);
}
