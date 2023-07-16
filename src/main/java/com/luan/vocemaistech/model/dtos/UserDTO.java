package com.luan.vocemaistech.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luan.vocemaistech.model.User;
import com.luan.vocemaistech.model.enums.Profile;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public record UserDTO(
        Long id,
        @NotNull(message = "Campo requerido") String name,
        String cpf,
        @NotNull(message = "Campo requerido") String email,
        @NotNull(message = "Campo requerido") String password,
        @JsonFormat(pattern = "dd/MM/yyyy") LocalDate memberSince,
        Set<Integer> profile,
        Set<String> profileDescription) {

    public UserDTO(User obj) {
        this(obj.getId(),
                obj.getName(),
                obj.getCpf(),
                obj.getEmail(),
                obj.getPassword(),
                obj.getMemberSince(),
                obj.getProfile().stream().map(Profile::getCode).collect(Collectors.toSet()),
                obj.getProfile().stream().map(Profile::getDescription).collect(Collectors.toSet()));
    }

}
