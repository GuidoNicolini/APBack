package com.apback.service;


import java.util.List;

import com.apback.dto.response.PersonaRespuestaAdminDto;
import com.apback.dto.response.PersonaRespuestaPublicaDto;
import com.apback.model.Persona;


public interface IPersonaService{


	PersonaRespuestaAdminDto getPersona(Integer id);
	List<PersonaRespuestaPublicaDto> getAllPersonas();
	Boolean createPersona();
	Boolean deletePersona(Integer id);
	
}
