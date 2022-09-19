package com.apback.service.interfaces;

import java.util.List;

import com.apback.dto.request.ProyectoDto;

public interface IProyectoService {

	ProyectoDto getProyecto(Integer id);

	Boolean createProyecto(ProyectoDto proyectoDto,Integer id);

	Boolean deleteProyecto(Integer id);

	Boolean updateProyecto(ProyectoDto proyectoDto, Integer id);
	
	List<ProyectoDto> getAllProyectos();

}
