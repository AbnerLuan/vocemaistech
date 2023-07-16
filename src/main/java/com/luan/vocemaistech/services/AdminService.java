package com.luan.vocemaistech.services;

import com.luan.vocemaistech.model.Admin;
import com.luan.vocemaistech.model.Person;
import com.luan.vocemaistech.model.dtos.AdminDTO;
import com.luan.vocemaistech.repositories.AdminRepository;
import com.luan.vocemaistech.repositories.PersonRepository;
import com.luan.vocemaistech.services.exceptions.DataIntegrityViolationException;
import com.luan.vocemaistech.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder encoder;

    public AdminDTO findById(Long id) {
        Optional<Admin> obj = repository.findById(id);
        return new AdminDTO(obj.orElseThrow(() -> new ObjectNotFoundException("Este ID não foi encontrado, ID:" + id)));
    }

    public List<AdminDTO> findAll() {
        List<Admin> list = repository.findAll();
        return list.stream().map(AdminDTO::new).collect(Collectors.toList());
    }

    public Admin create(AdminDTO objDTO) {
        Admin newObj = new Admin(objDTO);
        newObj.setId(null);
        newObj.setPassword(encoder.encode(objDTO.password()));
        validaPorCpfEEmail(objDTO);
        return repository.save(newObj);
    }

    public AdminDTO update(Long id, @Valid AdminDTO objDTO) {
        AdminDTO oldObj = findById(id);
        Admin newObj = new Admin(objDTO);
        newObj.setId(id);
        if (!objDTO.password().equals(oldObj.password()))
            newObj.setPassword(encoder.encode(objDTO.password()));
        validaPorCpfEEmail(objDTO);
        repository.save(newObj);
        return new AdminDTO(newObj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void validaPorCpfEEmail(AdminDTO objDTO) {
        Optional<Person> obj = personRepository.findByCpf(objDTO.cpf());
        if (obj.isPresent() && obj.get().getId() != objDTO.id()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
        }
        obj = personRepository.findByEmail(objDTO.email());
        if (obj.isPresent() && obj.get().getId() != objDTO.id()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
        }
    }

}
