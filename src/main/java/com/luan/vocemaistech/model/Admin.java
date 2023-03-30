package com.luan.vocemaistech.model;

import java.util.stream.Collectors;

import com.luan.vocemaistech.model.dtos.AdminDTO;
import com.luan.vocemaistech.model.enums.Profile;

import jakarta.persistence.Entity;

@Entity
public class Admin extends Person {

	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
		addProfile(Profile.ADMIN);
	}

	public Admin(Long id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
		addProfile(Profile.ADMIN);
	}

	public Admin(AdminDTO obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.memberSince = obj.getMemberSince();
		this.profile = obj.getProfile().stream().map(x -> x.getCode()).collect(Collectors.toSet());

	}

}
