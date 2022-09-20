package com.apback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.apback.model.Habilidad;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Integer> {

	@Query(value = "SELECT * FROM habilidades WHERE persona_id = ?1", nativeQuery = true)
	List<Habilidad> findAllHabilidadByUsuarioId(Integer id);
	
}
