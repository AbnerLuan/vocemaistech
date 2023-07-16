package com.luan.vocemaistech.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luan.vocemaistech.model.Admin;
import com.luan.vocemaistech.model.enums.Profile;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public record AdminDTO(
        Long id,
        String name,
        String cpf,
        String email,
        String password,
        @JsonFormat(pattern = "dd/MM/yyyy") LocalDate memberSince,
        Set<Integer> profile) {


    public AdminDTO(Admin obj) {
        this(obj.getId(),
                obj.getName(),
                obj.getCpf(),
                obj.getEmail(),
                obj.getPassword(),
                obj.getMemberSince(),
                obj.getProfile().stream().map(Profile::getCode).collect(Collectors.toSet()));

    }
}
