package com.apback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apback.dto.response.PersonaRespuestaAdminDto;
import com.apback.dto.response.PersonaRespuestaPublicaDto;
import com.apback.repository.PersonaRepository;
import com.apback.service.implementaciones.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@Autowired
	private PersonaRepository personaRepository;

	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<PersonaRespuestaAdminDto> getPersona(@PathVariable Integer id) {

		if (personaRepository.existsById(id)) {

			PersonaRespuestaAdminDto persona = personaService.getPersona(id);

			return ResponseEntity.ok().body(persona);
		} else {

			return ResponseEntity.notFound().build();

		}
	}

	@PutMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> createPersona() {

		try {
			Boolean respuesta = personaService.createPersona();
			if (respuesta) {
				return new ResponseEntity<>("Persona creada con exito", HttpStatus.CREATED);
			} else {
				return ResponseEntity.badRequest().body("Error en la creación de la persona");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error en la creación de la persona");
		}
	}

	@DeleteMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> deletePersona(@PathVariable Integer id) {

		try {
			Boolean respuesta = personaService.deletePersona(id);
			if (respuesta) {
				return new ResponseEntity<>("Persona borrada con exito", HttpStatus.CREATED);
			} else {
				return ResponseEntity.badRequest().body("Error en la eliminación de la persona");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error en la eliminación de la persona");
		}

	}

	@GetMapping
	@PreAuthorize("permitAll()")
	public ResponseEntity<List<PersonaRespuestaPublicaDto>> getAllPersonas() {

		List<PersonaRespuestaPublicaDto> personas = personaService.getAllPersonas();

		return ResponseEntity.ok(personas);

	}

}
