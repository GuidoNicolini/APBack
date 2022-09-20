package com.apback.service.interfaces;

import java.util.List;

import com.apback.dto.request.HabilidadDto;

public interface IHabilidadService {
	
	HabilidadDto getHabilidad(Integer id);
	Boolean createHabilidad(HabilidadDto habilidadDto,Integer id);
	Boolean deleteHabilidad(Integer id);
	Boolean updateHabilidad(HabilidadDto habilidadDto,Integer id);
	List<HabilidadDto> getAllHabilidades();
	List<HabilidadDto> getAllHabilidadesByIdPersona(Integer id);
}
