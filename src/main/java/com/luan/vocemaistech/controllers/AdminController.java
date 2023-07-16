package com.luan.vocemaistech.controllers;

import com.luan.vocemaistech.model.Admin;
import com.luan.vocemaistech.model.dtos.AdminDTO;
import com.luan.vocemaistech.services.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/admins")
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping
    public ResponseEntity<List<AdminDTO>> findAll() {
        List<AdminDTO> listDTO = service.findAll();
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AdminDTO> findById(@PathVariable Long id) {
        AdminDTO objDTO = service.findById(id);
        return ResponseEntity.ok().body(objDTO);
    }

    @PostMapping
    public ResponseEntity<AdminDTO> create(@RequestBody @Valid AdminDTO objDTO) {
        Admin newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AdminDTO> update(@PathVariable Long id, @Valid @RequestBody AdminDTO objDTO) {
        AdminDTO obj = service.update(id, objDTO);
        return ResponseEntity.ok().body(obj);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AdminDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
