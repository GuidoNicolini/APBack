package com.apback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apback.model.Estudio;

@Repository
public interface EstudioRepository extends JpaRepository<Estudio, Integer>{

}
