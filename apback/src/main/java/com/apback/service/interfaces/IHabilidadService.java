package com.apback.service.interfaces;

import com.apback.dto.request.HabilidadDto;

public interface IHabilidadService {
	
	HabilidadDto getHabilidad(Integer id);
	Boolean createHabilidad(HabilidadDto habilidadDto,Integer id);
	Boolean deleteHabilidad(Integer id);
	Boolean updateHabilidad(HabilidadDto habilidadDto,Integer id);
}
