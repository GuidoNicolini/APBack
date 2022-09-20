package com.apback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apback.model.Experiencia;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer> {

	@Query(value = "SELECT * FROM experiencias WHERE persona_id = ?1", nativeQuery = true)
	List<Experiencia> findAllExperienciaByUsuarioId(Integer id);
}
