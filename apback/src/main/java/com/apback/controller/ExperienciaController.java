package com.apback.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apback.dto.request.ExperienciaDto;
import com.apback.repository.ExperienciaRepository;
import com.apback.service.implementaciones.ExperienciaService;
import com.apback.service.interfaces.IExperienciaService;

@RestController
@RequestMapping("/experiencia")
public class ExperienciaController {

	@Autowired
	private IExperienciaService experienciaService;

	@Autowired
	private ExperienciaRepository experienciaRepository;

	@GetMapping("/{id}")
	@PreAuthorize("permitAll()")
	public ResponseEntity<ExperienciaDto> getExperiencia(@PathVariable Integer id) {

		if (experienciaRepository.existsById(id)) {

			ExperienciaDto experienciaDto = experienciaService.getExperiencia(id);
			return ResponseEntity.ok(experienciaDto);
		} else {
			return ResponseEntity.notFound().build();

		}
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> deleteExperiencia(@PathVariable Integer id) {

		try {
			Boolean respuesta = experienciaService.deleteExperiencia(id);
			if (respuesta) {

				return ResponseEntity.ok("Datos borrados con exito");
			} else {
				return ResponseEntity.badRequest().body("No se han borrado los datos");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("No se han borrado los datos");
		}
	}

	@PatchMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> updateExperiencia(@Valid @RequestBody ExperienciaDto experienciaDto,
			@PathVariable Integer id) {

		try {
			Boolean respuesta = experienciaService.updateExperiencia(experienciaDto, id);
			if (respuesta) {

				return ResponseEntity.ok("Datos actualizados con exito");
			} else {
				return ResponseEntity.badRequest().body("No se han actualizado los datos");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("No se han actualizado los datos");
		}

	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> createExperiencia(@Valid @RequestBody ExperienciaDto experienciaDto,
			@PathVariable Integer id) {

		try {
			Boolean respuesta = experienciaService.createExperiencia(experienciaDto, id);
			if (respuesta) {
				return new ResponseEntity<>("Experiencia creada con exito", HttpStatus.CREATED);
			} else {
				return ResponseEntity.badRequest().body("Error en la creación de la Experiencia");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error en la creación de la Experiencia");
		}
	}

	@GetMapping("/all")
	@PreAuthorize("permitAll()")
	public ResponseEntity<List<ExperienciaDto>> getAllExperiencias() {

		List<ExperienciaDto> experiencias = experienciaService.getAllExperiencias();

		return ResponseEntity.ok(experiencias);
	}
	
	@GetMapping("/all/{id}")
	@PreAuthorize("permitAll()")
	public ResponseEntity<List<ExperienciaDto>> getAllExperienciasByIdPersona(@PathVariable Integer id) {

		List<ExperienciaDto> experiencias = experienciaService.getAllExperienciasByIdPersona(id);

		return ResponseEntity.ok(experiencias);
	}
}
