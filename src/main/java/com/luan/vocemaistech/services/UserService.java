package com.luan.vocemaistech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.luan.vocemaistech.model.Person;
import com.luan.vocemaistech.model.User;
import com.luan.vocemaistech.model.dtos.UserDTO;
import com.luan.vocemaistech.repositories.PersonRepository;
import com.luan.vocemaistech.repositories.UserRepository;
import com.luan.vocemaistech.services.exceptions.DataIntegrityViolationException;
import com.luan.vocemaistech.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PasswordEncoder encoder;

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("This ID not found for User Person, ID:" + id));
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public User create(UserDTO objDTO) {
		objDTO.setId(null);
		objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		validaPorCpfEEmail(objDTO);
		User newObj = new User(objDTO);
		return repository.save(newObj);
	}

	private void validaPorCpfEEmail(UserDTO objDTO) {
		if (objDTO.getCpf() != null && !objDTO.getCpf().isEmpty()) {
			Optional<Person> obj = personRepository.findByCpf(objDTO.getCpf());
			if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
				throw new DataIntegrityViolationException("CPF Já cadastrado no sistema!");
			}
		} else {
			Optional<Person> obj = personRepository.findByCpf(objDTO.getCpf());
			obj = personRepository.findByEmail(objDTO.getEmail());
			if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
				throw new DataIntegrityViolationException("E-MAIL Já cadastrado no sistema!");
			}
		}
	}

	public User update(Long id, @Valid UserDTO objDTO) {
		objDTO.setId(id);
		User oldObj = findById(id);
		if (!objDTO.getPassword().equals(oldObj.getPassword()))
			objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		validaPorCpfEEmail(objDTO);
		oldObj = new User(objDTO);
		return repository.save(oldObj);
	}

	public User findByEmail(String email) {
		Optional<User> obj = repository.findByEmail(email);
		return obj
				.orElseThrow(() -> new ObjectNotFoundException("This EMAIL not found for User Person, EMAIL:" + email));
	}

	public void delete(Long id) {
		User obj = findById(id);
		if (obj.getPostsBlog().size() > 0) {
			throw new DataIntegrityViolationException("Esse usuário não pode ser deletado pois possui postagens.");
		}
		repository.deleteById(id);
	}

}
