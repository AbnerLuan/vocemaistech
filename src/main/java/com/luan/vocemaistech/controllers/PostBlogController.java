package com.luan.vocemaistech.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luan.vocemaistech.model.PostBlog;
import com.luan.vocemaistech.model.dtos.PostBlogDTO;
import com.luan.vocemaistech.model.enums.CategoryPost;
import com.luan.vocemaistech.services.PostBlogService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/postsblog")
public class PostBlogController {

	@Autowired
	private PostBlogService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<PostBlogDTO> findById(@PathVariable Long id) {
		PostBlog obj = service.findById(id);
		return ResponseEntity.ok().body(new PostBlogDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<PostBlogDTO>> findAll() {
		List<PostBlog> list = service.findAll();
		List<PostBlogDTO> listDTO = list.stream().map(obj -> new PostBlogDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}        
	
	@GetMapping(value = "/categoryPost/{cod}")
	public ResponseEntity<List<PostBlog>> findByCategoryPost(@PathVariable CategoryPost cod) {
		Sort sort = Sort.by("id").descending();
		List<PostBlog> list = service.findByCategoryPost(cod, sort);		
		return ResponseEntity.ok().body(list);
	}	
	

//	@GetMapping
//	public ResponseEntity<Object> findAllPaginator(
//			@PageableDefault(page = 0, size = 9, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
//		return ResponseEntity.ok().body(service.findAllPaginator(pageable));
//	}

	@PostMapping
	ResponseEntity<PostBlogDTO> create(@RequestBody @Valid PostBlogDTO objDTO) {
		PostBlog newObj = service.create(objDTO);
		PostBlogDTO obj = new PostBlogDTO(newObj);
		return ResponseEntity.ok().body(obj);
	}

	@PutMapping(value = "/{id}")
	ResponseEntity<PostBlogDTO> update(@Valid @PathVariable Long id, @RequestBody PostBlogDTO objDTO) {
		PostBlog newObj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new PostBlogDTO(newObj));
	}

	@DeleteMapping(value = "/{id}")
	ResponseEntity<PostBlogDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
