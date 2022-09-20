package com.apback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apback.model.Estudio;

@Repository
public interface EstudioRepository extends JpaRepository<Estudio, Integer>{

	@Query(value = "SELECT * FROM estudios WHERE persona_id = ?1", nativeQuery = true)
	List<Estudio> findAllEstudioByUsuarioId(Integer id);
}
