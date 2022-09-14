package com.apback.service.implementaciones;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apback.dto.response.PersonaRespuestaAdminDto;
import com.apback.dto.response.PersonaRespuestaPublicaDto;
import com.apback.model.DatosUsuario;
import com.apback.model.Persona;
import com.apback.repository.DatosUsuarioRepository;
import com.apback.repository.PersonaRepository;
import com.apback.service.IPersonaService;

@Service
public class PersonaService implements IPersonaService {

	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public PersonaRespuestaAdminDto getPersona(Integer id) {
		
		PersonaRespuestaAdminDto personaDto = new PersonaRespuestaAdminDto();
		
		Persona persona = personaRepository.getReferenceById(id);
		
		personaDto.setId(persona.getId());
		personaDto.setNombre(persona.getDatosUsuario().getNombre());
		personaDto.setApellido(persona.getDatosUsuario().getApellido());
		personaDto.setEmail(persona.getDatosUsuario().getEmail());
		
		return personaDto;
	}

	@Override
	@Transactional
	public Boolean createPersona() {

		Persona persona = new Persona();

		try {
			personaRepository.save(persona);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	@Transactional
	public Boolean deletePersona(Integer id) {

		try {
			personaRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public List<PersonaRespuestaPublicaDto> getAllPersonas() {
		
		List<Persona> personas = personaRepository.findAll();
		List<PersonaRespuestaPublicaDto> personasDto= new ArrayList<>();
		
		
		for (Persona persona : personas) {
			
			PersonaRespuestaPublicaDto personaDto = new PersonaRespuestaPublicaDto();
			
			
			personaDto.setNombre(persona.getDatosUsuario().getNombre());
			personaDto.setApellido(persona.getDatosUsuario().getApellido());
		
		
			personasDto.add(personaDto);
		}
		
		return personasDto;
	}

}
