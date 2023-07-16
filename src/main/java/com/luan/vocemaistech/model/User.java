package com.luan.vocemaistech.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luan.vocemaistech.model.dtos.UserDTO;
import com.luan.vocemaistech.model.enums.Profile;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User extends Person {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(mappedBy = "id")
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
        this.id = obj.id();
        this.name = obj.name();
        this.cpf = obj.cpf();
        this.email = obj.email();
        this.password = obj.password();
        this.memberSince = obj.memberSince();
        this.profile = obj.profile();
    }

}
