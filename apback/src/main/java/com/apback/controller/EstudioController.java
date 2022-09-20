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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apback.dto.request.EstudioDto;
import com.apback.repository.EstudioRepository;
import com.apback.service.interfaces.IEstudioService;

@RestController
@RequestMapping("/estudio")
public class EstudioController {

	@Autowired
	private IEstudioService estudioService;

	@Autowired
	private EstudioRepository estudioRepository;

	@GetMapping("/{id}")
	@PreAuthorize("permitAll()")
	public ResponseEntity<EstudioDto> getEstudio(@PathVariable Integer id) {

		if (estudioRepository.existsById(id)) {

			EstudioDto estudioDto = estudioService.getEstudio(id);
			return ResponseEntity.ok(estudioDto);
		} else {
			return ResponseEntity.notFound().build();

		}
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> deleteEstudio(@PathVariable Integer id) {

		try {
			Boolean respuesta = estudioService.deleteEstudio(id);
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
	public ResponseEntity<String> updateEstudio(@Valid @RequestBody EstudioDto estudioDto, @PathVariable Integer id) {

		try {
			Boolean respuesta = estudioService.updateEstudio(estudioDto, id);
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
	public ResponseEntity<String> createEstudio(@Valid @RequestBody EstudioDto estudioDto, @PathVariable Integer id) {

		try {
			Boolean respuesta = estudioService.createEstudio(estudioDto,id);
			if (respuesta) {
				return new ResponseEntity<>("Estudio creado con exito", HttpStatus.CREATED);
			} else {
				return ResponseEntity.badRequest().body("Error en la creación del Estudio");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error en la creación del Estudio");
		}
	}
	
	@GetMapping("/all")
	@PreAuthorize("permitAll()")
	public ResponseEntity<List<EstudioDto>> getAllEstudios() {

		List<EstudioDto> estudios = estudioService.getAllEstudios();
		
		return ResponseEntity.ok(estudios);
	}
	
	@GetMapping("/all/{id}")
	@PreAuthorize("permitAll()")
	public ResponseEntity<List<EstudioDto>> getAllEstudiosByPersonaId(@PathVariable Integer id) {

		List<EstudioDto> estudios = estudioService.getAllEstudiosByIdPersona(id);
		
		return ResponseEntity.ok(estudios);
	}
	
}
