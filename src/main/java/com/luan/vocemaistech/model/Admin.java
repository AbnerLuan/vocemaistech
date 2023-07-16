package com.luan.vocemaistech.model;

import com.luan.vocemaistech.model.dtos.AdminDTO;
import com.luan.vocemaistech.model.enums.Profile;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
		this.id = obj.id();
		this.name = obj.name();
		this.cpf = obj.cpf();
		this.email = obj.email();
		this.password = obj.password();
		this.memberSince = obj.memberSince();
		this.profile = obj.profile();

	}

}
