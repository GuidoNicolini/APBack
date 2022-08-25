package com.apback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apback.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
