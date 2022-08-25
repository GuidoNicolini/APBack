package com.apback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apback.model.Habilidad;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Long> {

}
