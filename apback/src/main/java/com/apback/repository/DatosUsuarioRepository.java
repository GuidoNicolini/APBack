package com.apback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apback.model.DatosUsuario;

@Repository
public interface  DatosUsuarioRepository  extends JpaRepository<DatosUsuario, Long>{

}
