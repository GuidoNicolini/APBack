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
import com.apback.dto.request.ProyectoDto;
import com.apback.repository.ProyectoRepository;
import com.apback.service.interfaces.IProyectoService;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

	@Autowired
	private IProyectoService proyectoService;

	@Autowired
	private ProyectoRepository proyectoRepository;

	@GetMapping("/{id}")
	@PreAuthorize("permitAll()")
	public ResponseEntity<ProyectoDto> getProyecto(@PathVariable Integer id) {

		if (proyectoRepository.existsById(id)) {

			ProyectoDto proyectoDto = proyectoService.getProyecto(id);
			return ResponseEntity.ok(proyectoDto);
		} else {
			return ResponseEntity.notFound().build();

		}
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> deleteProyecto(@PathVariable Integer id) {

		try {
			Boolean respuesta = proyectoService.deleteProyecto(id);
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
	public ResponseEntity<String> updateProyecto(@Valid @RequestBody ProyectoDto proyectoDto,
			@PathVariable Integer id) {

		try {
			Boolean respuesta = proyectoService.updateProyecto(proyectoDto, id);
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
	public ResponseEntity<String> createProyecto(@Valid @RequestBody ProyectoDto proyectoDto,
			@PathVariable Integer id) {

		try {
			Boolean respuesta = proyectoService.createProyecto(proyectoDto, id);
			if (respuesta) {
				return new ResponseEntity<>("Proyecto creado con exito", HttpStatus.CREATED);
			} else {
				return ResponseEntity.badRequest().body("Error en la creación del proyecto");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error en la creación del proyecto");
		}
	}

	@GetMapping("/all")
	@PreAuthorize("permitAll()")
	public ResponseEntity<List<ProyectoDto>> getAllProyectos() {

		List<ProyectoDto> proyectos = proyectoService.getAllProyectos();

		return ResponseEntity.ok(proyectos);
	}
	
	@GetMapping("/all/{id}")
	@PreAuthorize("permitAll()")
	public ResponseEntity<List<ProyectoDto>> getAllProyectosByIdPersona(@PathVariable Integer id) {

		List<ProyectoDto> proyectos = proyectoService.getAllProyectosByIdPersona(id);

		return ResponseEntity.ok(proyectos);
	}
}
