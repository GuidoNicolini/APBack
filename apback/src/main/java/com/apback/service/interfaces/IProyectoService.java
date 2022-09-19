package com.apback.service.interfaces;

import com.apback.dto.request.ProyectoDto;

public interface IProyectoService {

	ProyectoDto getProyecto(Integer id);

	Boolean createProyecto(ProyectoDto proyectoDto);

	Boolean deleteProyecto(Integer id);

	Boolean updateProyecto(ProyectoDto proyectoDto, Integer id);

}
