package com.apback.service;

import com.apback.dto.request.DatosUsuarioDto;
import com.apback.model.DatosUsuario;

public interface IDatosUsuario {

	DatosUsuarioDto getDatosUsuario(Integer id);
	Boolean createDatosUsuario(DatosUsuarioDto datosUsuarioDto);
	Boolean deleteDatosUsuario(Integer id);
	Boolean updateDatosUsuario(DatosUsuarioDto datosUsuarioDto, Integer id);
}
