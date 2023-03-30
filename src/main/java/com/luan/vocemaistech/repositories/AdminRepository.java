package com.luan.vocemaistech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luan.vocemaistech.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
