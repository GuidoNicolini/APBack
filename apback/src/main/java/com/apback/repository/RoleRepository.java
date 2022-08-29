package com.apback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apback.security.entity.Rol;

@Repository
public interface RoleRepository extends JpaRepository<Rol, Long> {

}
