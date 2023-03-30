package com.luan.vocemaistech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.luan.vocemaistech.model.Admin;
import com.luan.vocemaistech.model.Person;
import com.luan.vocemaistech.model.dtos.AdminDTO;
import com.luan.vocemaistech.repositories.AdminRepository;
import com.luan.vocemaistech.repositories.PersonRepository;
import com.luan.vocemaistech.services.exceptions.DataIntegrityViolationException;
import com.luan.vocemaistech.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PasswordEncoder encoder;

	public Admin findById(Long id) {
		Optional<Admin> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("This ID not found for Admin Person, ID:" + id));
	}

	public List<Admin> findAll() {
		return repository.findAll();
	}

	public Admin create(AdminDTO objDTO) {
		objDTO.setId(null);
		objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		validaPorCpfEEmail(objDTO);
		Admin newObj = new Admin(objDTO);
		return repository.save(newObj);
	}

	private void validaPorCpfEEmail(AdminDTO objDTO) {
		Optional<Person> obj = personRepository.findByCpf(objDTO.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF already registered in the system");
		}
		obj = personRepository.findByEmail(objDTO.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-MAIL already registered in the system");
		}
	}

	public Admin update(Long id, @Valid AdminDTO objDTO) {
		objDTO.setId(id);
		Admin oldObj = findById(id);
		if (!objDTO.getPassword().equals(oldObj.getPassword()))
			objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		validaPorCpfEEmail(objDTO);
		oldObj = new Admin(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
