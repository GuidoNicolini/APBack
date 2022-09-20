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

import com.apback.dto.request.HabilidadDto;
import com.apback.repository.HabilidadRepository;
import com.apback.service.interfaces.IHabilidadService;

@RestController
@RequestMapping("/habilidad")
public class HabilidadController {
	@Autowired
	private IHabilidadService habilidadService;

	@Autowired
	private HabilidadRepository habilidadRepository;

	@GetMapping("/{id}")
	@PreAuthorize("permitAll()")
	public ResponseEntity<HabilidadDto> getHabilidad(@PathVariable Integer id) {

		if (habilidadRepository.existsById(id)) {

			HabilidadDto habilidadDto = habilidadService.getHabilidad(id);
			return ResponseEntity.ok(habilidadDto);
		} else {
			return ResponseEntity.notFound().build();

		}
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> deleteHabilidad(@PathVariable Integer id) {

		try {
			Boolean respuesta = habilidadService.deleteHabilidad(id);
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
	public ResponseEntity<String> updateHabilidad(@Valid @RequestBody HabilidadDto habilidadDto,
			@PathVariable Integer id) {

		try {
			Boolean respuesta = habilidadService.updateHabilidad(habilidadDto, id);
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
	public ResponseEntity<String> createHabilidad(@Valid @RequestBody HabilidadDto habilidadDto,
			@PathVariable Integer id) {

		try {
			Boolean respuesta = habilidadService.createHabilidad(habilidadDto, id);
			if (respuesta) {
				return new ResponseEntity<>("Habilidad creada con exito", HttpStatus.CREATED);
			} else {
				return ResponseEntity.badRequest().body("Error en la creación de la Habilidad");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error en la creación de la Habilidad");
		}
	}

	@GetMapping("/all")
	@PreAuthorize("permitAll()")
	public ResponseEntity<List<HabilidadDto>> getAllHabilidades() {

		List<HabilidadDto> habilidades = habilidadService.getAllHabilidades();

		return ResponseEntity.ok(habilidades);
}
	@GetMapping("/all/{id}")
	@PreAuthorize("permitAll()")
	public ResponseEntity<List<HabilidadDto>> getAllHabilidadesByIdPersona(@PathVariable Integer id) {

		List<HabilidadDto> habilidades = habilidadService.getAllHabilidadesByIdPersona(id);

		return ResponseEntity.ok(habilidades);
}
}
