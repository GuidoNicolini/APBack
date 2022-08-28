package com.apback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apback.model.Rol;

@Repository
public interface RoleRepository extends JpaRepository<Rol, Long> {

}
