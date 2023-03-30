package com.luan.vocemaistech.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luan.vocemaistech.model.dtos.UserDTO;
import com.luan.vocemaistech.model.enums.Profile;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class User extends Person {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@OneToMany(mappedBy = "author")
	private List<PostBlog> postsBlog = new ArrayList<>();

	public User() {
		super();
		addProfile(Profile.USER);
	}	


	public User(Long id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
		addProfile(Profile.USER);
	}

	public User(UserDTO obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.memberSince = obj.getMemberSince();
		this.profile = obj.getProfile();
	}

	public List<PostBlog> getPostsBlog() {
		return postsBlog;
	}

	public void setPostsBlog(List<PostBlog> postsBlog) {
		this.postsBlog = postsBlog;
	}

}
