package com.luan.vocemaistech.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luan.vocemaistech.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	Optional<Person> findByCpf(String cpf);

	Optional<Person> findByEmail(String email);

}
