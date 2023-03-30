package com.luan.vocemaistech.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luan.vocemaistech.model.Admin;
import com.luan.vocemaistech.model.dtos.AdminDTO;
import com.luan.vocemaistech.services.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/admins")
public class AdminController {

	@Autowired
	private AdminService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<AdminDTO> findById(@PathVariable Long id) {
		Admin obj = service.findById(id);
		return ResponseEntity.ok().body(new AdminDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<AdminDTO>> findAll() {
		List<Admin> list = service.findAll();
		List<AdminDTO> listDTO = list.stream().map(obj -> new AdminDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<AdminDTO> create(@RequestBody @Valid AdminDTO objDTO) {
		Admin newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<AdminDTO> update(@PathVariable Long id, @Valid @RequestBody AdminDTO objDTO) {
		Admin obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new AdminDTO(obj));
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AdminDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
