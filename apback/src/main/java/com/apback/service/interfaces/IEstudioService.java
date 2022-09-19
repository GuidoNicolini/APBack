package com.apback.service.interfaces;

import java.util.List;

import com.apback.dto.request.EstudioDto;


public interface IEstudioService {

	
	EstudioDto getEstudio(Integer id);
	Boolean createEstudio(EstudioDto estudioDto,Integer id);
	Boolean deleteEstudio(Integer id);
	Boolean updateEstudio(EstudioDto estudioDto,Integer id);
	List<EstudioDto> getAllEstudios();
	
}
