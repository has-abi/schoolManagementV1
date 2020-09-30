package com.sm.schoolManagement.service.facade;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.sm.schoolManagement.bean.Devoir;

public interface DevoirService {
	Devoir findByid(Long id);

	List<Devoir> findAll();

	ResponseEntity<Devoir> save(Devoir niveau);

	ResponseEntity<Devoir> edit(Devoir niveau);

	int deleteById(Long id);

	public Page<Devoir> findAllWithPagination(int page, int size, String sort);

	public void init();

	public void save(MultipartFile file);

	public UrlResource load(String filename);

	public void deleteAll();

	public Stream<Path> loadAll();

	Devoir findByFileName(String fileName);
}
