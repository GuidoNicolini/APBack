package com.apback.service.interfaces;

import com.apback.dto.request.ExperienciaDto;

public interface IExperienciaService {

		
	ExperienciaDto getExperiencia(Integer id);
	Boolean createExperiencia(ExperienciaDto experienciaDto);
	Boolean deleteExperiencia(Integer id);
	Boolean updateExperiencia(ExperienciaDto experienciaDto,Integer id);
}
