package com.luan.vocemaistech.services;

import com.luan.vocemaistech.model.Person;
import com.luan.vocemaistech.model.User;
import com.luan.vocemaistech.model.dtos.UserDTO;
import com.luan.vocemaistech.repositories.PersonRepository;
import com.luan.vocemaistech.repositories.UserRepository;
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
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder encoder;

    public List<UserDTO> findAll() {
        List<User> list = repository.findAll();
        return list.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("ID não foi encontrado, ID:" + id));
    }

    public UserDTO findByEmail(String email) {
        Optional<User> obj = repository.findByEmail(email);
        return new UserDTO(obj.orElseThrow(() -> new ObjectNotFoundException("This EMAIL not found for User Person, EMAIL:" + email)));
    }

    public User create(UserDTO objDTO) {
        User newObj = new User(objDTO);
        newObj.setId(null);
        newObj.setPassword(encoder.encode(objDTO.password()));
        validaPorCpfEEmail(objDTO);
        return repository.save(newObj);
    }

    public UserDTO update(Long id, @Valid UserDTO objDTO) {
        User oldObj = findById(id);
        User newObj = new User(objDTO);
        newObj.setId(id);
        if (!objDTO.password().equals(oldObj.getPassword()))
            newObj.setPassword(encoder.encode(objDTO.password()));
        validaPorCpfEEmail(objDTO);
        repository.save(newObj);

        return new UserDTO(newObj);
    }

    public void delete(Long id) {
        User obj = findById(id);
        if (obj.getPostsBlog().size() > 0) {
            throw new DataIntegrityViolationException("Esse usuário não pode ser deletado pois possui postagens.");
        }
        repository.deleteById(id);
    }

    private void validaPorCpfEEmail(UserDTO objDTO) {
        if (objDTO.cpf() != null && !objDTO.cpf().isEmpty()) {
            Optional<Person> obj = personRepository.findByCpf(objDTO.cpf());
            if (obj.isPresent() && obj.get().getId() != objDTO.id()) {
                throw new DataIntegrityViolationException("CPF Já cadastrado no sistema!");
            }
        } else {
            Optional<Person> obj = personRepository.findByCpf(objDTO.cpf());
            obj = personRepository.findByEmail(objDTO.email());
            if (obj.isPresent() && obj.get().getId() != objDTO.id()) {
                throw new DataIntegrityViolationException("E-mail Já cadastrado no sistema!");
            }
        }
    }
}
