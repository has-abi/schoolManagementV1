package com.sm.schoolManagement.wsRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.google.common.net.HttpHeaders;
import com.sm.schoolManagement.bean.Devoir;
import com.sm.schoolManagement.service.facade.DevoirService;

import io.github.classgraph.Resource;
import springfox.documentation.service.ResponseMessage;
@RequestMapping("schoolManagement-Api/Devoir/")
@RestController
public class DevoirRest {
	@Autowired
	private DevoirService coursService;
public Page<Devoir> findAllWithPagination(int page, int size, String sort) {
		return coursService.findAllWithPagination(page, size, sort);
	}
@GetMapping("findByid/id/{id}")
	public Devoir findByid(@PathVariable Long id) {
		return coursService.findByid(id);
	}
@GetMapping("findAll")
	public List<Devoir> findAll() {
		return coursService.findAll();
	}
@PostMapping("save")
	public ResponseEntity<Devoir> save(@RequestBody Devoir Devoir) {
		return coursService.save(Devoir);
	}
@PostMapping("edit")
	public ResponseEntity<Devoir> edit(Devoir Devoir) {
		return coursService.edit(Devoir);
	}
@DeleteMapping("deleteById/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return coursService.deleteById(id);
	}
@PostMapping("upload")
public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
  String message = "";
  try {
System.out.println(file.getOriginalFilename()); 
    coursService.save(file);
    message = "Uploaded the file successfully: " + file.getOriginalFilename();
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(0, message, null, null, null, null));
  } catch (Exception e) {
    message = "Could not upload the file: " + file.getOriginalFilename() + "!";
    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(0, message, null, null, null, null));
  }
}

@GetMapping("files")
public ResponseEntity<List<Devoir>> getListFiles() {
	List<Devoir> fileInfos = findAll();
	for (Devoir devoir : fileInfos) {
		System.out.println(devoir.getFileName());
		String url = MvcUriComponentsBuilder
		        .fromMethodName(DevoirRest.class, "getFile", devoir.getFileName().toString()).build().toString();
		devoir.setFileUrl(url);
		coursService.edit(devoir);
	}
  return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
}

@GetMapping("files/{filename:.+}")
@ResponseBody
public ResponseEntity<UrlResource> getFile(@PathVariable String filename) {
	UrlResource file = (UrlResource) coursService.load(filename);
  return ResponseEntity.ok()
      .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + ((org.springframework.core.io.Resource) file).getFilename() + "\"").body(file);
}
	

}
