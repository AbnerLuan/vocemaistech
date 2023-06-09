package com.luan.vocemaistech.model.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luan.vocemaistech.model.User;
import com.luan.vocemaistech.model.enums.Profile;

import jakarta.validation.constraints.NotNull;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	protected Long id;

	@NotNull(message = "Field Required")
	protected String name;

	protected String cpf;

	@NotNull
	protected String email;

	@NotNull
	protected String password;

	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate memberSince = LocalDate.now();

	protected Set<Integer> profile = new HashSet<>();

	protected Set<String> profileDescription;

	public UserDTO() {
		super();
		addProfile(Profile.USER);
	}

	public UserDTO(User obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.memberSince = obj.getMemberSince();
		this.profile = obj.getProfile().stream().map(x -> x.getCode()).collect(Collectors.toSet());
		this.profileDescription = obj.getProfile().stream().map(x -> x.getDescription()).collect(Collectors.toSet());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getMemberSince() {
		return memberSince;
	}

	public void setMemberSince(LocalDate memberSince) {
		this.memberSince = memberSince;
	}

	public Set<Integer> getProfile() {
		return profile;
	}

	public void addProfile(Profile profile) {
		this.profile.add(profile.getCode());
	}

	public Set<String> getProfileDescription() {
		return profileDescription;
	}

	public void setProfileDescription(Set<String> profileDescription) {
		this.profileDescription = profileDescription;
	}

}
