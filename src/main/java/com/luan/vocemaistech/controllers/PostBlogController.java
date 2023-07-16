package com.luan.vocemaistech.controllers;

import com.luan.vocemaistech.model.PostBlog;
import com.luan.vocemaistech.model.dtos.PostBlogDTO;
import com.luan.vocemaistech.model.enums.CategoryPost;
import com.luan.vocemaistech.services.PostBlogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/postsblog")
public class PostBlogController {

	@Autowired
	private PostBlogService service;

	@GetMapping
	public ResponseEntity<Page<PostBlogDTO>> findAll(@PageableDefault(sort = "id",
			direction = Sort.Direction.DESC,
			page = 0,
			size = 9) Pageable pageable) {
		Page<PostBlogDTO> postBlogDTOPage = service.findAllPageable(pageable);
		return ResponseEntity.ok().body(postBlogDTOPage);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PostBlogDTO> findById(@PathVariable Long id) {
		PostBlogDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/categoryPost/{cod}")
	public ResponseEntity<List<PostBlog>> findByCategoryPost(@PathVariable CategoryPost cod) {
		Sort sort = Sort.by("id").descending();
		List<PostBlog> list = service.findByCategoryPost(cod, sort);		
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	ResponseEntity<PostBlogDTO> create(@RequestBody @Valid PostBlogDTO objDTO) {
		PostBlogDTO obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.id()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	ResponseEntity<PostBlogDTO> update(@Valid @PathVariable Long id, @RequestBody PostBlogDTO objDTO) {
		PostBlogDTO newObjDto = service.update(id, objDTO);
		return ResponseEntity.ok().body(newObjDto);
	}

	@DeleteMapping(value = "/{id}")
	ResponseEntity<PostBlogDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
