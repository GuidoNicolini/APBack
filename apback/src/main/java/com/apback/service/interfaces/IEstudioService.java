package com.apback.service.interfaces;

import com.apback.dto.request.EstudioDto;


public interface IEstudioService {

	
	EstudioDto getEstudio(Integer id);
	Boolean createEstudio(EstudioDto estudioDto);
	Boolean deleteEstudio(Integer id);
	Boolean updateEstudio(EstudioDto estudioDto,Integer id);
	
}
