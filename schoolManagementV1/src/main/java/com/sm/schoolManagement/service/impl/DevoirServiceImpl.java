package com.sm.schoolManagement.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;
import io.github.classgraph.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sm.schoolManagement.bean.Devoir;
import com.sm.schoolManagement.dao.DevoirDao;
import com.sm.schoolManagement.exception.AlreadyExistsException;
import com.sm.schoolManagement.exception.NotFoundException;
import com.sm.schoolManagement.service.facade.DevoirService;
import com.sm.schoolManagement.service.facade.MatiereItemService;

@Service
public class DevoirServiceImpl implements DevoirService{
@Autowired
private DevoirDao coursDao;
private final Path root = Paths.get("uploads");

@Override
public Devoir findByid(Long id) {
	return coursDao.findById(id).get();
}

@Override
public List<Devoir> findAll() {
	return coursDao.findAll();
}

@Override
public ResponseEntity<Devoir> save(Devoir niveau) {
	if(niveau.getId() != null) {
		return null;
	}else {
		if(findByid(niveau.getId()) != null) {
			throw new AlreadyExistsException("un devoir avec cette Id est dèjà existe!");
		} else {
			//niveau.setMatiereItem(matiereItemService.findByid(niveau.getId()));
			return  new ResponseEntity<Devoir>(coursDao.save(niveau), HttpStatus.OK);			
		}
	}
}
@Override
public Page<Devoir> findAllWithPagination(int page, int size, String sort) {
	if (sort == "desc") {
		return coursDao.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")));
	} else {
		return coursDao.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id")));
	}
}
@Autowired
private MatiereItemService matiereItemService;
@Override
public ResponseEntity<Devoir> edit(Devoir niveau) {
	if(niveau.getId() == null) {
		return null;
	}else {
		if(findByid(niveau.getId()) == null) {
			throw new AlreadyExistsException("un devoir avec cette Id n'existe pas!");
		} else {
			//niveau.setMatiereItem(matiereItemService.findByid(niveau.getId()));
			return new ResponseEntity<Devoir>(coursDao.save(niveau), HttpStatus.OK);			
		}
	}
}

@Override
public int deleteById(Long id) {
	coursDao.deleteById(id);
	if(this.findByid(id) != null) {
		return -1;
	}else {
		return 1;		
	}
}


@Override
public void init() {
  try {
    Files.createDirectory(root);
  } catch (IOException e) {
    throw new RuntimeException("Could not initialize folder for upload!");
  }
}

@Override
public void save(MultipartFile file) {
  try {
    Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
  } catch (Exception e) {
    throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
  }
}

@Override
public UrlResource load(String filename) {
  try {
	  Devoir devoir = coursDao.findByFileName(filename);
    Path file = root.resolve(filename);
    UrlResource resource = new UrlResource(file.toUri());
    if (resource.exists() || resource.isReadable()) {
      return resource;
    } else {
      throw new RuntimeException("Could not read the file!");
    }
  } catch (MalformedURLException e) {
    throw new RuntimeException("Error: " + e.getMessage());
  }
}

@Override
public void deleteAll() {
  FileSystemUtils.deleteRecursively(root.toFile());
}

@Override
public Stream<Path> loadAll() {
  try {
    return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
  } catch (IOException e) {
    throw new RuntimeException("Could not load the files!");
  }
}

@Override
public Devoir findByFileName(String fileName) {
	return coursDao.findByFileName(fileName);
}
}
