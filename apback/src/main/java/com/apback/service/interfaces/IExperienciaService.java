package com.apback.service.interfaces;

import java.util.List;

import com.apback.dto.request.ExperienciaDto;

public interface IExperienciaService {

		
	ExperienciaDto getExperiencia(Integer id);
	Boolean createExperiencia(ExperienciaDto experienciaDto,Integer id);
	Boolean deleteExperiencia(Integer id);
	Boolean updateExperiencia(ExperienciaDto experienciaDto,Integer id);
	List<ExperienciaDto> getAllExperiencias();
}
